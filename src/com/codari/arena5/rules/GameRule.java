package com.codari.arena5.rules;

import com.codari.api5.util.Tick;

/**
 * Game rules will be static objects inserted into the time line upon registration. They will define passive actions, 
 * 	win conditions, and the total Match Duration. 
 * 
 * To be a valid GameRule, it must contain at least one win condition and a match duration. 
 * @author Ryan
 *
 */
public interface GameRule {
	/**
	 * Method to declare the valid team size which must be met before the game will accept a team. 
	 * 
	 * @param teamSize The size to set teams to for this game rule. 
	 */
	public void setTeamSize(int teamSize);
	/**
	 * Add a condition such that if it is ever met, the game will immediately end and declare victors.
	 * 
	 * @param winCondition The condition to be added.
	 */
	public void addWinCondition(WinCondition winCondition);
	/**
	 * Add a win condition which is only valid before or after a certain point in time.
	 * 
	 * @param winCondition The condition to be added. 
	 * @param time The time which either before or after it the win condition is valid.
	 * @param after If this true, then the win condition will be valid after the time, otherwise it will be valid before the time. 
	 * @return True if the win condition can possibly be met before the end of the game, false otherwise. 
	 */
	public boolean addWinCondition(WinCondition winCondition, Tick time, boolean after);
	/**
	 * Removes the provided win condition from the current selection of win conditions.
	 * 
	 * @param winCondition The win condition to remove. 
	 */
	public void removeWinCondition(WinCondition winCondition);
	/**
	 * Set the duration of the match. Setting this more than once will overwrite the previous Match Duration.
	 * 
	 * @param time The time at which to end. 
	 */
	public void setMatchDuration(Tick time);
	/**
	 * Set the duration of the match to be infinite. If a Time is already registered, it will be removed.
	 * 
	 * 	Registering a time after this will set it to that time. 
	 */
	public void setMatchDurationInfinite();
	/**
	 * Add a passive action to happen along the time line of the arena. 
	 * @param action The Timed Action to be performed. 
	 * @return True if the action was able to have it and it's first execution before the designated end time. False otherwise.
	 * 
	 */
	public boolean addAction(TimedAction action);
	/**
	 * Check to see if a duration and at least one win condition have been set.
	 * 	Only a valid Game Rule can be added to the arena.
	 * 
	 * @return True if the duration is set and at least one win condition exists, false otherwise. 
	 */
	public boolean isValid();
}
