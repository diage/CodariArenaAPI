package com.codari.api5.exceptions;

/**
 * Thrown when an error occurred within the codari plugin core structure
 * 
 * @author Soren025
 */
public class CodariException extends RuntimeException {
	private static final long serialVersionUID = 6152626046093523246L;
	//-----Constructors-----//
	public CodariException() {
		super();
	}
	
	public CodariException(String message) {
		super(message);
	}
	
	public CodariException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CodariException(Throwable cause) {
		super(cause);
	}
}