package com.codari.api5.events.itemevents;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.item.CodariItem;
import com.codari.arena5.players.combatants.Combatant;

public class CodariItemHitEvent extends Event implements Cancellable {
	
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}

	//-----Fields-----//
	private boolean cancelled;
	private CodariItem item;
	private Combatant damager, target;
	
	public CodariItemHitEvent(Combatant damager, Combatant target, CodariItem item) {
		this.damager = damager;
		this.target = target;
		this.item = item;
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
	
	public Combatant getDamager() {
		return this.damager;
	}
	
	public Combatant getTarget() {
		return this.target;
	}
	
	public CodariItem getItem() {
		return this.item;
	}

}
