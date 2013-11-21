package com.codari.arena5.players.teams;

import java.util.List;

import com.codari.arena5.Arena;
import com.codari.arena5.players.combatants.Combatant;
/**
 * Represents the team in which a {@link Combatants} is on when inside of an {@Link Arena}. 
 * 
 * Teams consist of a {@Link TeamColor} and a {@Link List} containing every {@Link Combatant} on the team. 
 * 
 * @author Ryan
 *
 */
public interface Team {
	
	/**
	 * Gets you a list containing every {@link Combatant} on this team.
	 * 
	 * @return A List of containing every {@link Combatant} on the team. 
	 */
	public List<Combatant> combatants();
	
	/**
	 * The {@Link Arena} in which this team is relevant. 
	 * 
	 * @return The {@Link Arena} for this team. 
	 */
	public Arena getArena();
	
	/** 
	 * The name of the team.
	 * 
	 * @return The name of the team.
	 */
	public String getTeamName();
	
	/**
	 * Gets you a list of every {@link Combatant} not counting the {@Link Combatant} provided. 
	 * 
	 * 	For this to return a meaningful {@link List}, the provided {@Link Combatant} must be from 
	 * 	this team. 
	 * 
	 * @param combatant A Combatant from the team.
	 * @return A {@link List} of every other {@link Combatant} other than the provided team mate. 
	 */
	public List<Combatant> getTeamMates(Combatant combatant);
	
	public void setLeader(Combatant combatant);
	
	public boolean isLeader(Combatant combatant);

	public void addToTeam(Combatant combatant);

	public void removeFromTeam(Combatant combatant);
}
