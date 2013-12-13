package com.codari.api5.util;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.metadata.MetadataStore;

import com.codari.api5.util.reflect.Reflector;

public class MetadataUtils {
	//-----Private Constructor-----//111
	private MetadataUtils(){}
	
	//-----Static Methods-----//
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getEntityMetadataStore() {
		return new Reflector(Bukkit.getServer()).read("entityMetadata").getHandleAs(MetadataStore.class);
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getPlayerMetadataStore() {
		return new Reflector(Bukkit.getServer()).read("playerMetadata").getHandleAs(MetadataStore.class);
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<OfflinePlayer> getWorldMetadataStore() {
		return new Reflector(Bukkit.getServer()).read("worldMetadata").getHandleAs(MetadataStore.class);
	}
	
	@SuppressWarnings("unchecked")//Confirmed in craftbukkit source
	public static MetadataStore<Block> getBlockMetadataStore(World world) {
		return new Reflector(world).read("blockMetadata").getHandleAs(MetadataStore.class);
	}
}
