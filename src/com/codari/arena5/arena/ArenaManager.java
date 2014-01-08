package com.codari.arena5.arena;

import java.io.File;

import org.bukkit.OfflinePlayer;

import com.codari.arena5.arena.rules.GameRule;
import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.role.Role;
import com.codari.arena5.players.teams.Team;
import com.codari.arena5.players.teams.TeamColor;

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
	 * Method to grab the team provided an {@link Arena} and a {@link TeamColor}.
	 * 
	 * @param arenaName The name of the Arena you want the team for. 
	 * @param teamColor The color of the team you want within the provided Arena.
	 * 
	 * @return The requested team
	 */
	public Team getTeam(String arenaName, String teamName);
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
	public Arena buildArena(String requestedName, ArenaBuilder arenaBuilder);
	
	/**
	 * Method to get a new clean {@link ArenaBuilder}.
	 *  
	 * @return A reference to a clean {@link ArenaBuilder}.
	 */
	public ArenaBuilder getArenaBuider(GameRule gameRule) throws IllegalArgumentException;

	public Role getNewRole(String name);

	public boolean submitRole(String arenaName, Role role);

	public Role getExistingRole(String arenaName, String roleName);

	public void clearRole(String arenaName, String roleName);

	public boolean addToQueue(String arenaName, Team team);
	
	public boolean saveArenaBuilder(String name, File file);
	
	public boolean loadArenaBuilder(String name, File file);
}
