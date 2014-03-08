package com.codari.arena5.arena.rules.wincondition;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import com.codari.api5.CodariI;
import com.codari.arena5.assets.WinConditionAsset;

public abstract class WinConditionTemplate extends WinConditionAsset {
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