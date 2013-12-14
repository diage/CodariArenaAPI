package com.codari.arena5.objects;

import java.io.Serializable;

/**
 * Any object that exists within an {@Link Arena}.
 * 
 * 	Objects are the foundation of what makes an {@Link Arena} unique. The combined interaction
 * 		between the {@Link Combatant}s and the ArenaObjects will be the key to developing a unique
 * 		gameplay for the entire mini game. 
 * 	
 * 	All ArenaObjects must be registered into the {@Link Arena} in order for the Arena to recognize
 * 		their existence. The registration must be preceded by registration of a single {@Link GameRule}.
 * 
 *	Refer to {@Link GameRule} for more information regarding that. 
 *
 * @author Ryan
 *
 */
public interface ArenaObject extends Serializable {
	/**
	 * Method to allow the object to be seen but not interacted with. 
	 * 	This is useful for when the arena is being made and you are interested in where 
	 * 	objects have already been placed.
	 * 
	 * Often times this method can be used as a helper to spawning certain objects and should
	 * 	not differ from that except that in general reveal should reveal a deactivated version of
	 * 	the object. 
	 * 
	 * Deactivated means:
	 * 	The object may or may not be visible but should not react to any sort of interaction. 
	 */
	public void reveal();
	
	/**
	 * Method to hide objects within an {@Link Arena}.
	 * 	this is a method to set an object into an inactive state. 
	 * 
	 * Inactive means:
	 * The object should not be capable of being interacted with 
	 * 	as well as being physically not present (invisible). 
	 */
	public void hide();
}
