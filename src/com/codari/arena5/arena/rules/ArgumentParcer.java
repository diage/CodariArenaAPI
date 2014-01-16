package com.codari.arena5.arena.rules;

import java.util.Arrays;
import java.util.List;

public abstract class ArgumentParcer<T> {
	//-----Fields-----//
	private final Class<T> clazz;
	private final String name;
	private final List<String> description;
	
	//-----Constructor-----//
	public ArgumentParcer(Class<T> clazz, String name, String... description) {
		this.clazz = clazz;
		this.name = name;
		this.description = Arrays.asList(description);
	}
	
	//-----Methods-----//
	public final Class<T> getArgumentClass() {
		return this.clazz;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final List<String> getDescription() {
		return this.description;
	}
	
	public abstract T parce(String token);
}