package com.codari.api5.attribute;

public class InvalidAttributeException extends RuntimeException {
	private static final long serialVersionUID = -8564030597627391380L;
	//-----Constructor-----//
	public InvalidAttributeException(String message) {
		super(message);
	}
}
