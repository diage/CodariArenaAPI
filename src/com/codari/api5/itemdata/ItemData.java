package com.codari.api5.itemdata;

public abstract class ItemData {
	//-----Fields-----//
	private final int id;
	
	//-----Constructor-----//
	public ItemData(int id) {
		this.id = id;
	}
	
	//-----Methods-----//
	public final int getId() {
		return this.id;
	}
}