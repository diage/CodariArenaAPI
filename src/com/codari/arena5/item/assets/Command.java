package com.codari.arena5.item.assets;

import com.codari.arena5.players.combatants.Combatant;


public interface Command extends ItemAsset {
	public void issue(Combatant combatant);
}
