package com.codari.arena5.arena.rules.wincondition;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import com.codari.api5.CodariI;

public abstract class WinConditionTemplate implements WinCondition {
	private static final long serialVersionUID = 8677900739585198742L;
	//-----Fields-----//
	protected boolean conditionMet;
	
	public WinConditionTemplate() {};
	
	//-----Public Methods-----//
	@Override
	public final boolean conditionMet() {
		return this.conditionMet;
	}
	
	@Override
	public final void setRegistered(boolean registered) {
		if (registered) {
			Bukkit.getPluginManager().registerEvents(this, CodariI.INSTANCE);
		} else {
			HandlerList.unregisterAll(this);
		}
	}
}