package com.codari.arena5.players;

import com.codari.arena5.players.combatants.Combatant;

/**
 * Skill is a basic castable action which ought to be associated with a {@link Role}. 
 * @author Ryan
 *
 */
public interface Skill {
	public void activateSkill(Combatant combatant);
}