package com.codari.api5.stats;

public interface StatFactory {
	public boolean isValidStatName(String name);
	public void registerStatType(Class<? extends StatHolder> holder, StatType type) throws StatRegistrationException;
	public StatManager createStatManager(StatHolder holder);
}