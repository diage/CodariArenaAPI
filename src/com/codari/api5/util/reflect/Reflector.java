package com.codari.api5.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
	 * Base class name path for OBC classes "org.bukkit.craftbukkit.<minecraft version>"
	 */
	public final static String OBC_PATH = "org.bukkit.craftbukkit." + MINECRAFT_VERSION;
	
	//-----Static Methods-----//
	/*
	 * Example use of below method, copy paste it and try it out
	 * 
	 * System.out.println(Reflector.reflect("replace(1,2).replace(3,4).toUpperCase()", "codari", 'o', '0', 'i', '1'));
	 * 
	 * Will reflectively turn the input string "codari" into the output C0DAR1.
	 */
	public static Reflector reflect(String command, Object obj, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return new Reflector(reflect0(command, obj, args));
	}
	
	public static Reflector reflectStatic(String command, Class<?> clazz, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = null;
		int commandSplit = command.indexOf('.');
		String part = command.substring(0, commandSplit);
		int argumentOpenerIndex = part.indexOf('(');
		if (argumentOpenerIndex != -1) {
			String methodName = part.substring(0, argumentOpenerIndex);
			if (part.charAt(argumentOpenerIndex + 1) == ')') {
				obj = invokeMethod0(clazz, null, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY);
			} else {
				String[] argumentIndex = part.substring(argumentOpenerIndex + 1, part.indexOf(')')).split(",");
				Object[] arguments = new Object[argumentIndex.length];
				for (int i = 0; i < argumentIndex.length; i++) {
					arguments[i] = args[Integer.valueOf(argumentIndex[i]) - 1];
				}
				obj = invokeMethod0(clazz, null, methodName, arguments);
			}
		} else {
			obj = getField0(clazz, null, part);
		}
		return reflect(command.substring(commandSplit + 1, command.length()), obj, args);
	}
	
	private static Object reflect0(String command, Object obj, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
				obj = getField0(obj.getClass(), obj, part);
			}
		}
		return obj;
	}
	
	public static Reflector invokeMethod(Object obj, String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (args == null) {
			args = ArrayUtils.EMPTY_OBJECT_ARRAY;
		}
		return new Reflector(invokeMethod0(obj.getClass(), obj, methodName, args));
	}
	
	public static Reflector invokeStaticMethod(Class<?> clazz, String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (args == null) {
			args = ArrayUtils.EMPTY_OBJECT_ARRAY;
		}
		return new Reflector(invokeMethod0(clazz, null, methodName, args));
	}
	
	private static Object invokeMethod0(Class<?> clazz, Object obj, String methodName, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().equals(methodName) && isMatch(m.getParameterTypes(), args)) {
					m.setAccessible(true);
					return m.invoke(obj, args);
				}
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find method named " + methodName + " in the class " + clazz);
	}
    
    public static Reflector getField(Object obj, String fieldName)
    		throws IllegalArgumentException, IllegalAccessException {
    	return new Reflector(getField0(obj.getClass(), obj, fieldName));
    }
    
    public static Reflector getStaticField(Class<?> clazz, String fieldName)
    		throws IllegalArgumentException, IllegalAccessException {
    	return new Reflector(getField0(clazz, null, fieldName));
    }
    
    private static Object getField0(Class<?> clazz, Object obj, String fieldName)
    		throws IllegalArgumentException, IllegalAccessException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Field f : clazz.getDeclaredFields()) {
				if (f.getName().equals(fieldName)) {
					f.setAccessible(true);
					return f.get(obj);
				}
			}
		}
		//TODO needs better choice of exception and message
		throw new IllegalArgumentException("couldnt find field named " + fieldName + " in the class " + clazz);
    }
    
    public static void setField(Object obj, String fieldName, Object value, boolean ignoreFinal)
    		throws IllegalArgumentException, IllegalAccessException {
    	setField0(obj.getClass(), obj, fieldName, value, ignoreFinal);
    }
    
    public static void setField(Object obj, String fieldName, Object value)
    		throws IllegalArgumentException, IllegalAccessException {
    	setField(obj, fieldName, value, false);
    }
    
    public static void setStaticField(Class<?> clazz, String fieldName, Object value, boolean ignoreFinal)
    		throws IllegalArgumentException, IllegalAccessException {
    	setField0(clazz, null, fieldName, value, ignoreFinal);
    }
    
    public static void setStaticField(Class<?> clazz, String fieldName, Object value)
    		throws IllegalArgumentException, IllegalAccessException {
    	setStaticField(clazz, fieldName, value, false);
    }
    
    private static void setField0(Class<?> clazz, Object obj, String fieldName, Object value, boolean ignoreFinal)
    		throws IllegalArgumentException, IllegalAccessException {
		for (; clazz != null; clazz = clazz.getSuperclass()) {
			for (Field f : clazz.getDeclaredFields()) {
				if (f.getName().equals(fieldName)) {
					f.setAccessible(true);
					if (ignoreFinal) {
						setField0(f.getClass(), f, "modifiers", f.getModifiers() & ~Modifier.FINAL, false);
					}
					f.set(obj, value);
				}
			}
		}
    }
    
    public static Reflector constructClass(Class<?> clazz, Object... args)
    		throws InstantiationException, IllegalAccessException,
    		IllegalArgumentException, InvocationTargetException {
    	return new Reflector(clazz, args);
    }
    
    private static Object constructClass0(Class<?> clazz, Object[] args)
    		throws InstantiationException, IllegalAccessException,
    		IllegalArgumentException, InvocationTargetException {
    	if (ArrayUtils.isEmpty(args)) {
    		return clazz.newInstance();
    	}
    	for (Constructor<?> c : clazz.getDeclaredConstructors()) {
    		if (isMatch(c.getParameterTypes(), args)) {
    			c.setAccessible(true);
    			return c.newInstance(args);
    		}
    	}
    	//TODO needs better choice of exception and message
    	throw new IllegalArgumentException("couldnt find constructor in the class " + clazz);
    }
    
    public static Class<?> classFromNMS(String className) throws ClassNotFoundException { 
    	return Class.forName(NMS_PATH + "." + className);
    }
    
    public static Class<?> classFromOBC(String className) throws ClassNotFoundException {
    	return Class.forName(OBC_PATH + "." + className);
    }
	
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
        if (obj instanceof Integer && clazz == int.class) {
        	return true;
        }
        if (obj instanceof Boolean && clazz == boolean.class) {
        	return true;
        }
        if (obj instanceof Character && clazz == char.class) {
        	return true;
        }
        if (obj instanceof Float && clazz == float.class) {
        	return true;
        }
        if (obj instanceof Double && clazz == double.class) {
        	return true;
        }
        if (obj instanceof Long && clazz == long.class) {
        	return true;
        }
        if (obj instanceof Short && clazz == short.class) {
        	return true;
        }
        if (obj instanceof Byte && clazz == byte.class) {
        	return true;
        }
        return false;
    }
	
	//-----Fields-----//
	private final Object obj;
	
	//-----Constructor-----//
	public Reflector(Object obj) {
		this.obj = obj;
	}
	
	public Reflector(Class<?> clazz, Object... args)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		this.obj = constructClass0(clazz, args);
	}
	
	//-----Public Methods-----//
	public Object get() {
		return this.obj;
	}
	
	public <T> T getAs(Class<T> clazz) throws ClassCastException {
		return clazz.cast(this.get());
	}
	
	public boolean isInstance(Class<?> clazz) {
		return clazz.isInstance(this.get());
	}
	
	public Reflector call(String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return this.get() != null ? invokeMethod(this.get(), methodName, args) : this;
	}
	
	public Reflector get(String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		return this.get() != null ? getField(this.get(), fieldName) : this;
	}
	
	public void set(String fieldName, Object value, boolean ignoreFinal)
			throws IllegalArgumentException, IllegalAccessException {
		if (this.get() != null) {
			setField(this.get(), fieldName, value, ignoreFinal);
		}
	}
	
	public void set(String fieldName, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		if (this.get() != null) {
			setField(this.get(), fieldName, value);
		}
	}
	
	//-----Utility Methods-----//
	@Override
	public String toString() {
		return String.valueOf(this.get());
	}
	
	@Override
	public int hashCode() {
		return ObjectUtils.hashCode(this.get());
	}
	
	@Override
	public boolean equals(Object obj) {
		return ObjectUtils.equals(this.get(), obj);
	}
}