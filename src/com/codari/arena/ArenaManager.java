package com.codari.arena;

import org.bukkit.OfflinePlayer;

import com.codari.api.util.PlayerReference;
import com.codari.arena.players.combatants.Combatant;

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
	public Combatant getCombatant(String name);
	
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
	 * Method to grab a {@link Combatant} from it's {@link PlayerReference}.
	 * 	Refer to {@link PlayerReference] for more information. 
	 * 
	 * @param playerReference The {@link PlayerReference} for the {@link Combatant} in question. 
	 * 
	 * @return The requested {@link Combatant}
	 */
	public Combatant getCombatant(PlayerReference playerReference);
	
	/**
	 * Provided with a valid name, this will get you the {@link Arena} associated with that name. 
	 * 
	 * @param name The name of the requested {@link Arena}. 
	 * 
	 * @return The requested {@link Arena}. 
	 */
	public Arena getArena(String name);
	
	/**
	 * Returns the Arena associated with the {@link ArenaBuilder} which is passed in. The Arena in question will have
	 * 	a name based off of the requestedName but is not gaurnteed to be identical. 
	 * 
	 * @param arenaBuilder The builder which has the configuration for the requested {@link Arena}
	 * @param requestedName The name the new arena will be based off. If a duplicate name exists, this arena manager will use
	 * 	the requested name as a base and adjust it to a unique name. 
	 * 
	 * @return The Arena which is built. Will return null if the ArenaBuilder is not properly built. 
	 */
	public Arena buildArena(ArenaBuilder arenaBuilder, String requestedName);
	
	/**
	 * Method to get a new clean {@link ArenaBuilder}.
	 *  
	 * @return A reference to a clean {@link ArenaBuilder}.
	 */
	public ArenaBuilder getArenaBuider();
}