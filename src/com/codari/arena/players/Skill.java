package com.codari.arena.players;

import com.codari.arena.players.combatants.Combatant;

public abstract class Skill {
	public abstract boolean isConditionMet(Combatant combatant);
}