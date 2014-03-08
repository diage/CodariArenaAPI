package com.codari.api5.events.itemevents;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.item.CodariItem;

public class CodariItemLevelEvent extends Event implements Cancellable {
	
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}

	//-----Fields-----//
	private boolean cancelled;
	private CodariItem item;
	
	public CodariItemLevelEvent(CodariItem item) {
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
	
	public CodariItem getItem() {
		return this.item;
	}

}
