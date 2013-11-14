package com.codari.api5.metadata;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

public interface MetadataManager {
	public MetadataStore<Entity> getEntityMetadataStore();
	public MetadataStore<OfflinePlayer> getPlayerMetadataStore();
	public MetadataStore<World> getWorldMetadataStore();
	public MetadataStore<Block> getBlockMetadataStore(World world) throws MetadataStoreAccessException;
	public MetadataValue getMetadata(Metadatable metadatable, String metadataKey, Plugin plugin);
}