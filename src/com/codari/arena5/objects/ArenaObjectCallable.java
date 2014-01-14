package com.codari.arena5.objects;

import org.bukkit.Location;

import com.codari.arena5.players.combatants.Combatant;

public interface ArenaObjectCallable<T extends ArenaObject> {
	public T call(Combatant builder, Location clickedBlock) throws FailedArenaObjectCallException;
}