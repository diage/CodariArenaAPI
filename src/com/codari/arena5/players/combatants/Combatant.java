package com.codari.arena5.players.combatants;

import com.codari.api5.util.PlayerReference;
import com.codari.arena5.Arena;
import com.codari.arena5.players.role.Role;
/**
 * In game representation of a player. This is how the {@link Arena} and any arena-related object will reference the player.
 * 
 *  A combatant will store a reference to the {@link Arena} they are playing in and a {@link TeamColor} for the team they are on.
 *  It has a reference to the {@link CombatantStats} as well.
 *  They will also store a reference to a {@link Role} that this combatant currently has. 
 * @author Ryan
 *
 */
public interface Combatant {
	
	/**
	 * This will get the {@Link PlayerReference} Associated with this Combatant.
	 * 
	 * Refer to {@Link PlayerReference} for more information.
	 * @return The PlayerReference for this combatant. 
	 */
	public PlayerReference getPlayerReference();
	
	/**
	 * Reference to the Stats for this player.
	 * 
	 * @return The {@link CombatantStats} for this particular combatant. 
	 */
	public CombatantStats getStats();
	
	/**
	 * Allows the retrieval of the role for a current match this combatant is in. 
	 * 
	 * @return The role this combatant is currently playing if they're in a game,
	 * 	otherwise the Non-Competing role will be used. 
	 */
	public Role getRole();
	
	/**
	 * Will return a string value associated with the {@link Arena} this Combatant is currently playing in.
	 *  
	 * @return The string for the Arena the Combatant is currently in. 
	 */
	public String getArenaName();
	
	/**
	 * Sends this combatant to an {@link Arena} with a specified {@link Role}. 
	 * 
	 * @param arena The Arena to send this combatant to. 
	 * @param role The Role for this combatant to play as.
	 * @return True if the player was successfully added to the Arena, false otherwise. 
	 */
	public boolean sendToArena(Arena arena, Role role);
	
	/**
	 * Sends this Combatant back to a Non-Competing {@link Role} and removes this from the {@link Arena}.
	 * 
	 * @return True if the player was successfully removed from an Arena, false otherwise. 
	 */
	public boolean leaveArena();
	
	/**
	 * Method to swap the {@link Role} of this combatant while in an {@link Arena}. This method should not be used to set a 
	 * 	{@link Role} for a player starting a match, use sendToArena instead. 
	 *  
	 * @param role The role to switch the player to 
	 * @return The role the player had before. This will return null if the player is not in an arena. 
	 */
	public Role swapRole(Role role);
}