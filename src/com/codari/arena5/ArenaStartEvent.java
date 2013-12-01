package com.codari.arena5;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class ArenaStartEvent extends Event implements Cancellable {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	//-----Fields-----//
	private final Arena arena;
	private boolean cancelled;
	
	//-----Constructor-----//
	public ArenaStartEvent(Arena arena) {
		this.arena = arena;
	}
	
	//-----Public Methods-----//
	public Arena getArena() {
		return this.arena;
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
