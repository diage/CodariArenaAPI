package com.codari.arena.players.items;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
/**
 * The enumeration primarily used to represent Item Types. 
 * @author Soren
 *
 */
@SerializableAs(ItemType.SERIALIZATION_STRING)
public enum ItemType implements ConfigurationSerializable {
	/**
	 * WEAPONS!
	 */
	WEAPON(Material.GOLD_BLOCK),
	/**
	 * ARMOR!
	 */
	ARMOR(Material.DIAMOND_BLOCK),
	/**
	 * POTIONS!
	 */
	POTION(Material.REDSTONE_BLOCK),
	/**
	 * NOTHING!
	 */
	NONE(Material.STONE);
	
	final static String SERIALIZATION_STRING = "Item_Type";
	
	//-----Static Methods-----//
	public static ItemType getFromMaterial(Material material) {
		switch (material) {
		case WOOD_SWORD:
		case STONE_SWORD:
		case GOLD_SWORD:
		case IRON_SWORD:
		case DIAMOND_SWORD:
			return ItemType.WEAPON;
		case LEATHER_BOOTS:
		case LEATHER_LEGGINGS:
		case LEATHER_CHESTPLATE:
		case LEATHER_HELMET:
		case GOLD_BOOTS:
		case GOLD_LEGGINGS:
		case GOLD_CHESTPLATE:
		case GOLD_HELMET:
		case IRON_BOOTS:
		case IRON_LEGGINGS:
		case IRON_CHESTPLATE:
		case IRON_HELMET:
		case DIAMOND_BOOTS:
		case DIAMOND_LEGGINGS:
		case DIAMOND_CHESTPLATE:
		case DIAMOND_HELMET:
			return ItemType.ARMOR;
		case POTION:
			return ItemType.POTION;
		default:
			return ItemType.NONE;
		}
	}
	
	//-----Fields-----//
	private final Material indicator;
	
	//-----Constructor-----//
	private ItemType(Material indicator) {
		this.indicator = indicator;
	}
	
	//-----Public Methods-----//
	public Material getIndicator() {
		return this.indicator;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("value", this.toString());
		return null;
	}
	
	public static ItemType deserialize(Map<String, Object> args) {
		return ItemType.valueOf(((String) args.get("value")).toUpperCase());
	}
}