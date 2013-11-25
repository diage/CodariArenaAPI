package com.codari.api5.io;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class ConfigurationInput {
	//-----Fields-----//
	private final Map<String, Object> args;
	
	//-----Constructor-----//
	public ConfigurationInput(Map<String, Object> args) {
		this.args = new LinkedHashMap<>(args);
	}
	
	//-----Public Methods-----//
	public Object get(String key) {
		return this.args.get(key);
	}
	
	public byte getByte(String key) {
		return this.getByte(key, (byte) 0);
	}
	
	public byte getByte(String key, byte def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).byteValue();
		}
		return def;
	}
	
	public double getDouble(String key) {
		return this.getDouble(key, 0);
	}
	
	public double getDouble(String key, double def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).doubleValue();
		}
		return def;
	}
	
	public float getFloat(String key) {
		return this.getFloat(key, 0);
	}
	
	public float getFloat(String key, float def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).floatValue();
		}
		return def;
	}
	
	public int getInt(String key) {
		return this.getInt(key, 0);
	}
	
	public int getInt(String key, int def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).intValue();
		}
		return def;
	}
	
	public long getLong(String key) {
		return this.getLong(key, 0);
	}
	
	public long getLong(String key, long def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).longValue();
		}
		return def;
	}
	
	public short getShort(String key) {
		return this.getShort(key, (short) 0);
	}
	
	public short getShort(String key, short def) {
		Object obj = this.get(key);
		if (obj instanceof Number) {
			return ((Number) obj).shortValue();
		}
		return def;
	}
	
	public String getString(String key) {
		return this.getString(key, StringUtils.EMPTY);
	}
	
	public String getString(String key, String def) {
		Object obj = this.get(key);
		if (obj instanceof String) {
			return (String) obj;
		}
		return def;
	}
	
	public <T extends Enum<T>> T getEnum(Class<T> enumClass, String key) {
		return  this.getEnum(enumClass, key, null);
	}
	
	public <T extends Enum<T>> T getEnum(Class<T> enumClass, String key, T def) {
		T result = EnumUtils.getEnum(enumClass, this.getString(key));
		if (result == null) {
			result = def;
		}
		return result;
	}
	
	public <T extends ConfigurationSerializable> T getObject(Class<T> clazz, String key) {
		return this.getObject(clazz, key, null);
	}
	
	public <T extends ConfigurationSerializable> T getObject(Class<T> clazz, String key, T def) {
		Object obj = this.get(key);
		if (clazz.isInstance(obj)) {
			return clazz.cast(obj);
		}
		return def;
	}
}
