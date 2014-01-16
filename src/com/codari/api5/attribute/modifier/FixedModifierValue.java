package com.codari.api5.attribute.modifier;

public class FixedModifierValue implements ModifierValue {
	//-----Constants-----//
	public static final FixedModifierValue ZERO = new FixedModifierValue(0);
	
	//-----Fields-----//
	private final double value;
	
	//-----Constructor-----//
	public FixedModifierValue(double value) {
		this.value = value;
	}
	
	//-----Methods-----//
	@Override
	public double getValue() {
		return this.value;
	}
}
