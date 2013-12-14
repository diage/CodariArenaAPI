package com.codari.arena5;

import java.util.Collection;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.players.combatants.Combatant;

public class ArenaEndEvent extends Event {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();

	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return handlers;
	}

	//-----Fields-----//
	private final Arena arena;
	Collection<Combatant> winners;

	//-----Constructor-----//
	public ArenaEndEvent(Arena arena, Collection<Combatant> winners) {
		this.arena = arena;
		this.winners = winners;
	}

	//-----Public Methods-----//
	public Arena getArena() {
		return this.arena;
	}
	
	public Collection<Combatant> getWinners() {
		return this.winners;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}
