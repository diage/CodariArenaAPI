package com.codari.api5.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.arena.Arena;

public class ArenaEndEvent extends Event{
	//-----Static Fields-----//
		private static final HandlerList handlers = new HandlerList();

		//-----Static Methods-----//
		public static HandlerList getHandlerList() {
			return handlers;
		}

		//-----Fields-----//
		private final Arena arena;

		//-----Constructor-----//
		public ArenaEndEvent(Arena arena) {
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
}
