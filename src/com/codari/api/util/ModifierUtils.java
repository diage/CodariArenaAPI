package com.codari.api.util;

import java.util.Collection;

public final class ModifierUtils {
	//-----Constants-----//
	public final static Modifier NULL = hybrid(0, 0);
	
	//-----Static Methods-----//
	public static Modifier hybrid(float fixedValue, float percentage) {
		return new SimpleModifier(fixedValue, percentage);
	}
	
	public static Modifier fixedValue(float fixedValue) {
		return hybrid(fixedValue, 0);
	}
	
	public static Modifier percentage(float percentage) {
		return hybrid(0, percentage);
	}
	
	public static Modifier add(Modifier... modifiers) {
		float totalFixedValue = 0;
		float totalPercentage = 0;
		for (Modifier modifier : modifiers) {
			totalFixedValue += modifier.getFixedValue();
			totalPercentage += modifier.getPercentage();
		}
		return hybrid(totalFixedValue, totalPercentage);
	}
	
	public static Modifier add(Collection<? extends Modifier> modifiers) {
		float totalFixedValue = 0;
		float totalPercentage = 0;
		for (Modifier modifier : modifiers) {
			totalFixedValue += modifier.getFixedValue();
			totalPercentage += modifier.getPercentage();
		}
		return hybrid(totalFixedValue, totalPercentage);
	}
	
	public static Modifier handleNullModifier(Modifier modifier) {
		return modifier != null ? modifier : NULL;
	}
	
	//-----Constructor-----//
	private ModifierUtils(){}
}