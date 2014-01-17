package com.codari.api5.attribute;

import com.codari.api5.attribute.modifier.AttributeModifier;

public interface Attribute extends Iterable<AttributeModifier>, Comparable<Attribute> {
	public AttributeTemplate getTemplate();
	public String getId();
	public String getName();
	public String getDescription();
	public int getLevel();
	public int getMaxLevel();
	public void setLevel(int level);
	
	public double getBaseValue();
	public double getScalarValue();
	public double getValue();
	
	public AttributeModifier applyModifier(AttributeModifier modifier, boolean forceConsistent);
	public AttributeModifier applyModifier(AttributeModifier modifier);
	public AttributeModifier getModifier(String modifierId);
	public AttributeModifier removeModifier(String modifierId);
}
