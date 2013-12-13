package com.codari.api5.player;

import org.bukkit.OfflinePlayer;
import org.bukkit.metadata.Metadatable;

import com.codari.api5.util.Wrapper;

public interface OfflineCodariPlayer extends Wrapper<OfflinePlayer>, OfflinePlayer, Metadatable {
	public CodariPlayer getCodariPlayer();
}