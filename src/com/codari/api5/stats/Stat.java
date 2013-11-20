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
	public int getLevel();
	public void setLevel(int level);
	public float getBaseValue();
	public float value();
	public float value(boolean contingent);
	public void setModifier(String identifier, Modifier modifier);
	public void setContingentModifier(String identifier, Modifier modifier);
	public StatModifier getModifier(String identifier);
	public void removeModifier(String identifier);
}