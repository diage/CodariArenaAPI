package com.codari.arena5.item.assets;

import com.codari.arena5.players.combatants.Combatant;

public interface Spell extends ItemAsset {
	public void cast(Combatant combatant);
}
