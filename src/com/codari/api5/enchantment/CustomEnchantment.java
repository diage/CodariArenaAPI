package com.codari.api5.enchantment;

import org.bukkit.enchantments.Enchantment;

public abstract class CustomEnchantment extends Enchantment {
	//-----Constructor-----//
	public CustomEnchantment(int id) {
		super(id);
	}
	
	//-----Utility Methods-----//
	public final String toString() {
		return super.toString();
	}
	
	public final int hashCode() {
		return super.hashCode();
	}
	
	public final boolean equals(Object obj) {
		return super.equals(obj);
	}
}
