package com.codari.api5.itemdata;

import org.bukkit.inventory.ItemStack;

public interface ItemDataManager {
	public void registerItemData(ItemData data);
	public ItemStack setItemData(ItemStack item, int id);
	public ItemStack setItemData(ItemStack item, ItemData data);
	public ItemData getItemData(ItemStack item);
}