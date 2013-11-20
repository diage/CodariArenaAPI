package com.codari.api5.stats;

import com.codari.api5.util.Modifier;

public interface StatModifier extends Modifier {
	public String getIdentifier();
	public boolean isContingent();
}