package com.codari.arena5.players.guilds;


public interface GuildManager {

	public boolean putGuild(String guildName, Guild guild);
	
	public void removeGuild(String guildName);
	
	public Guild getGuild(String guildName);
	
	public boolean containsGuild(String guildName);
	
}
