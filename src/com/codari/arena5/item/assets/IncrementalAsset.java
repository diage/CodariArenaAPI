package com.codari.arena5.item.assets;

public interface IncrementalAsset extends ItemAsset {

	public void increment(int amount);
	
	public void decrement(int amount);
	
}
