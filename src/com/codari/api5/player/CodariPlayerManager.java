package com.codari.api5.player;

import org.bukkit.OfflinePlayer;

public interface CodariPlayerManager {
	public CodariPlayer getCodariPlayer(String name);
	public CodariPlayer getCodariPlayer(OfflinePlayer player);
	public boolean isOnline(String name);
	public boolean isOnline(OfflinePlayer player);
}