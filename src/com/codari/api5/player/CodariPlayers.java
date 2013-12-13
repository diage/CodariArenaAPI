package com.codari.api5.player;

import org.bukkit.OfflinePlayer;

import com.codari.api5.Codari;

public final class CodariPlayers {
	//-----Private Constructor-----//
	private CodariPlayers(){}
	
	//-----Static Methods-----//
	public static CodariPlayerManager getManager() {
		return Codari.getCodariPlayerManager();
	}
	
	public static OfflineCodariPlayer getOfflineCodariPlayer(String name) {
		return getManager().getOfflineCodariPlayer(name);
	}
	
	public static OfflineCodariPlayer getOfflineCodariPlayer(OfflinePlayer player) {
		return getManager().getOfflineCodariPlayer(player);
	}
	
	public static OfflineCodariPlayer[] getOfflineCodariPlayers() {
		return getManager().getOfflineCodariPlayers();
	}
	
	public static CodariPlayer getCodariPlayer(String name) {
		return getManager().getCodariPlayer(name);
	}
	
	public static CodariPlayer getCodariPlayer(OfflinePlayer player) {
		return getManager().getCodariPlayer(player);
	}
	
	public static CodariPlayer[] getOnlineCodariPlayers() {
		return getManager().getOnlineCodariPlayers();
	}
	
	public static boolean isOnline(String name) {
		return getManager().isOnline(name);
	}
	
	public static boolean isOnline(OfflinePlayer player) {
		return getManager().isOnline(player);
	}
}