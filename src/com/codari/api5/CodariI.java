package com.codari.api5;

import org.bukkit.plugin.Plugin;

import com.codari.api5.attribute.AttributeFactory;
import com.codari.api5.enchantment.EnchantmentManager;
import com.codari.api5.itemdata.ItemDataManager;
import com.codari.api5.player.CodariPlayerManager;
import com.codari.arena5.Library;
import com.codari.arena5.arena.ArenaManager;
import com.codari.arena5.players.guilds.GuildManager;
import com.codari.arena5.players.teams.TeamManager;

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
	
	public TeamManager getTeamManager();
	
	public GuildManager getGuildManager();
	
	public AttributeFactory getAttributeFactory();
	
	public Library getLibrary();
	
	public EnchantmentManager getEnchantmentManager();
	
	public ItemDataManager getItemDataManager();

}
