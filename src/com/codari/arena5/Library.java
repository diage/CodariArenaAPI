package com.codari.arena5;

import com.codari.arena5.arena.rules.timedaction.TimedAction;
import com.codari.arena5.arena.rules.wincondition.WinCondition;
import com.codari.arena5.item.assets.ItemAsset;
import com.codari.arena5.objects.ArenaObject;
import com.codari.arena5.players.skills.Skill;
/**
 * <p>Class to register all CodariArena objects. 
 * 	<p>This class represents the primary form of communication between your plugin and CodariArena. 
 * 	Registration happens by manually invoking the methods below and adding an annotation above.</p> 
 * @author Diage
 * @author Mhenlo
 * @author Soren025
 *
 */
public interface Library {
	/**
	 * <p>Method used to register a Win Condition for use within CodariArena. 
	 * <li><b>Required to show in CodariArena:</b> Call this method on your {@link com.codari.arena5.arena.rules.wincondition.WinCondition WinCondition.class}. 
	 * <li><b>Required to show in CodariArena:</b> Add a {@link com.codari.api5.annotations.WinConditionName WinConditionName} annotation above your class.</p> 
	 * @param clazz The {@code WinCondition.class} to be registered. 
	 */
	public void registerWinCondition(Class<? extends WinCondition> clazz);

	/**
	 * <p>Method used to register a Timed Action for use within CodariArena. 
	 * <li><b>Required to show in CodariArena:</b> Call this method on your {@link com.codari.arena5.arena.rules.timedaction.TimedAction TimedAction.class}. 
	 * <li><b>Required to show in CodariArena:</b> Add a {@link com.codari.api5.annotations.TimedActionName TimedActionName} annotation above your class.</p> 
	 * @param clazz The {@code TimedAction.class} to be registered. 
	 */
	public void registerTimedAction(Class<? extends TimedAction> clazz);
	
	/**
	 * <p>Method used to register an Arena Object for use within CodariArena. 
	 * <li><b>Required to show in CodariArena:</b> Call this method on your {@link com.codari.arena5.objects.ArenaObject ArenaObject.class}. 
	 * <li><b>Required to show in CodariArena:</b> Add a {@link com.codari.api5.annotations.ArenaObjectName ArenaObjectName} annotation above your class.</p> 
	 * @param clazz The {@code ArenaObject.class} to be registered. 
	 */
	public void registerArenaObject(Class<? extends ArenaObject> clazz);

	/**
	 * <p>Method used to register a skill for use within CodariArena. 
	 * <li><b>Required to show in CodariArena:</b> Call this method on your {@link com.codari.arena5.players.skills.Skill skill.class}. 
	 * <li><b>Required to show in CodariArena:</b> Add a {@link com.codari.api5.annotations.SkillName SkillName} annotation above your class.</p> 
	 * @param clazz The {@code Skill.class} to be registered. 
	 */
	public void registerSkill(Class<? extends Skill> clazz);
	
	/**
	 * <p>Method used to register a Item Asset for use within CodariArena. 
	 * <li><b>Required to show in CodariArena:</b> Call this method on your {@link com.codari.arena5.item.assets.ItemAsset ItemAsset.class}. 
	 * <li><b>Required to show in CodariArena:</b> Add a {@link com.codari.api5.annotations.ItemAssetInformation ItemAssetInformation} annotation above your class.</p> 
	 * @param clazz The {@code ItemAsset.class} to be registered. 
	 */
	public void registerItemAsset(Class<? extends ItemAsset> clazz);
}
