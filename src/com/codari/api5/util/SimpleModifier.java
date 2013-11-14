package com.codari.api5.util;

public class SimpleModifier implements Modifier {
	//-----Fields-----//
	private final float fixedValue;
	private final float percentage;
	
	//-----Constructor-----//
	public SimpleModifier(float fixedValue, float percentage) {
		this.fixedValue = fixedValue;
		this.percentage = percentage;
	}
	
	public SimpleModifier(Modifier other) {
		this(other.getFixedValue(), other.getPercentage());
	}
	
	//-----Public Methods-----//
	@Override
	public float getFixedValue() {
		return this.fixedValue;
	}

	@Override
	public float getPercentage() {
		return this.percentage;
	}
}