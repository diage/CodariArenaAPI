package com.codari.api5.asset;

public abstract class Asset {
	//-----Fields-----//
	private AssetEntry entry;
	
	//-----Constructor-----//
	protected Asset() {}
	
	//-----Methods-----//
	public final String getName() {
		return this.entry.getName();
	}
	
	public final AssetType getType() {
		return this.entry.getType();
	}
	
	public final String getRegistration() {
		return this.entry.getRegistration();
	}
	
	public final String getFullName() {
		return this.entry.getFullName();
	}
}
