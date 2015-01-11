package com.codari.api5.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.ClassUtils;
import net.minecraft.util.org.apache.commons.lang3.ObjectUtils;

import org.bukkit.Bukkit;

/**
 * Utility and wrapper class that aids the reflection process as well as provides
 * further utility for accessing classes in craftbukkit and the minecraft server.
 * <p>
 * This class provides static methods that abstract the process of reflection by
 * doing most of the work for you as well as handling any exceptions caused by a
 * failed reflection and instead throwing {@link ReflectionException} with the
 * cause being the exception that was thrown during reflection.
 * <p>
 * This class further abstracts reflection by wrapping any objects returned through
 * reflection within an instance of this class. Objects wrapped can be obtained with
 * the method {@link #getHandle()}. It is important to note that instances of
 * {@code Reflector} are immutable.
 * <p>
 * It is also important to note that reflection methods in this class ignore visibility
 * modifiers such as {@code private} and ignores the {@code final} modifier on fields.
 * The reason for this is because this class assumes that its users know what they
 * are reflecting and know if they should do so or not.
 * 
 * @author Soren025
 */
public final class Reflector {
	//-----Constants-----//
	private final static Field MODIFIERS = getFieldObject(Field.class, "modifiers");
	static {
		MODIFIERS.setAccessible(true);
	}
	
