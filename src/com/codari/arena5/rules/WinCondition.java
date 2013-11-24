package com.codari.arena5.rules;

import org.bukkit.event.Listener;

public abstract class WinCondition implements Listener {
	//-----Fields-----//
	protected boolean conditionMet;
	
	//-----Public Methods-----//
	public final boolean conditionMet() {
		return this.conditionMet;
	}
}