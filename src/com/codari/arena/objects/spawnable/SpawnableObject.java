package com.codari.arena.objects.spawnable;

import com.codari.arena.objects.ArenaObject;


/**
 * Spawnable refers to an {@link ArenaObject}s ability to, upon being told to by the arena, complete some task. 
 * 	These objects could be spawned just once or periodically. 
 * 
 * Examples of Spawnable Objects: Item Spawners and Mob Spawners.
 * 
 * @author Ryan
 *
 */

public interface SpawnableObject extends ArenaObject {
	/**
	 * Method for the server to tell the spawnable object to spawn.
	 * 
	 * The method to bring this in should be identical to the reveal method as well as any logic to allow it to act as needed. 
	 */
	public void spawn();
	
}
