package com.codari.arena5;

import com.codari.arena5.arena.rules.timedaction.TimedAction;
import com.codari.arena5.arena.rules.wincondition.WinCondition;
import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.players.skills.Skill;

public interface Library {
	public void registerWinCondition(Class<? extends WinCondition> clazz);

	public void registerTimedAction(Class<? extends TimedAction> clazz);
	
	public void registerArenaObject(Class<? extends ArenaObject> clazz);

	public void registerSkill(Class<? extends Skill> clazz);
}
