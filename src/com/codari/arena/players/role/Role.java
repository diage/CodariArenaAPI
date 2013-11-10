package com.codari.arena.players.role;

import com.codari.arena.players.Skill;

/**
 * A role identifies core characteristics about how the player will interact within the game. 
 * 	These roles can be used to define skills and spells players have the ability to use or interact with.
 * @author Ryan
 *
 */
public interface Role {
	
	/**
	 * Retrieves the skill for this role. 
	 * @return The {@link Skill} associated for the role in question. 
	 */
	public Skill getSkill();
}
