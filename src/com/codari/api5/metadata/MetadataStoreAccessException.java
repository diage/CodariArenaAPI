package com.codari.api5.metadata;

import com.codari.api5.CodariException;

public class MetadataStoreAccessException extends CodariException {
	private static final long serialVersionUID = -3720855639699852757L;
	//-----Constructors-----//
	public MetadataStoreAccessException() {
		super();
	}
	
	public MetadataStoreAccessException(String message) {
		super(message);
	}
	
	public MetadataStoreAccessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MetadataStoreAccessException(Throwable cause) {
		super(cause);
	}
}