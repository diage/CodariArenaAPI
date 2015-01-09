package com.codari.api5;

import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.codari.api5.asset.AssetLybrary;
import com.codari.api5.attribute.AttributeFactory;
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
	
	public static AttributeFactory getAttributeFactory() {
		return CodariI.INSTANCE.getAttributeFactory();
	}
	
	public static Player getPlayer(UUID uuid) {
		return CodariI.INSTANCE.getCodariPlayerManager().getCodariPlayer(uuid).getPlayer();
	}
	
	public static Player getPlayer(OfflinePlayer player) {
		return getPlayer(player.getUniqueId());
	}
	
	public static AssetLybrary getAssetLybrary() {
		return CodariI.INSTANCE.getAssetLybrary();
	}
}
