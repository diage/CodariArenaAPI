package com.codari.arena.combatants;

public class CombatantDataException extends RuntimeException {
	private static final long serialVersionUID = -2512936718914848823L;
	//-----Constructors-----//
	public CombatantDataException() {
		super();
	}
	
	public CombatantDataException(String message) {
		super(message);
	}
	
	public CombatantDataException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CombatantDataException(Throwable cause) {
		super(cause);
	}
}