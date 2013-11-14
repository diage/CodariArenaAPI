package com.codari.api.stats;

import com.codari.api.util.Modifier;

public interface StatModifier extends Modifier {
	public String getIdentifier();
	public void set(Modifier modifier);
	public void remove();
}