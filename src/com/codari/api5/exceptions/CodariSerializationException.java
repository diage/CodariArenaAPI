package com.codari.api5.exceptions;

public class CodariSerializationException extends RuntimeException {
	private static final long serialVersionUID = -5870807561662421178L;
	//-----Constructors-----//
	public CodariSerializationException() {
		super();
	}
	
	public CodariSerializationException(String message) {
		super(message);
	}
	
	public CodariSerializationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CodariSerializationException(Throwable cause) {
		super(cause);
	}
}
