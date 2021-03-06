package com.codari.api5.events;

import java.util.Collection;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.arena.Arena;
import com.codari.arena5.players.combatants.Combatant;

public class ArenaWinEvent extends Event {
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
	public ArenaWinEvent(Arena arena, Collection<Combatant> winners) {
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
