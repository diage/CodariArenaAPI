package com.codari.arena5.arena.rules;

import org.bukkit.Location;

public enum Argument {
	//-----Enumerations//
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
