package com.codari.api5.io;

import java.io.IOException;

public class CodariSerializationException extends IOException {
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
