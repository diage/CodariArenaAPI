package com.codari.api5.attribute.modifier;

import net.minecraft.util.org.apache.commons.lang3.builder.HashCodeBuilder;
import net.minecraft.util.org.apache.commons.lang3.builder.ToStringBuilder;
import net.minecraft.util.org.apache.commons.lang3.builder.ToStringStyle;

public final class AttributeModifier implements Comparable<AttributeModifier> {
	//-----Fields-----//
	private final String modifierId;
	private final ModifierValue value;
	private final ModifierType type;
	private final int hash;
	
	//-----Constructors-----//
	public AttributeModifier(String modifierId, ModifierValue value, ModifierType type) {
		this.modifierId = modifierId;
		this.value = value;
		this.type = type;
		this.hash = new HashCodeBuilder().append(this.modifierId).toHashCode();
	}
	
	public AttributeModifier(String modifierId, double value, ModifierType type) {
		this(modifierId, new FixedModifierValue(value), type);
	}
	
	public AttributeModifier(String modifierId, ModifierValue value) {
		this(modifierId, value, ModifierType.ADDITIVE);
	}
	
	public AttributeModifier(String modifierId, double value) {
		this(modifierId, value, ModifierType.ADDITIVE);
	}
	
	//-----Methods-----//
	public String getId() {
		return this.modifierId;
	}
	
	public AttributeModifier setId(String modifierId) {
		return new AttributeModifier(modifierId, this.value, this.type);
	}
	
	public double getValue() {
		return this.value.getValue();
	}
	
	public double getAppliedValue(double baseValue) {
		switch (this.type) {
		case ADDITIVE:
			return this.getValue();
		case MULTIPLICATIVE:
			return baseValue * this.getValue();
		default:
			throw new Error("Unknown ModifierType named " + this.type + "... WTF!?");
		}
	}
	
	public AttributeModifier setValue(ModifierValue value) {
		return new AttributeModifier(this.modifierId, value, this.type);
	}
	
	public AttributeModifier setValue(double value) {
		return new AttributeModifier(this.modifierId, value, this.type);
	}
	
	public ModifierType getType() {
		return this.type;
	}
	
	public AttributeModifier setType(ModifierType type) {
		return new AttributeModifier(this.modifierId, this.value, type);
	}
	
	public boolean isConsistent() {
		return this.value instanceof FixedModifierValue;
	}
	
	public AttributeModifier makeConsistent() {
		if (this.isConsistent()) {
			return this;
		}
		return new AttributeModifier(this.modifierId, this.getValue(), this.type);
	}
	
	public AttributeModifier add(double value) {
		return this.setValue(this.getValue() + value);
	}
	
	public AttributeModifier add(long value) {
		return this.add((double) value);
	}
	
	public AttributeModifier add(ModifierValue value) {
		return this.add(value.getValue());
	}
	
	public AttributeModifier add(AttributeModifier modifier) {
		return this.add(modifier.getValue());
	}
	
	public AttributeModifier subtract(double value) {
		return this.setValue(this.getValue() - value);
	}
	
	public AttributeModifier subtract(long value) {
		return this.subtract((double) value);
	}
	
	public AttributeModifier subtract(ModifierValue value) {
		return this.subtract(value.getValue());
	}
	
	public AttributeModifier subtract(AttributeModifier modifier) {
		return this.subtract(modifier.getValue());
	}
	
	public AttributeModifier multiply(double value) {
		return this.setValue(this.getValue() * value);
	}
	
	public AttributeModifier multiply(long value) {
		return this.multiply((double) value);
	}
	
	public AttributeModifier multiply(ModifierValue value) {
		return this.multiply(value.getValue());
	}
	
	public AttributeModifier multiply(AttributeModifier modifier) {
		return this.multiply(modifier.getValue());
	}
	
	public AttributeModifier divide(double value) {
		return this.setValue(this.getValue() / value);
	}
	
	public AttributeModifier divide(long value) {
		return this.divide((double) value);
	}
	
	public AttributeModifier divide(ModifierValue value) {
		return this.divide(value.getValue());
	}
	
	public AttributeModifier divide(AttributeModifier modifier) {
		return this.divide(modifier.getValue());
	}
	
	//-----Utility Methods-----//
	@Override
	public int compareTo(AttributeModifier other) {
		return Double.compare(this.getValue(), other.getValue());
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("modifierId", this.modifierId)
				.append("value", this.getValue())
				.append("type", this.type)
				.build();
	}
	
	@Override
	public int hashCode() {
		return this.hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof AttributeModifier) {
			return this.modifierId.equals(((AttributeModifier) obj).modifierId);
		}
		return false;
	}
}
