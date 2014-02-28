package com.codari.api5.asset;

public class AssetRegistrationException extends Exception {
	private static final long serialVersionUID = -1594824406280424487L;
	//-----Constructors-----//
	public AssetRegistrationException(String message) {
		super(message);
	}
	
	public AssetRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AssetRegistrationException(Throwable cause) {
		super(cause);
	}
}
