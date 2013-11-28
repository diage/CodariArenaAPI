package com.codari.api5.stats;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.codari.api5.CodariI;

public final class StatType {
	//-----Static Methods-----//
	public static StatType.Builder newBuilder(String name) throws IllegalArgumentException {
		return new Builder(name);
	}
	
	//-----Fields-----//
	private final String name;
	private final String description;
	private final float[] baseValues;
	private final float minValue, maxValue;
	
	//-----Constructor-----//
	private StatType(Builder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.baseValues = builder.baseValues;
		this.minValue = builder.minValue;
		this.maxValue = builder.maxValue;
	}
	
	//-----Public Methods-----//
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public float[] getBaseValues() {
		return Arrays.copyOf(this.baseValues, this.baseValues.length);
	}
	
	public float getBaseValue(int level) throws IndexOutOfBoundsException {
		return this.baseValues[level - 1];
	}
	
	public int getMaxLevel() {
		return this.baseValues.length;
	}
	
	public float getMinValue() {
		return this.minValue;
	}
	
	public float getMaxValue() {
		return this.maxValue;
	}
	
	//-----Utility Methods-----//
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return 11 * 5 + this.name.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StatType) {
			StatType other = (StatType) obj;
			return this.name.equalsIgnoreCase(other.name);
		}
		return false;
	}
	
	//-----Stat Info Builder-----//
	public final static class Builder {
		//-----Constants-----//
		private final static float[] DEFAULT_BASE_VALUES = {0};
		
		//-----Fields-----//
		private final String name;
		private String description;
		private float[] baseValues;
		private float minValue, maxValue;
		
		//-----Constructor-----//
		public Builder(String name) throws IllegalArgumentException {
			name = StringUtils.normalizeSpace(name).trim();
			if (!CodariI.INSTANCE.getStatFactory().isValidStatName(name)) {
				throw new IllegalArgumentException(name + " is not a valid stat name");
			}
			this.name = name;
		}
		
		//-----Public Methods-----//
		public StatType build() {
			return new StatType(this);
		}
		
		public StatType.Builder setDescription(String description) {
			this.description = description == null ? StringUtils.EMPTY : description;
			return this;
		}
		
		public StatType.Builder setBaseValues(float... baseValues) {
			this.baseValues = ArrayUtils.isEmpty(baseValues) ? DEFAULT_BASE_VALUES : baseValues;
			return this;
		}
		
		public StatType.Builder setMinValue(float minValue) {
			this.minValue = minValue > this.maxValue ? this.maxValue : minValue;
			return this;
		}
		
		public StatType.Builder setMaxValue(float maxValue) {
			this.maxValue = maxValue < this.minValue ? this.minValue : maxValue;
			return this;
		}
	}
}