package com.codari.api5.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.hotbar.HotbarOption;

public class HotbarSelectEvent extends Event {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	//-----Fields-----//
	private final Combatant combatant;
	private final HotbarOption option;
	private ItemStack item;
	
	//-----Constructor-----//
	public HotbarSelectEvent(Combatant combatant, HotbarOption option) {
		this.combatant = combatant;
		this.option = option;
		this.item = this.option.getItem(this.combatant.getPlayer());
	}
	
	//-----Public Methods-----//
	public Combatant getCombatant() {
		return this.combatant;
	}
	
	public HotbarOption getOption() {
		return this.option;
	}
	
	public ItemStack getItem() {
		return this.item;
	}
	
	public void setItem(ItemStack item) {
		this.item = item;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}