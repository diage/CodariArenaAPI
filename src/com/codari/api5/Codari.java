package com.codari.api5;

import com.codari.api5.attribute.AttributeFactory;
import com.codari.api5.enchantment.EnchantmentManager;
import com.codari.api5.itemdata.ItemDataManager;
import com.codari.api5.player.CodariPlayerManager;
import com.codari.arena5.Library;
import com.codari.arena5.arena.ArenaManager;
import com.codari.arena5.players.guilds.GuildManager;
import com.codari.arena5.players.teams.TeamManager;

public class Codari {
	public static CodariPlayerManager getCodariPlayerManager() {
		return CodariI.INSTANCE.getCodariPlayerManager();
	}
	
	public static ArenaManager getArenaManager() {
		return CodariI.INSTANCE.getArenaManager();
	}
	
	public static TeamManager getTeamManager() {
		return CodariI.INSTANCE.getTeamManager();
	}
	
	public static GuildManager getGuildManager() {
		return CodariI.INSTANCE.getGuildManager();
	}

	public static AttributeFactory getStatFactory() {
		return CodariI.INSTANCE.getAttributeFactory();
	}
	
	public static Library getLibrary() {
		return CodariI.INSTANCE.getLibrary();
	}
	
	public static EnchantmentManager getEnchantmentManager() {
		return CodariI.INSTANCE.getEnchantmentManager();
	}
	
	public static ItemDataManager getItemDataManager() {
		return CodariI.INSTANCE.getItemDataManager();
	}
	
	public static AttributeFactory getAttributeFactory() {
		return CodariI.INSTANCE.getAttributeFactory();
	}
}
