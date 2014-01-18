package com.codari.arena5.arena.rules;

import org.bukkit.Location;

public enum Argument {
	//-----Enumerations-----//
	BOOLEAN_PRIMITIVE(boolean.class),
	BOOLEAN_WRAPPER(Boolean.class),
	BYTE_PRIMITIVE(byte.class),
	BYTE_WRAPPER(Byte.class),
	CHARACTER_PRIMITIVE(char.class),
	CHARACTER_WRAPPER(Character.class),
	DOUBLE_PRIMITIVE(double.class),
	DOUBLE_WRAPPER(Double.class),
	FLOAT_PRIMITIVE(float.class),
	FLOAT_WRAPPER(Float.class),
	INTEGER_PRIMITIVE(int.class),
	INTEGER_WRAPPER(Integer.class),
	LONG_PRIMITIVE(long.class),
	LONG_WRAPPER(Long.class),
	SHORT_PRIMITIVE(short.class),
	SHORT_WRAPPER(Short.class),
	STRING(String.class),
	LOCATION(Location.class);
	
	//-----Fields-----//
	private final Class<?> clazz;
	
	//-----Constructor-----//
	private Argument(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	//-----Methods-----//
	public Class<?> clazz() {
		return this.clazz;
	}
}