	/**
	 * Minecraft version of the running craftbukkit server.
	 * 
	 * @see {@link #NMS_PATH}, {@link #CB_PATH}.
	 */
	public final static String MINECRAFT_VERSION = Bukkit.getServer() != null ?
			Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] : "UNKNOWN";
	/**
	 * Base class path for NMS classes - {@code net.minecraft.server.{@link #MINECRAFT_VERSION}.
	 */
	public final static String NMS_PATH = "net.minecraft.server." + MINECRAFT_VERSION + ".";
	/**
	 * Base class path for CB classes - {@code org.bukkit.craftbukkit.{@link #MINECRAFT_VERSION}.
	 */
	public final static String CB_PATH = "org.bukkit.craftbukkit." + MINECRAFT_VERSION + ".";
	
	//-----Static Methods-----//
	public static Reflector executeExpression(Object obj, String expression, Object... args) {
		String[] parts = expression.split("\\.");
		for (String part : parts) {
			int argumentOpenerIndex = part.indexOf('(');
			if (argumentOpenerIndex != -1) {
				String methodName = part.substring(0, argumentOpenerIndex);
				if (part.charAt(argumentOpenerIndex + 1) == ')') {
					obj = invokeMethod0(obj.getClass(), obj, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY);
				} else {
					String[] argumentIndex = part.substring(
							argumentOpenerIndex + 1, part.indexOf(')')).split(",");
					Object[] arguments = new Object[argumentIndex.length];
					for (int i = 0; i < argumentIndex.length; i++) {
						arguments[i] = args[Integer.valueOf(argumentIndex[i]) - 1];
					}
					obj = invokeMethod0(obj.getClass(), obj, methodName, arguments);
				}
			} else {
				obj = readField0(obj.getClass(), obj, part);
			}
		}
		return new Reflector(obj);
	}
	
	//-------------------------Method Reflection-------------------------//
	
	/**
	 * Gets the {@code Method} object for a given {@code Class} that matches the provided
	 * name and parameter types, including methods declared in super classes as well.
	 * 
	 * @param clazz The {@code Class} object to search for the method in.
	 * @param methodName The name of the method.
	 * @param parameterTypes The parameter array.
	 * @return The {@code Method} object that matches the provided name and parameter types.
	 * 
	 * @throws ReflectionException Thrown if the method could not be found.
	 */
	public static Method getMethodObject(Class<?> clazz, String methodName, Class<?>... parameterTypes)
			throws ReflectionException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().equals(methodName) && Arrays.equals(m.getParameterTypes(), parameterTypes)) {
					return m;
				}
			}
		}
		NoSuchMethodException ex = new NoSuchMethodException(clazz + "." + methodName +
				argumentTypesToString(parameterTypes));
		throw new ReflectionException(ex);
	}
	
	private static Method getMethodObject0(Class<?> clazz, String methodName, Object[] args)
			throws ReflectionException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().equals(methodName) && isMatch(m.getParameterTypes(), args)) {
					return m;
				}
			}
		}
		NoSuchMethodException ex = new NoSuchMethodException(clazz + "." + methodName +
				argumentTypesToString(ClassUtils.toClass(args)));
		throw new ReflectionException("No match for object arguments", ex);
	}
	
	/**
	 * Invokes a given {@code Method} object.
	 * 
	 * @param method The {@code Method} object to invoke.
	 * @param obj The {@code Object} to invoke the method on.
	 * @param args The arguments to pass into the method.
	 * @return An instance of this class wrapping the {@code Object} returned by the
	 * 		method. The {@code Object} wrapped is {@code null} if the return type
	 * 		of the method is {@code void}.
	 * 
	 * @throws ReflectionException Thrown if the method failed to invoke for any reason.
	 */
	public static Reflector invokeMethodObject(Method method, Object obj, Object... args)
			throws ReflectionException {
		return new Reflector(invokeMethodObject0(method, obj, args));
	}
	
	private static Object invokeMethodObject0(Method method, Object obj, Object[] args)
			throws ReflectionException {
		try {
			method.setAccessible(true);
			return method.invoke(obj, args);
		} catch (InvocationTargetException ex) {
			throw new ReflectionException(ex.getCause());
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	/**
	 * Searches for and invokes the method for a given {@code Object} that matches
	 * the provided name along with being able to accept the provided arguments.
	 * 
	 * @param obj The {@code Object} to invoke the method on.
	 * @param methodName The name of the method.
	 * @param args The arguments to pass into the method.
	 * @return An instance of this class wrapping the {@code Object} returned by the
	 * 		method. The {@code Object} wrapped is {@code null} if the return type
	 * 		of the method is {@code void}.
	 * 
	 * @throws ReflectionException Thrown if the method failed to invoke for any reason.
	 */
	public static Reflector invokeMethod(Object obj, String methodName, Object... args)
			throws ReflectionException {
		return new Reflector(invokeMethod0(obj.getClass(), obj, methodName, args));
	}
	
	/**
	 * Searches for and invokes the static method for a given {@code Class} that matches
	 * the provided name along with being able to accept the provided arguments.
	 * 
	 * @param clazz The {@code Class} object to invoke the static method on.
	 * @param methodName The name of the static method.
	 * @param args The arguments to pass into the static method.
	 * @return An instance of this class wrapping the {@code Object} returned by the
	 * 		method. The {@code Object} wrapped is {@code null} if the return type
	 * 		of the method is {@code void}.
	 * 
	 * @throws ReflectionException Thrown if the static method failed to invoke for any reason.
	 */
	public static Reflector invokeStaticMethod(Class<?> clazz, String methodName, Object... args)
			throws ReflectionException {
		return new Reflector(invokeMethod0(clazz, null, methodName, args));
	}
	
	private static Object invokeMethod0(Class<?> clazz, Object obj, String methodName, Object[] args)
			throws ReflectionException {
		return invokeMethodObject0(getMethodObject0(clazz, methodName, args), obj, args);
	}
	
	//-------------------------Field Reflection-------------------------//
	
	/**
	 * Gets the {@code Field} object for a given {@code Class} that matches
	 * the provided name.
	 * 
	 * @param clazz The {@code Class} object to search for the field in.
	 * @param fieldName The name of the field.
	 * @return The {@code Field} object that matches the provided name.
	 * 
	 * @throws ReflectionException Thrown if the field could not be found.
	 */
	public static Field getFieldObject(Class<?> clazz, String fieldName)
			throws ReflectionException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Field f : clazz.getDeclaredFields()) {
				if (f.getName().equals(fieldName)) {
					return f;
				}
			}
		}
		NoSuchFieldException ex = new NoSuchFieldException(clazz + "." + fieldName);
		throw new ReflectionException(ex);
	}
	
	public static Reflector readFieldObject(Field field, Object obj)
			throws ReflectionException {
		return new Reflector(readFieldObject0(field, obj));
	}
	
	private static Object readFieldObject0(Field field, Object obj)
			throws ReflectionException {
		try {
			field.setAccessible(true);
			return field.get(obj);
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	public static Reflector readField(Object obj, String fieldName)
			throws ReflectionException {
		return new Reflector(readField0(obj.getClass(), obj, fieldName));
	}
	
	public static Reflector readStaticField(Class<?> clazz, String fieldName)
			throws ReflectionException {
		return new Reflector(readField0(clazz, null, fieldName));
	}
	
	private static Object readField0(Class<?> clazz, Object obj, String fieldName)
			throws ReflectionException {
		return readFieldObject0(getFieldObject(clazz, fieldName), obj);
	}
	
	public static void writeFieldObject(Field field, Object obj, Object value)
			throws ReflectionException {
		try {
			field.setAccessible(true);
			overrideFinal(field);
			field.set(obj, value);
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	private static void overrideFinal(Field field)
			throws IllegalArgumentException, IllegalAccessException {
		MODIFIERS.set(field, field.getModifiers() & ~Modifier.FINAL);
	}
	
	public static void writeField(Object obj, String fieldName, Object value)
			throws ReflectionException {
		writeField0(obj.getClass(), obj, fieldName, value);
	}
	
	public static void writeStaticField(Class<?> clazz, String fieldName, Object value)
			throws ReflectionException {
		writeField0(clazz, null, fieldName, value);
	}
	
	private static void writeField0(Class<?> clazz, Object obj, String fieldName, Object value)
			throws ReflectionException {
		writeFieldObject(getFieldObject(clazz, fieldName), obj, value);
	}
	
	//-------------------------Constructor Reflection-------------------------//
	
	/**
	 * Gets the {@code Constructor} object for a given {@code Class} that
	 * matches the provided parameter types.
	 * 
	 * @param clazz The {@code Class} object to search for the method in.
	 * @param parameterTypes The parameter array.
	 * @return The {@code Method} object that matches the provided parameter types.
	 * 
	 * @throws ReflectionException Thrown if the constructor could not be found.
	 */
	public static <T> Constructor<T> getConstructorObject(Class<T> clazz, Class<?>... parameterTypes)
			throws ReflectionException {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	private static Constructor<?> getConstructorObject0(Class<?> clazz, Object[] args) {
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (isMatch(c.getParameterTypes(), args)) {
				return c;
			}
		}
		NoSuchMethodException ex = new NoSuchMethodException(clazz + ".<init>" +
				argumentTypesToString(ClassUtils.toClass(args)));
		throw new ReflectionException("No match for object arguments", ex);
	}
	
	/**
	 * Invokes a given {@code Constructor} object.
	 * 
	 * @param constructor The {@code Constructor} object to invoke.
	 * @param args The arguments to pass into the constructor.
	 * @return An instance of this class wrapping the constructed {@code Object}.
	 * 
	 * @throws ReflectionException Thrown if the constructor failed to invoke for any reason.
	 */
	public static Reflector invokeConstructorObject(Constructor<?> constructor, Object... args)
			throws ReflectionException {
		return new Reflector(invokeConstructorObject0(constructor, args));
	}
	
	private static Object invokeConstructorObject0(Constructor<?> constructor, Object[] args)
			throws ReflectionException {
		try {
			constructor.setAccessible(true);
			return constructor.newInstance(args);
		} catch (InvocationTargetException ex) {
			throw new ReflectionException(ex.getCause());
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	/**
	 * Searches for and invokes the constructor for a given {@code Class} that
	 * is able to accept the provided arguments.
	 * 
	 * @param clazz The {@code Class} object to construct.
	 * @param args The arguments to pass into the constructor.
	 * @return An instance of this class wrapping the constructed {@code Object}.
	 * 	
	 * @throws ReflectionException Thrown if the constructor failed to invoke for any reason.
	 */
	public static Reflector invokeConstructor(Class<?> clazz, Object... args)
			throws ReflectionException {
		return new Reflector(invokeConstructor0(clazz, args));
	}
	
	private static Object invokeConstructor0(Class<?> clazz, Object[] args)
			throws ReflectionException {
		return invokeConstructorObject0(getConstructorObject0(clazz, args), args);
	}
	
	//-------------------------Class Reflection-------------------------//
	
	public static Class<?> getClass(String className) throws ReflectionException {
		try {
			return Class.forName(className);
		} catch (Throwable ex) {
			throw new ReflectionException(ex);
		}
	}
	
	/**
	 * Gets a class from the minecraft server.
	 * 
	 * @param className Name of the class, this gets added to the end of {@link #NMS_PATH}.
	 * @return The {@code Class} object represented by the given name
	 * 
	 * @throws ReflectionException Thrown if there is no class with the given name.
	 */
	public static Class<?> getNMSClass(String className) throws ReflectionException {
		return getClass(NMS_PATH + className);
	}
	
	/**
	 * Gets a class from craftbukkit.
	 * 
	 * @param className Name of the class including packages, this gets added to the end of {@link #CB_PATH}.
	 * @return The {@code Class} object represented by the given name
	 * 
	 * @throws ReflectionException Thrown if there is no class with the given name.
	 */
	public static Class<?> getCBClass(String className) throws ReflectionException {
		return getClass(CB_PATH + className);
	}
	
	//-------------------------Reflection Utility-------------------------//
	
	private static boolean isMatch(Class<?>[] parameterTypes, Object[] args) {
		if (parameterTypes.length != args.length) {
			return false;
		}
		for (int i = 0; i < parameterTypes.length; i++) {
			if (!isInstance(parameterTypes[i], args[i])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isInstance(Class<?> clazz, Object obj) {
		if (clazz.isInstance(obj)) {
			return true;
		}
		switch (obj.getClass().getSimpleName()) {
		case "Boolean":
			return clazz == boolean.class;
		case "Byte":
			return clazz == byte.class;
		case "Character":
			return clazz == char.class;
		case "Double":
			return clazz == double.class;
		case "Float":
			return clazz == float.class;
		case "Integer":
			return clazz == int.class;
		case "Long":
			return clazz == long.class;
		case "Short":
			return clazz == short.class;
		default:
			return false;
		}
	}
	
	private static String argumentTypesToString(Class<?>[] args) {
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				if (i > 0) {
					buf.append(", ");
				}
				Class<?> c = args[i];
				buf.append((c == null) ? "null" : c.getName());
			}
		}
		buf.append(")");
		return buf.toString();
	}
	
	//-------------------------Reflector Instance-------------------------//
	
	//-----Fields-----//
	private final Object obj;
	
	//-----Constructor-----//
	public Reflector(Object obj) {
		this.obj = obj;
	}
	
	//-----Public Methods-----//
	public Object getHandle() {
		return this.obj;
	}
	
	public boolean isInstance(Class<?> clazz) {
		return clazz.isInstance(this.getHandle());
	}
	
	public boolean isNull() {
		return this.getHandle() == null;
	}
	
	public Reflector expression(String expression, Object... args) throws ReflectionException {
		return executeExpression(this.getHandle(), expression, args);
	}
	
	public Reflector invoke(String methodName, Object... args) throws ReflectionException {
		return invokeMethod(this.getHandle(), methodName, args);
	}
	
	public Reflector read(String fieldName) throws ReflectionException {
		return readField(this.getHandle(), fieldName);
	}
	
	public Reflector write(String fieldName, Object value) throws ReflectionException {
		writeField(this.getHandle(), fieldName, value);
		return this;
	}
	
	//-----Utility Methods-----//
	@Override
	public String toString() {
		return String.valueOf(this.getHandle());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getHandle());
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.getHandle(), obj);
	}
}
