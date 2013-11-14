package com.codari.api.stats;

import java.util.List;

public interface StatManager {
	public StatHolder getHolder();
	public Stat getStat(String name);
	public List<Stat> getStats();
}