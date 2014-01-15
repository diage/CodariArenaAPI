package com.codari.arena5;

import com.codari.arena5.arena.rules.roledelegation.RoleDeclaration;
import com.codari.arena5.arena.rules.timedaction.TimedAction;
import com.codari.arena5.arena.rules.wincondition.WinCondition;
import com.codari.arena5.objects.ArenaObject;

public interface Library {
	public void registerWinCondition(Class<? extends WinCondition> clazz);

	public void registerTimedAction(Class<? extends TimedAction> clazz);

	public void registerRoleDeclaration(Class<? extends RoleDeclaration> clazz);
	
	public void registerArenaObject(Class<? extends ArenaObject> clazz);
}
