package com.codari.arena5.rules;

import org.bukkit.event.Listener;

public abstract class WinCondition implements Listener {
	//-----Fields-----//
	private boolean active;
	protected boolean conditionMet;
	
	//-----Public Methods-----//
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public final boolean conditionMet() {
		return this.conditionMet;
	}
}