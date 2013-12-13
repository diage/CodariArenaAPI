package com.codari.arena5.players.hotbar;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import com.codari.arena5.players.combatants.Combatant;

public class HotbarSelectEvent extends Event {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	//-----Fields-----//
	private final Combatant combatant;
	private final HotbarSlot slot;
	private ItemStack item;
	
	//-----Constructor-----//
	public HotbarSelectEvent(Combatant combatant, HotbarSlot slot) {
		this.combatant = combatant;
		this.slot = slot;
		this.item = this.slot.getItem(this.combatant.getPlayer());
	}
	
	//-----Public Methods-----//
	public Combatant getCombatant() {
		return this.combatant;
	}
	
	public HotbarSlot getSlot() {
		return this.slot;
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
