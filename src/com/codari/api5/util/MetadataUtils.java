package com.codari.api5.util;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataStore;

import com.codari.api5.util.reflect.Reflector;

public class MetadataUtils {
	//-----Private Constructor-----//
	private MetadataUtils(){}
	
	//-----Static Methods-----//
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getEntityMetadataStore() {
		return (MetadataStore<OfflinePlayer>)
				new Reflector(Bukkit.getServer()).read("entityMetadata").getHandle();
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getPlayerMetadataStore() {
		return (MetadataStore<OfflinePlayer>)
				new Reflector(Bukkit.getServer()).read("playerMetadata").getHandle();
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getWorldMetadataStore() {
		return (MetadataStore<OfflinePlayer>)
				new Reflector(Bukkit.getServer()).read("worldMetadata").getHandle();
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<Block> getBlockMetadataStore(World world) {
		return (MetadataStore<Block>)
				new Reflector(world).read("blockMetadata").getHandle();
	}
}
