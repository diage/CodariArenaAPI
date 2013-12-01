package com.codari.arena5;

import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.rules.roledelegation.RoleDeclaration;
import com.codari.arena5.rules.timedaction.TimedAction;
import com.codari.arena5.rules.wincondition.WinCondition;

public interface LibraryRegister {
	public Class<WinCondition>[] getWinConditions();
	public Class<TimedAction>[] getTimedActions();
	public Class<RoleDeclaration>[] getRoleDeclarations();
	public Class<ArenaObject>[] getArenaObjects();
}
