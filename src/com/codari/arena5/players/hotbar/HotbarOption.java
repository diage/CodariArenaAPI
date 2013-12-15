package com.codari.arena5.players.hotbar;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public enum HotbarOption {
	//-----Enumerations-----//
	HOTBAR_1(0),
	HOTBAR_2(1),
	HOTBAR_3(2),
	HOTBAR_4(3),
	HOTBAR_5(4),
	HOTBAR_6(5),
	HOTBAR_DROP;
	
	//-----Fields-----//
	private final int inventorySlot;
	
	//-----Constructor-----//
	private HotbarOption(int inventorySlot) {
		this.inventorySlot = inventorySlot;
	}
	
	private HotbarOption() {
		this.inventorySlot = -1;
	}
	
	//-----Public Methods-----//
	public int getInventorySlot() {
		return this.inventorySlot;
	}
	
	public boolean isInventorySlot() {
		return this.inventorySlot != -1;
	}
	
	public static boolean isHotbarOption(int inventorySlot) {
		return inventorySlot >= 0 && inventorySlot < 6;
	}
	
	public static HotbarOption fromInventorySlot(int inventorySlot) throws ArrayIndexOutOfBoundsException {
		if (inventorySlot < 0 || inventorySlot >= 6) {
			throw new ArrayIndexOutOfBoundsException(inventorySlot);
		}
		return values()[inventorySlot];
	}
	
	public ItemStack getItem(Player player) {
		if (!this.isInventorySlot()) {
			return null;
		}
		return player.getInventory().getItem(this.inventorySlot);
	}
	
	public void setItem(Player player, ItemStack item) {
		if (!this.isInventorySlot()) {
			return;
		}
		player.getInventory().setItem(this.inventorySlot, item);
	}
}