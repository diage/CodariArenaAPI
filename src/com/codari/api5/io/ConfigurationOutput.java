package com.codari.api5.io;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.google.common.base.Function;

public class ConfigurationOutput {
	//-----Fields-----//
	private final Map<String, Object> result;
	
	//-----Constructor-----//
	public ConfigurationOutput() {
		this.result = new LinkedHashMap<>();
	}
	
	//-----Public Methods-----//
	public Map<String, Object> result() {
		return this.result;
	}
	
	public ConfigurationOutput addByte(String key, byte value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addDouble(String key, double value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addFloat(String key, float value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addInt(String key, int value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addLong(String key, long value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addShort(String key, short value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addString(String key, String value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addEnum(String key, Enum<?> value) {
		this.result.put(key, value);
		return this.addString(key, value.toString());
	}
	
	public ConfigurationOutput addObject(String key, ConfigurationSerializable value) {
		this.result.put(key, value);
		return this;
	}
	
	public ConfigurationOutput addAll(Map<String, Object> values) {
		this.result.putAll(values);
		return this;
	}
	
	public <O> ConfigurationOutput add(ConfigurationOutput.OutputFunction<O> outputFunction, O value) {
		this.addAll(outputFunction.apply(value));
		return this;
	}
	
	//-----Output Functions-----//
	public static interface OutputFunction<O> extends Function<O, Map<String, Object>>{}
	public static interface ArrayOutputFunction<O> extends OutputFunction<O[]>{}
	public static interface CollectionOutputFunction<O> extends OutputFunction<Collection<O>>{}
}
