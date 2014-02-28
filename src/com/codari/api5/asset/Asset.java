package com.codari.api5.asset;

public abstract class Asset {
	//-----Fields-----//
	private final AssetType type;
	
	//-----Constructor-----//
	protected Asset() throws InvalidAssetException {
		Class<? extends Asset> clazz = this.getClass();
		this.type = AssetType.getType(clazz);
		if (this.type == null) {
			throw new InvalidAssetException(clazz);
		}
	}
	
	//-----Methods-----//
	
	
	public final AssetType getType() {
		return this.type;
	}
}
