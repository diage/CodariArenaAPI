package com.codari.api5.player;

import java.util.UUID;

import org.bukkit.OfflinePlayer;

public interface CodariPlayerManager {
	public CodariPlayer getCodariPlayer(UUID uuid);
	public CodariPlayer getCodariPlayer(OfflinePlayer player);
	public boolean isOnline(UUID uuid);
	public boolean isOnline(OfflinePlayer player);
	public void setPerm(UUID uuid, String perm, boolean value);
}