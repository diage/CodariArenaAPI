package com.codari.arena5.arena;

import java.util.UUID;

import org.bukkit.OfflinePlayer;

import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.teams.Team;

/**
 * The overall manager for any {@link Arena}. This will be used to keep track of currently existing Arenas 
 * 	as well as the lookup location for all {@link Combatants}s.
 * 
 * @author Ryan
 *
 */
public interface ArenaManager {
	
	/**
	 * Method to grab a {@link Combatant} from it's proper name. 
	 * 
	 * @param name The name of the {@link Combatant}, this is not case sensitive 
	 * 	and is the display name of the {@link Combatant} in question.
	 *  
	 * @return The requested {@link Combatant}
	 */
	public Combatant getCombatant(UUID uuid);
	
	/**
	 * Method to grab a {@link Combatant} from an {@link OfflinePlayer} reference. 
	 * 
	 * @param player The OfflinePlayer for this {@link Combatant}. 
	 * 	The Player in question would have had to of visited the server.
	 * 
	 * @return The requested {@link Combatant}
	 */
	public Combatant getCombatant(OfflinePlayer player);
	
	/**
	 * Method to get the {@Link Team} given a {@link Combatant}. 
	 * 
	 * @param combatant The {@link Combatant} of whom you want the {@Link Team}. 
	 * 
	 * @return The {@Link Team} for the provided {@link Combatant}.
	 * 	This method return null if they are not on a Team. 
	 */
	public Team getTeam(Combatant combatant);
	
	/**
	 * Provided with a valid name, this will get you the {@link Arena} associated with that name. 
	 * 
	 * @param name The name of the requested {@link Arena}. 
	 * 
	 * @return The requested {@link Arena}. 
	 */
	public Arena getArena(String name);
}
