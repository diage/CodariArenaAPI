package com.codari.api5.asset;

public class InvalidAssetDescriptionFileException extends Exception {
	private static final long serialVersionUID = -6103347025081605135L;
	//-----Constructors-----//
	public InvalidAssetDescriptionFileException() {
		super();
	}
	
	public InvalidAssetDescriptionFileException(String message) {
		super(message);
	}
	
	public InvalidAssetDescriptionFileException(Throwable cause, String message) {
		super(message, cause);
	}
	
	public InvalidAssetDescriptionFileException(Throwable cause) {
		super(cause);
	}
}
