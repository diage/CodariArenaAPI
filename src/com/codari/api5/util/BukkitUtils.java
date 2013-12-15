package com.codari.api5.util;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import com.codari.api5.util.reflect.Reflector;

public class BukkitUtils {
	//-----Private Constructor-----//
	private BukkitUtils(){}
	
	//-----Static Methods-----//
	public static void throwPotion(LivingEntity entity, ItemStack potion) {
		if (entity == null) {
			return;
		}
		if (potion == null || potion.getType() != Material.POTION) {
			return;
		}
		
		//Gets the net.minecraft.server instance of World
		Reflector nmsWorld = new Reflector(entity.getWorld()).invoke("getHandle");
		
		//gets the net.minecraft.server instance of LivingEntity
		Reflector nmsLivingEntity = new Reflector(entity).invoke("getHandle");
		
		//gets the class net.minecraft.server.EntityPotion
		Class<?> thrownPotionClass = Reflector.getNMSClass("EntityPotion");
		
		//gets the class org.bukkit.craftbukkit.<MINECRAFT VERSION>.inventory.CraftItemStack
		Class<?> craftItemStack = Reflector.getCBClass("inventory.CraftItemStack");
		
		//gets the org.bukkit.craftbukkit instance of ItemStack
		Reflector nmsPotion = Reflector.invokeStaticMethod(craftItemStack, "asNMSCopy", potion);
		
		//Constructs the thrown potion entity
		Reflector thrownPotion = Reflector.invokeConstructor(thrownPotionClass,
				nmsWorld.getHandle(), nmsLivingEntity.getHandle(), nmsPotion.getHandle());
		
		//Adds the thrown potion entity to the world
		nmsWorld.invoke("addEntity", thrownPotion.getHandle());
	}
}