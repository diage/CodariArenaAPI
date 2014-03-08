package com.codari.arena5.item.assets;

import com.codari.arena5.players.combatants.Combatant;

public interface Prefix extends ItemAsset {

	public void applyOnHitEffect(Combatant attackingCombatant, Combatant defendingCombatant);
	
}
