package com.codari.api.stats;

import com.codari.api.util.Modifier;

public interface Stat extends Iterable<StatModifier>, Comparable<Stat> {
	public String getName();
	public StatManager getStatManager();
	
	public byte byteValue();
	public double doubleValue();
	public float floatValue();
	public int intValue();
	public long longValue();
	public short shortValue();
	
	public float getBaseValue();
	public void setBaseValue(float baseValue);
	public void increaseBaseValue(float amount);
	public void decreaseBaseValue(float amount);
	
	public boolean addModifier(String identifier, Modifier modifier);
	public StatModifier getModifier(String identifier);
}