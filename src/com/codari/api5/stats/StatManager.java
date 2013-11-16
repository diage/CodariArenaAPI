package com.codari.api5.stats;

import java.util.List;

public interface StatManager extends Iterable<Stat> {
	public StatHolder getHolder();
	public Stat getStat(String name);
	public List<Stat> getStats();
}