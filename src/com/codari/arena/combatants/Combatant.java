package com.codari.arena.combatants;

import com.codari.api.util.PlayerReference;

public interface Combatant {
	/**
	 * This will get the {@Link PlayerReference} Associated with this Combatant.
	 * 
	 * Refer to {@Link PlayerReference} for more information.
	 * @return The PlayerReference for this combatant. 
	 */
	public PlayerReference getPlayerReference();
	public CombatantData getData();
	public void reloadData();
	public void saveData();
}