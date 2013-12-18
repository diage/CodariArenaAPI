package com.codari.api5.itemdata;

import org.bukkit.inventory.ItemStack;

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
	
	//-----Abstract Methods-----//
	public abstract boolean canBeAppliedTo(ItemStack item);
	public void onApplication(ItemStack item){}
}