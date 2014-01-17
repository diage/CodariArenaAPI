package com.codari.arena5.players.guilds;

import java.util.List;

import com.codari.arena5.players.combatants.Combatant;

public interface Guild {

	public String getGuildName();
	public Combatant getGuildLeader();
	public void setCombatantGuildStanding(Combatant combatant, GuildRanking guildRanking);
	public GuildRanking getRankingOfMember(Combatant combatant);
	public void removeGuildMember(Combatant combatant);
	public List<Combatant> getGuildMembers();
	public List<Combatant> getGuildMembers(GuildRanking guildRanking);
	public int getGuildSize();

}
