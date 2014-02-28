package com.codari.api5.asset;

public class InvalidAssetException extends Exception {
	private static final long serialVersionUID = 117469903788384446L;
	//-----Constructor-----//
	public InvalidAssetException(Class<? extends Asset> clazz) {
		super(String.valueOf(clazz));
	}
}
