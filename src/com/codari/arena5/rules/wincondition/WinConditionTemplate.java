package com.codari.arena5.rules.wincondition;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import com.codari.api5.Codari;

public abstract class WinConditionTemplate implements WinCondition {
	//-----Fields-----//
	protected boolean conditionMet;
	
	//-----Public Methods-----//
	@Override
	public final boolean conditionMet() {
		return this.conditionMet;
	}
	
	@Override
	public final void setRegistered(boolean registered) {
		if (registered) {
			Bukkit.getPluginManager().registerEvents(this, Codari.INSTANCE);
		} else {
			HandlerList.unregisterAll(this);
		}
	}
}