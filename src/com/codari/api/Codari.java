package com.codari.api;

import org.bukkit.plugin.Plugin;

import com.codari.api.metadata.MetadataManager;
import com.codari.arena.ArenaManager;

/**
 * Codari instance of {@link org.bukkit.plugin.Plugin}.
 * 
 * @author Soren025
 */
public interface Codari extends Plugin {
	//-----Instance Field-----//
	/**
	 * Instance of the Codari Plugin, this value is null if the plugin is not enabled.
	 */
	public final static Codari INSTANCE = null;
	
	//-----Methods-----//
	public MetadataManager getMetadataManager();
	/**
	 * Gets the Arena Manager of the plugin.
	 * 
	 * @return The Arena Manager.
	 */
	public ArenaManager getArenaManager();
}