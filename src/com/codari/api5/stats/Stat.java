package com.codari.api5.stats;

import com.codari.api5.util.Modifier;

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
	
	public StatModifier setModifier(String identifier, Modifier modifier);
	public StatModifier getModifier(String identifier);
	public StatModifier removeModifier(String identifier);
}