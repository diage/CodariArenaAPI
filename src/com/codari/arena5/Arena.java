package com.codari.arena5;

import java.util.Map;

import com.codari.arena5.players.teams.Team;

/**
 * Current representation of the primary Arena. 
 * 
 * The arena also has the task of keeping track of the time line running in the background for 
 * 	the game.
 * 
 * @author Ryan
 *
 */
public interface Arena {
	
	/**
	 * Get the name of this Arena. Note this may differ from the name requested.
	 *  
	 * @return The name of the Arena. 
	 */
	public String getName();
	
	/**
	 * Method to get all {@link Team}s for this Arena. 
	 * 
	 * @return A map containing the TeamColor to the Team. 
	 */
	public Map<String, Team> getTeams();

	public ArenaBuilder getArenaBuilder();
	
	public boolean start(Team... teams);
	
	public void stop();
}
