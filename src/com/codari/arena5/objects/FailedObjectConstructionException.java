package com.codari.arena5.objects;

public class FailedObjectConstructionException extends RuntimeException {
	private static final long serialVersionUID = -1703681905850326590L;
	//-----Constructors-----//
	public FailedObjectConstructionException() {
		super();
	}
	
	public FailedObjectConstructionException(String message) {
		super(message);
	}
	
	public FailedObjectConstructionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FailedObjectConstructionException(Throwable cause) {
		super(cause);
	}
}