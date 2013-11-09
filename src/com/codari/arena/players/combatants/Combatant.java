package com.codari.arena.players.combatants;

import com.codari.api.util.PlayerReference;
/**
 * In game representation of a player. This is how the {@link Arena} and any arena-related object will reference the player.
 * 
 *  A combatant will store a reference to the {@link Arena} they are playing in and a {@link TeamColor} for the team they are on. 
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
	public CombatantStats getData();
	public void reloadData();
	public void saveData();
}