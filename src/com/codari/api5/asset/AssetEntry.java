package com.codari.api5.asset;

import com.codari.api5.asset.type.AssetType;

public interface AssetEntry {
	public String getRegistration();
	public String getName();
	public AssetType getType();
	public String getFullName();
}
