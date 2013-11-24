package com.codari.arena5.rules;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import com.codari.api5.Codari;

public abstract class WinCondition implements Listener {
	//-----Fields-----//
	protected boolean conditionMet;
	
	//-----Public Methods-----//
	public final boolean conditionMet() {
		return this.conditionMet;
	}
	
	public final void setRegistered(boolean registered) {
		if (registered) {
			Bukkit.getPluginManager().registerEvents(this, Codari.INSTANCE);
		} else {
			HandlerList.unregisterAll(this);
		}
	}
}