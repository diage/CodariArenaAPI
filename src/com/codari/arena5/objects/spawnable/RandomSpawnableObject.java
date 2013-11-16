package com.codari.arena5.objects.spawnable;
/**
 * RandomSpawnableObjects are grouped together and registered under a single group name. 
 * 
 * These objects will be selected from a pool to be spawned given the spawning characteristics 
 * 	identified by the groupName.
 * 
 * Random spawnables have a weight which will determine the chance they spawn from the group they are in. 
 * 	The smaller the weight the more rare. Note the effect of the weight is relative to the total weight in the groupName. 
 * @author Ryan
 *
 */
public interface RandomSpawnableObject extends SpawnableObject {
	
	/**
	 * Get the weight of this Random Spawnable Object
	 * @return The weight of this RandomSpawnableObject, the higher the weight the less rare it is. 
	 */
	public int getWeight();
}
