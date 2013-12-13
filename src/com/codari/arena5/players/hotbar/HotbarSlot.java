package com.codari.arena5.players.hotbar;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public enum HotbarSlot {
	//-----Enumerations-----//
	HOTBAR_1(0),
	HOTBAR_2(1),
	HOTBAR_3(2),
	HOTBAR_4(3),
	HOTBAR_5(4),
	HOTBAR_6(5);
	
	//-----Fields-----//
	private final int inventorySlot;
	
	//-----Constructor-----//
	private HotbarSlot(int inventorySlot) {
		this.inventorySlot = inventorySlot;
	}
	
	//-----Public Methods-----//
	public int getInventorySlot() {
		return this.inventorySlot;
	}
	
	public static boolean isHotbarSlot(int inventorySlot) {
		return inventorySlot >= 0 && inventorySlot < 6;
	}
	
	public static HotbarSlot fromInventorySlot(int inventorySlot) throws IndexOutOfBoundsException {
		return values()[inventorySlot];
	}
	
	public ItemStack getItem(Player player) {
		return player.getInventory().getItem(this.inventorySlot);
	}
}