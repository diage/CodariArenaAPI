package com.codari.arena.combatants;

import com.codari.arena.combatants.combatants.Combatant;

public abstract class Skill {
	public abstract boolean isConditionMet(Combatant combatant);
}