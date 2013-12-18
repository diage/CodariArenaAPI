package com.codari.api5.enchantment;

import org.bukkit.inventory.ItemStack;

public interface EnchantmentManager {
	public void registerEnchantment(CustomEnchantment enchantment);
	public boolean containsCustomEnchantment(ItemStack itemStack);
}