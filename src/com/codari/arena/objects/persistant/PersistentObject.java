package com.codari.arena.objects.persistant;

import com.codari.arena.objects.ArenaObject;


/**
 * persistentObjects are {@link ArenaObject}s which can have dynamic states upon interacting or simply act based on some 
 * outside force interacting with it. 
 * 
 * @author Ryan
 *
 */
public interface PersistentObject extends ArenaObject {
	/**
	 * Method to be called when this Object is interacted with, whether physically or through another object. 
	 */
	public void interact();
}
