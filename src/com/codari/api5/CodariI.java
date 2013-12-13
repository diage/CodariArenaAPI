package com.codari.api5;

import org.bukkit.plugin.Plugin;

import com.codari.api5.player.CodariPlayerManager;
import com.codari.api5.stats.StatFactory;
import com.codari.arena5.ArenaManager;
import com.codari.arena5.Library;

/**
 * Codari instance of {@link org.bukkit.plugin.Plugin}.
 * 
 * @author Soren025
 */
public interface CodariI extends Plugin {
	//-----Instance Field-----//
	/**
	 * Instance of the Codari Plugin, this value is null if the plugin is not enabled.
	 */
	public final static CodariI INSTANCE = null;
	
	//-----Methods-----//
	public CodariPlayerManager getCodariPlayerManager();
	
	/**
	 * Gets the Arena Manager of the plugin.
	 * 
	 * @return The Arena Manager.
	 */
	public ArenaManager getArenaManager();
	
	public StatFactory getStatFactory();
	
	public Library getLibrary();
}