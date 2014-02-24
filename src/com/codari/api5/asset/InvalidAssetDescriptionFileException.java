package com.codari.api5.asset;

import org.bukkit.plugin.InvalidDescriptionException;

public class InvalidAssetDescriptionFileException extends InvalidDescriptionException {
	private static final long serialVersionUID = -6103347025081605135L;
	//-----Constructors-----//
	public InvalidAssetDescriptionFileException() {
		super();
	}
	
	public InvalidAssetDescriptionFileException(String message) {
		super(message);
	}
	
	public InvalidAssetDescriptionFileException(Throwable cause, String message) {
		super(cause, message);
	}
	
	public InvalidAssetDescriptionFileException(Throwable cause) {
		super(cause);
	}
}
