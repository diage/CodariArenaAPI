package com.codari.api5.stats;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.codari.api5.Codari;

public final class StatType {
	//-----Static Methods-----//
	public static StatType.Builder builder(String name) throws IllegalArgumentException {
		return new Builder(name);
	}
	
	//-----Fields-----//
	private final String name;
	private final float[] baseValues;
	
	//-----Constructor-----//
	private StatType(Builder builder) {
		this.name = builder.name;
		this.baseValues = builder.baseValues;
	}
	
	//-----Public Methods-----//
	public String getName() {
		return this.name;
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
		private final float[] NULL = new float[] {0};
		
		//-----Fields-----//
		private final String name;
		private float[] baseValues;
		
		//-----Constructor-----//
		private Builder(String name) throws IllegalArgumentException {
			if (!Codari.INSTANCE.getStatFactory().isValidStatName(name)) {
				throw new IllegalArgumentException(name + " is not a valid stat name");
			}
			this.name = name.trim();
			this.baseValues = NULL;
		}
		
		//-----Public Methods-----//
		public StatType build() {
			return new StatType(this);
		}
		
		public StatType.Builder baseValues(float... baseValues) {
			this.baseValues = ArrayUtils.isEmpty(baseValues) ? NULL : baseValues; //Ass.
			return this;
		}
	}
}