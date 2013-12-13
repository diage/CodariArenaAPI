package com.codari.api5.player;

import org.bukkit.OfflinePlayer;

public interface CodariPlayerManager {
	public OfflineCodariPlayer getOfflineCodariPlayer(String name);
	public OfflineCodariPlayer getOfflineCodariPlayer(OfflinePlayer player);
	public OfflineCodariPlayer[] getOfflineCodariPlayers();
	public CodariPlayer getCodariPlayer(String name);
	public CodariPlayer getCodariPlayer(OfflinePlayer player);
	public CodariPlayer[] getOnlineCodariPlayers();
	public boolean isOnline(String name);
	public boolean isOnline(OfflinePlayer player);
}