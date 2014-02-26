package com.codari.arena5;

import com.codari.arena5.arena.rules.timedaction.TimedAction;
import com.codari.arena5.arena.rules.wincondition.WinCondition;
import com.codari.arena5.item.assets.ItemAsset;
import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.players.skills.Skill;
/**
 * Class to register all CodariArena objects. 
 * 	This class represents the primary form of communication between your plugin and CodariArena. 
 * 	Registration happens by manually invoking the methods below and adding an annotation above 
 * @author ryan
 *
 */
public interface Library {
	/**
	 * <p>Method used to register a win condition for use within the arena. 
	 * <p>This method is <b>required</b> in order for the plugin to see your win condition. 
	 * <p><i>Note that it is also required to a add an annotation above your class.</i> 
	 * @param clazz The {@code winCondition.class} to be registered. 
	 */
	public void registerWinCondition(Class<? extends WinCondition> clazz);

	/**
	 * Method used to register a timed action for use within the arena. This method is required
	 * in order for the plugin to see your timed action. 
	 * Note that it is also required to a add an annotation above your class.  
	 * @param clazz
	 */
	public void registerTimedAction(Class<? extends TimedAction> clazz);
	
	public void registerArenaObject(Class<? extends ArenaObject> clazz);

	public void registerSkill(Class<? extends Skill> clazz);
	
	public void registerItemAsset(Class<? extends ItemAsset> clazz);
}
