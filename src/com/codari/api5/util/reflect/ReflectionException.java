package com.codari.api5.util.reflect;

/**
 * Exception thrown when a reflection attempt was unsuccessful.
 * 
 * @author Soren025
 * @see Reflector
 */
public class ReflectionException extends RuntimeException {
	private static final long serialVersionUID = -7473078064196572383L;
	//-----Constructors-----//
	public ReflectionException() {
		super();
	}
	
	public ReflectionException(String message) {
		super(message);
	}
	
	public ReflectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ReflectionException(Throwable cause) {
		super(cause);
	}
}
