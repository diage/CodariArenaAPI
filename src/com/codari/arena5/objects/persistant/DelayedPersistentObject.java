package com.codari.arena5.objects.persistant;
/**
 * A specialized type of {@Link ArenaObject}.
 *  This could be interacted with at any given time that the {@Link Arena} is active.
 *  Upon interaction, you should expect a delay before the method actually being called by the {@Link Arena}. 
 * @author Ryan
 *
 */
public interface DelayedPersistentObject extends PersistentObject {

}
