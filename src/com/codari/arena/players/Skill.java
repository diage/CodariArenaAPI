package com.codari.arena.players;

import com.codari.arena.players.combatants.Combatant;

/**
 * Skill is a basic which ought to be associated with a {@link Role}. 
 * @author Ryan
 *
 */
public interface Skill {
	public void activateSkill(Combatant combatant);
}