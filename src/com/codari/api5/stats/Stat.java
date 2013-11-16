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
	public int getLevel();
	public int getMaxLevel();
	public void setLevel(int level);
	
	public void setModifier(String identifier, Modifier modifier);
	public StatModifier getModifier(String identifier);
	public void removeModifier(String identifier);
}