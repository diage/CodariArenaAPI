package com.codari.arena.objects;
/**
 * A specialized type of {@Link ArenaObject}.
 * 	This Object will spawn every time it is told to spawn based on a fixed schedule.
 * 	You should expect a guarantee that this object spawns at the predetermined time if it is 
 * 		already not spawned.  
 * @author Ryan
 *
 */
public interface FixedSpawnableObject extends SpawnableObject{

}
