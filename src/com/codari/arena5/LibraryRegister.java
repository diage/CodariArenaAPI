package com.codari.arena5;

import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.rules.roledelegation.RoleDeclaration;
import com.codari.arena5.rules.timedaction.TimedAction;
import com.codari.arena5.rules.wincondition.WinCondition;

public interface LibraryRegister {
	public Class<? extends WinCondition>[] getWinConditions();
	public Class<? extends TimedAction>[] getTimedActions();
	public Class<? extends RoleDeclaration>[] getRoleDeclarations();
	public Class<? extends ArenaObject>[] getArenaObjects();//
}
