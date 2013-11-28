package com.codari.arena5.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.role.Role;

public class RoleSelectEvent extends Event {
	//-----Static Fields-----//
	private static final HandlerList handlers = new HandlerList();
	
	//-----Static Methods-----//
	public static HandlerList getHandlerList() {
		return RoleSelectEvent.handlers;
	}
	
	private Role role;
	private Combatant combatant;
	
	public RoleSelectEvent(Role role, Combatant combatant) {
		this.role = role;
		this.combatant = combatant;
	}

	public Combatant getCombatant() {
		return this.combatant;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	@Override
	public HandlerList getHandlers() {
		return RoleSelectEvent.handlers;
	}	
}
