package com.codari.arena;

import org.bukkit.OfflinePlayer;

import com.codari.api.util.PlayerReference;
import com.codari.arena.combatants.Combatant;

public interface ArenaManager {
	public Combatant getCombatant(String name);
	public Combatant getCombatant(OfflinePlayer player);
	public Combatant getCombatant(PlayerReference playerReference);
	
	public Arena getArena(String name);
}