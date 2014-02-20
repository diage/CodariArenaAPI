package com.codari.arena5.players.role;

import java.util.Collection;

import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.skills.Skill;

/**
 * A role identifies core characteristics about how the player will interact within the game. 
 * 	These roles can be used to define skills and spells players have the ability to use or interact with.
 * @author Ryan
 *
 */
public interface Role {
	
	/**
	 * Retrieves the skill for this role. 
	 * @return The {@link Skill} associated for the role in question. 
	 */
	public Collection<Skill> getSkills();
	public boolean doubleJump(Combatant combatant);
	public boolean skill(Combatant combatant);
	
	public String getName();
	public Role addSkill(Skill skill);
	public Role swapRole(Role role); //XXX This might need reworked.. perhaps pass in combatant?
	public String getLink(String arenaObjectName);
}
