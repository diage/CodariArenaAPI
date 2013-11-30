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
	
	private Role newRole;
	private Role previousRole;
	private Combatant combatant;
	private boolean swapped;
	
	public RoleSelectEvent(Role newRole, Combatant combatant) {
		this.newRole = newRole;
		this.previousRole = null;
		this.combatant = combatant;
		this.swapped = false;
	}
	
	public RoleSelectEvent(Role newRole, Role previousRole, Combatant combatant) {
		this.newRole = newRole;
		this.previousRole = previousRole;
		this.combatant = combatant;
		this.swapped = true;
	}

	public Combatant getCombatant() {
		return this.combatant;
	}
	
	public Role getNewRole() {
		return this.newRole;
	}
	
	public Role getPreviousRole() {
		return this.previousRole;
	}
	
	public boolean wasSwap() {
		return this.swapped;
	}
	
	@Override
	public HandlerList getHandlers() {
		return RoleSelectEvent.handlers;
	}	
}
