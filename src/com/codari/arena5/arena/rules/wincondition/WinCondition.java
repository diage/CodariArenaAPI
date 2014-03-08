package com.codari.arena5.arena.rules.wincondition;

import java.util.Collection;

import org.bukkit.event.Listener;

import com.codari.arena5.arena.Arena;
import com.codari.arena5.players.combatants.Combatant;

public interface WinCondition extends Listener {

	public boolean conditionMet();
	
	public void setRegistered(boolean registered);
	
	public void initialize(Arena arena);
	
	public Collection<Combatant> getWinners();
}
