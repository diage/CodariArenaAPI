package com.codari.arena5;

import org.bukkit.Location;

import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.rules.roledelegation.RoleDeclaration;
import com.codari.arena5.rules.timedaction.TimedAction;
import com.codari.arena5.rules.wincondition.WinCondition;

public interface Library {

	public WinCondition createWinCondition(String name, Location location);

	public TimedAction createTimedAction(String name, Location location);

	public RoleDeclaration createRoleDeclaration(String name, Location location);
	
	public ArenaObject createObject(String name, Location location);
	
	public void registerStuff(LibraryRegister register);

	public void registerWinCondition(Class<? extends WinCondition> clazz);

	public void registerTimedAction(Class<? extends TimedAction> clazz);

	public void registerRoleDeclaration(Class<? extends RoleDeclaration> clazz);

	public void registerArenaObject(Class<? extends ArenaObject> clazz);
}
