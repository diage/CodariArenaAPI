package com.codari.api5.stats;

import com.codari.api5.util.Modifier;

/**
 * <p>Represents a stat value for a specific instance of {@link StatHolder}.</p>
 * 
 * @author Soren025
 */
public interface Stat extends Iterable<StatModifier>, Comparable<Stat> {
	public StatType getType();
	public StatManager getStatManager();
	
	public byte byteValue();
	public double doubleValue();
	public float floatValue();
	public int intValue();
	public long longValue();
	public short shortValue();
	
	public int getLevel();
	public void setLevel(int level);
	public float getBaseValue();
	
	public void setModifier(String identifier, Modifier modifier);
	public StatModifier getModifier(String identifier);
	public void removeModifier(String identifier);
}