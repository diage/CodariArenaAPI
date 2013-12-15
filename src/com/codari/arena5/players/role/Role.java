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
	public boolean block(Combatant combatant);
	public boolean sprint(Combatant combatant);
	public boolean sneak(Combatant combatant);
	
	public String getName();
	public Role addSkill(Skill skill);
	public Role swapRole(Role role);
}
