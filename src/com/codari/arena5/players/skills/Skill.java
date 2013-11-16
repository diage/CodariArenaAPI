package com.codari.arena5.players.skills;

/**
 * Skill is a basic castable action which ought to be associated with a {@link Role}. 
 * 	
 * @author Ryan, Michael
 *
 */
public interface Skill {	
	/**
	 * Method to be called which contains the logic pertaining to what this skill will do. 
	 */
	public void activateSkill();
}