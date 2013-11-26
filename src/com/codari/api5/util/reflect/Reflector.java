package com.codari.api5.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.Bukkit;

public final class Reflector {
	//-----Constants-----//
	/**
	 * Minecraft version of the running craftbukkit server.
	 */
	public final static String MINECRAFT_VERSION = Bukkit.getServer() != null ?
			Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] : "UNKNOWN";
	/**
	 * Base class name path for NMS classes "net.minecraft.server.<minecraft version>"
	 */
	public final static String NMS_PATH = "net.minecraft.server." + MINECRAFT_VERSION;
	/**
	 * Base class name path for CB classes "org.bukkit.craftbukkit.<minecraft version>"
	 */
	public final static String CB_PATH = "org.bukkit.craftbukkit." + MINECRAFT_VERSION;
	
	//-----Static Methods-----//
	
	//-------------------------Method Reflection-------------------------//
	
	public static Method getMethodObject(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().equals(methodName) && Arrays.equals(m.getParameterTypes(), parameterTypes)) {
					return m;
				}
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find method named " + methodName + " in the class " + clazz);
	}
	
	private static Method getMethodObject0(Class<?> clazz, String methodName, Object[] args) {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().equals(methodName) && isMatch(m.getParameterTypes(), args)) {
					return m;
				}
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find method named " + methodName + " in the class " + clazz);
	}
	
	public static Reflector invokeMethodObject(Method method, Object obj, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return new Reflector(invokeMethodObject0(method, obj, args));
	}
	
	private static Object invokeMethodObject0(Method method, Object obj, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		method.setAccessible(true);
		return method.invoke(obj, args);
	}
	
	public static Reflector invokeMethod(Object obj, String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return new Reflector(invokeMethod0(obj.getClass(), obj, methodName, args));
	}
	
	public static Reflector invokeStaticMethod(Class<?> clazz, String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return new Reflector(invokeMethod0(clazz, null, methodName, args));
	}
	
	private static Object invokeMethod0(Class<?> clazz, Object obj, String methodName, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return invokeMethodObject0(getMethodObject0(clazz, methodName, args), obj, args);
	}
	
	//-------------------------Field Reflection-------------------------//
	
	public static Field getFieldObject(Class<?> clazz, String fieldName) {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Field f : clazz.getDeclaredFields()) {
				if (f.getName().equals(fieldName)) {
					return f;
				}
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find field named " + fieldName + " in the class " + clazz);
	}
	
	public static Reflector readFieldObject(Field field, Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		return new Reflector(readFieldObject0(field, obj));
	}
	
	private static Object readFieldObject0(Field field, Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		return field.get(obj);
	}
	
	public static Reflector readField(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		return new Reflector(readField0(obj.getClass(), obj, fieldName));
	}
	
	public static Reflector readStaticField(Class<?> clazz, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		return new Reflector(readField0(clazz, null, fieldName));
	}
	
	private static Object readField0(Class<?> clazz, Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		return readFieldObject0(getFieldObject(clazz, fieldName), obj);
	}
	
	public static void writeFieldObject(Field field, Object obj, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		writeFieldObject0(field, obj, value, true);
	}
	
	public static void writeFieldObject0(Field field, Object obj, Object value, boolean ignoreFinal)
			throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		if (ignoreFinal) {
			writeField0(field.getClass(), field, "modifiers", field.getModifiers() & ~Modifier.FINAL, false);
		}
		field.set(obj, value);
	}
	
	public static void writeField(Object obj, String fieldName, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		writeField0(obj.getClass(), obj, fieldName, value, true);
	}
	
	public static void writeStaticField(Class<?> clazz, String fieldName, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		writeField0(clazz, null, fieldName, value, true);
	}
	
	private static void writeField0(Class<?> clazz, Object obj, String fieldName, Object value, boolean ignoreFinal)
			throws IllegalArgumentException, IllegalAccessException {
		writeFieldObject0(getFieldObject(clazz, fieldName), obj, value, ignoreFinal);
	}
	
	//-------------------------Constructor Reflection-------------------------//
	
	public static <T> Constructor<T> getConstructorObject(Class<T> clazz, Class<?>... parameterTypes)
			throws NoSuchMethodException, SecurityException {
		return clazz.getDeclaredConstructor(parameterTypes);
	}
	
	private static Constructor<?> getConstructorObject0(Class<?> clazz, Object[] args) {
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (isMatch(c.getParameterTypes(), args)) {
				return c;
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find constructor in the class " + clazz);
	}
	
	public static Reflector invokeConstructorObject(Constructor<?> constructor, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return new Reflector(invokeConstructorObject0(constructor, args));
	}
	
	private static Object invokeConstructorObject0(Constructor<?> constructor, Object[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return constructor.newInstance(args);
	}
	
	public static Reflector invokeConstructor(Class<?> clazz, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return new Reflector(invokeConstructor0(clazz, args));
	}
	
	private static Object invokeConstructor0(Class<?> clazz, Object[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return invokeConstructorObject0(getConstructorObject0(clazz, args), args);
	}
	
	//-------------------------Class Reflection-------------------------//
	
	public static Class<?> classFromNMS(String className) throws ClassNotFoundException { 
		return Class.forName(NMS_PATH + "." + className);
	}
	
	public static Class<?> classFromCB(String className) throws ClassNotFoundException {
		return Class.forName(CB_PATH + "." + className);
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
	
	//-------------------------Reflector Instance-------------------------//
	
	//-----Fields-----//
	private final Object obj;
	
	//-----Constructor-----//
	public Reflector(Object obj) {
		this.obj = obj;
	}
	
	//-----Public Methods-----//
	public Object fetch() {
		return this.obj;
	}
	
	public <T> T fetchAs(Class<T> clazz) throws ClassCastException {
		return clazz.cast(this.obj);
	}
	
	public boolean isInstance(Class<?> clazz) {
		return clazz.isInstance(this.obj);
	}
	
	public Reflector invoke(String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return invokeMethod(this.obj, methodName, args);
	}
	
	public Reflector get(String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		return readField(this.obj, fieldName);
	}
	
	public Reflector set(String fieldName, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		writeField(this.obj, fieldName, value);
		return this;
	}
	
	public Reflector invokeCommand(String command, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (this.obj == null) {
			throw new NullPointerException();
		}
		Object obj = this.obj;
		String[] parts = command.split("\\.");
		for (String part : parts) {
			int argumentOpenerIndex = part.indexOf('(');
			if (argumentOpenerIndex != -1) {
				String methodName = part.substring(0, argumentOpenerIndex);
				if (part.charAt(argumentOpenerIndex + 1) == ')') {
					obj = invokeMethod0(obj.getClass(), obj, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY);
				} else {
					String[] argumentIndex = part.substring(argumentOpenerIndex + 1, part.indexOf(')')).split(",");
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
	
	//-----Utility Methods-----//
	@Override
	public String toString() {
		return String.valueOf(this.obj);
	}
	
	@Override
	public int hashCode() {
		return ObjectUtils.hashCode(this.obj);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ObjectUtils.equals(this.obj, obj);
	}
}