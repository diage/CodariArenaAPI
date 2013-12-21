package com.codari.arena5.rules.wincondition;

import java.io.Serializable;
import java.util.Collection;

import org.bukkit.event.Listener;

import com.codari.arena5.arena.Arena;
import com.codari.arena5.players.combatants.Combatant;

public interface WinCondition extends Listener, Serializable {

	public boolean conditionMet();
	
	public void setRegistered(boolean registered);
	
	public void initialize(Arena arena);
	
	public Collection<Combatant> getWinners();
}
