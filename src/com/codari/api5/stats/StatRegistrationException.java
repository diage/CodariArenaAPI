package com.codari.api5.stats;

/**
 * <p>Exception thrown when registering a {@link StatType} to a {@link StatHolder}
 * could not be done for any reason.</p>
 * 
 * @author Soren025
 */
public class StatRegistrationException extends RuntimeException {
	private static final long serialVersionUID = -5876075007145115435L;
	//-----Constructors-----//
	public StatRegistrationException() {
		super();
	}
	
	public StatRegistrationException(String message) {
		super(message);
	}
	
	public StatRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StatRegistrationException(Throwable cause) {
		super(cause);
	}
}