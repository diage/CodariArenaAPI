package com.codari.api5.asset;

public enum AssetType {
	//-----Enumerations-----//
	ASSET_PLACEHOLDER(Asset.class);
	
	//-----Static Methods-----//
	public static AssetType getType(Class<? extends Asset> clazz) {
		if (clazz == null) {
			return null;
		}
		for (AssetType value : values()) {
			if (value.getBaseClass().isAssignableFrom(clazz)) {
				return value;
			}
		}
		return null;
	}
	
	//-----Fields-----//
	private final Class<? extends Asset> baseClass;
	
	//-----Constructor-----//
	private AssetType(Class<? extends Asset> baseClass) {
		this.baseClass = baseClass;
	}
	
	//-----Methods-----//
	public Class<? extends Asset> getBaseClass() {
		return this.baseClass;
	}
	
	//-----Utility Methods-----//
	@Override
	public String toString() {
		return super.name().toLowerCase();
	}
}
