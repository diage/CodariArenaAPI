package com.codari.arena5.item;

import com.codari.arena5.players.combatants.Combatant;

public interface CodariItem {
	
	public Combatant getCombatant();
	public void attack(Combatant enemy);
	public int getStackSize();
	public void addStackSize(int size);
	public void getAttributes();
	public void levelUp();
	public void addExp(int exp);
	public void use();
}
