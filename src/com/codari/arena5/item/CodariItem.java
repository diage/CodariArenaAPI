package com.codari.arena5.item;

import com.codari.arena5.players.combatants.Combatant;

public interface CodariItem {
	public String getSessionId();
	public String getItemId();
	public Combatant getCombatant();
	
}
