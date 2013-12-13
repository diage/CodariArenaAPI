package com.codari.arena5.players.hotbar;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import com.codari.arena5.players.combatants.Combatant;

public class HotbarSelectEvent extends Event implements Cancellable {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	//-----Fields-----//
	private final Combatant combatant;
	private final HotbarSlot slot;
	private final ItemStack item;
	private boolean cancelled;
	
	//-----Constructor-----//
	public HotbarSelectEvent(Combatant combatant, HotbarSlot slot, ItemStack item) {
		this.combatant = combatant;
		this.slot = slot;
		this.item = item;
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
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
