package com.codari.api5.player;

import org.bukkit.entity.Player;

import com.codari.api5.util.Wrapper;

public interface CodariPlayer extends Wrapper<Player>, Player {
	public Player getHandle();
	public boolean isValidPlayer();
}