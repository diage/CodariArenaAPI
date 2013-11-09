package com.codari.arena;

import com.codari.api.util.Tick;
import com.codari.arena.objects.DelayedPersistentObject;
import com.codari.arena.objects.FixedSpawnableObject;
import com.codari.arena.objects.ImmediatePersistentObject;
import com.codari.arena.objects.RandomSpawnableObject;
import com.codari.arena.rules.GameRule;

/**
 * Current representation of the primary Arena. 
 * 
 * The arena is the manager used for all registration of Objects and Game Rules.
 * The arena also has the task of keeping track of the time line running in the background for 
 * 	the game.  
 * @author Ryan
 *
 */
public interface Arena {
	public String getName();
	
	//-----Registrations-----//
	
		//*****Group Registration*****//
	/**
	 * Create a group for the time line to randomly select a {@Link SpawnableObject}. 
	 * 		This will only spawn once.  
	 * 		You can think of the group as a set where it will grab from the set exactly one 
	 * 			{@Link SpawnableObject} at each request to spawn from that group. 
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 * 
	 * @param groupName The name to be given to the group of {@Link SpawnableObject}s 
	 * 		which the time line will choose from.
	 * @param time The time at which the object will be spawned.
	 * @return True if the group was successfully made. 
	 * 	False if the name was already taken or the initial time is after the end of the game.  
	 */
	public boolean createRandomTimelineGroup(String groupName, Tick time);
	/**
	 * Create a group for the time line to randomly select a {@Link SpawnableObject}. 
	 * 		This will spawn at the provided time and 
	 * 			then repeat after the indicated repeatTime until the game ends.  
	 *  	You can think of the group as a set where it will grab from the set exactly one 
	 * 			{@Link SpawnableObject} at each request to spawn from that group.
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 *  
	 * @param groupName The name to be given to the group of {@Link SpawnableObject}s 
	 * 		which the time line will choose from.
	 * @param time The time at which the object will be initially spawned.
	 * @param repeatTime The amount of time between each consecutive spawn.
	 * @return True if the group was successfully made. 
	 * 	False if the name was already taken or the initial time is after the end of the game.   
	 */
	public boolean createRandomTimelineGroup(String groupName, Tick time, Tick repeatTime);
	
		//*****Random Spawnable Registration*****//
	/**
	 * Register a {@Link RandomSpawnableObject} under a group name.
	 * 	Refer to createRandomTimelineGroup for more information on group name. 
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 * 
	 * @param object The object to be registered.
	 * @param groupName The group to register the object to.
	 * @return True if it was successful in adding. 
	 * 	False if the name does not exist or it was otherwise unsuccessful.  
	 */
	public boolean registerRandomSpawnable(RandomSpawnableObject object, String groupName);
	
		//*****Fixed Spawnable Registration*****//
	/**
	 * Register a {@Link FixedSpawnableObject} at the given time. 
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 * 
	 * @param object The object to be spawned.
	 * @param time The time at which to spawn the object.
	 * @return True if it was successful in adding.
	 * 	False if the time will be after the end of the match or otherwise unsuccessful. 
	 */
	public boolean registerFixedSpawnable(FixedSpawnableObject object, Tick time);
	/**
	 * Register a {@Link FixedSpawnableObject} at the given time which will repeat until the game ends.
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 * 
	 * @param object The object to be spawned.
	 * @param time The time at which to spawn the object.
	 * @param repeatTime The amount of time between each consecutive spawn.
	 * @return True if it was successful in adding. 
	 * 	False if the time will be after the end of the match or otherwise unsuccessful.  
	 */
	public boolean registerFixedSpawnable(FixedSpawnableObject object, Tick time, Tick repeatTime);
	
		//*****Persistent Object Registration*****//
	/**
	 * Register a {@Link PersistentObject} which will exist the entire duration of the game 
	 * 	and interaction set to immediate.
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 * 
	 * @param object The object which to register.
	 * @return True if successful, False otherwise.  
	 */
	public boolean registerPersistent(ImmediatePersistentObject object);
	/**
	 * Register a {@Link PersistentObject} which will exist 
	 * 	the entire duration of the game with the interaction rule delayed by the provided time.
	 * 
	 * 	All {@Link ArenaObject} registration must be after the {@Link GameRule} registration. 
	 *  
	 * @param object The object which to register.
	 * @param time The delay until the interaction is acted on.
	 * @param override If true, this object will remove a previous interaction. 
	 * 	If false, all interactions will still be acted upon.
	 * @return True if successful, False otherwise.   
	 */
	public boolean registerPersistent(DelayedPersistentObject object, Tick time, boolean override);
	
		//*****Game Rule Registration*****//
	/**
	 * Register a {@Link GameRule} into the Arena. 
	 * 
	 * @param gameRule The game rule to be registered. 
	 */
	public void registerGameRule(GameRule gameRule);
}
