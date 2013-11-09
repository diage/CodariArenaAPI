package com.codari.arena.combatants.items;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
/**
 * Container for items which will be used within the {@Link Arena}.
 * @author Ryan
 *
 */
public interface ArenaItem extends ConfigurationSerializable {
	/**
	 * Method to get the name of the Item provided.
	 * @return The display name of the {@Link ItemStack} wrapped by this.
	 */
	public String getName();
	/**
	 * Method to get the {@Link ItemStack} which is wrapped by the ArenaItem
	 * @return The ItemStack wrapped by this.
	 */
	public ItemStack getItemStack();
	/**
	 * Gets the {@Link ItemType} of the ArenaItem.
	 * @return The ItemType. 
	 */
	public ItemType getType();
	/**
	 * Returns a random ArenaItem not in any way associated with this.
	 * @return A random ArenaItem. 
	 */
	public ArenaItem getRandom();
}
