package com.codari.arena5.players.teams;


public interface TeamManager {

	public boolean putTeam(String teamName, Team team);
	
	public void removeTeam(String teamName);
	
	public Team getTeam(String teamName);
	
	public boolean containsTeam(String teamName);
	
}
