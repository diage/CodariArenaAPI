package com.codari.arena.players.combatants;
//FIXME: Consider Removing this from the Arena API. 
public class CombatantStatsException extends RuntimeException {
	private static final long serialVersionUID = -2512936718914848823L;
	//-----Constructors-----//
	public CombatantStatsException() {
		super();
	}
	
	public CombatantStatsException(String message) {
		super(message);
	}
	
	public CombatantStatsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CombatantStatsException(Throwable cause) {
		super(cause);
	}
}