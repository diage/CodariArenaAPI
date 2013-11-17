package com.codari.arena5.players.role;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.scheduler.BukkitRunnable;

import com.codari.api5.Codari;
import com.codari.arena5.players.combatants.Combatant;
import com.codari.arena5.players.skills.Skill;
import com.codari.arena5.players.skills.SkillActivation;

public class CombatantRole implements Role {
	//-----Fields-----//
	private int maxCooldown = 20; 	//(in seconds)
	private int cooldown = maxCooldown;
	private boolean onCooldown = false;
	private String name;

	private Map<SkillActivation, Skill> skills;
	
	public CombatantRole(String name) {
		this.name = name;
	}

	public CombatantRole(String name, Skill...skills) {
		this.name = name;
		this.skills = new HashMap<>();
		for(Skill skill : skills) {
			this.skills.put(skill.getSkillActivation(), skill);
		}
	}

	public CombatantRole(String name, int maxCooldown, Skill...skills) {
		this.name = name;
		this.maxCooldown = maxCooldown;
		this.skills = new HashMap<>();
		for(Skill skill : skills) {
			this.skills.put(skill.getSkillActivation(), skill);
		}
	}

	@Override
	public final Skill[] getSkills() {
		return (Skill[]) this.skills.values().toArray();
	}

	/* Checks if the skill is on cooldown first. If the skill's not on cooldown, checks for the Key with contains double jump,
	 * activates the skill, then puts the skill on cooldown. */
	@Override
	public final void doubleJump(Combatant combatant) {
		if(this.checkCooldown()){
			if(this.skills.containsKey(SkillActivation.DOUBLE_JUMP)) {
				this.skills.get(SkillActivation.DOUBLE_JUMP).activateSkill(combatant); 
				this.onCooldown();
			}	
		}
	}

	@Override
	public final void block(Combatant combatant) {
		if(this.checkCooldown()){
			if(this.skills.containsKey(SkillActivation.BLOCK)) {
				this.skills.get(SkillActivation.BLOCK).activateSkill(combatant); 
				this.onCooldown();
			}
		}
	}

	@Override
	public final void sprint(Combatant combatant) {
		if(this.checkCooldown()){
			if(this.skills.containsKey(SkillActivation.SPRINT)) {
				this.skills.get(SkillActivation.SPRINT).activateSkill(combatant); 
				this.onCooldown();
			}	
		}
	}

	@Override
	public final void sneak(Combatant combatant) {
		if(this.checkCooldown()){
			if(this.skills.containsKey(SkillActivation.SNEAK)) {
				this.skills.get(SkillActivation.SNEAK).activateSkill(combatant); 
				this.onCooldown();
			}
		}
	}

	@Override
	public final String getName() {
		return this.name;
	}

	private boolean checkCooldown() {
		return this.onCooldown;
	}

	private void onCooldown() {
		this.onCooldown = true;
		BukkitRunnable runner = new BukkitRunnable() {
			@Override
			public void run() {
				cooldown--;
				if(cooldown == 0) {
					cooldown = maxCooldown;
					onCooldown = false;
					super.cancel();
				}
			}
		};

		runner.runTaskTimer(Codari.INSTANCE, 0, 20);		
	}
}
