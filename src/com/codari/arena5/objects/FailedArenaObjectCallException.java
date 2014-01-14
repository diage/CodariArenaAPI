package com.codari.arena5.objects;

public class FailedArenaObjectCallException extends RuntimeException {
	private static final long serialVersionUID = -1703681905850326590L;
	//-----Constructors-----//
	public FailedArenaObjectCallException() {
		super();
	}
	
	public FailedArenaObjectCallException(String message) {
		super(message);
	}
	
	public FailedArenaObjectCallException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FailedArenaObjectCallException(Throwable cause) {
		super(cause);
	}
}