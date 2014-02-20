package com.codari.arena5.objects.spawnable;

import org.bukkit.event.Listener;

public interface ListenerFixedSpawnableObject extends FixedSpawnableObject, Listener {
	public void setArenaName(String arenaName);
}
