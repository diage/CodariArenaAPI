package com.codari.arena5;

import java.util.Map;

import com.codari.arena5.players.teams.Team;
import com.codari.arena5.players.teams.TeamColor;

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
	public String getName();
	public Map<TeamColor, Team> getTeams();
	
}
