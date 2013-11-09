package com.codari.arena;

public class Time {
	private long minutes, ticks;
	private short TICK_CONVERSION = 20;
	
	public Time(long ticks) {
		this.minutes = ticks/this.TICK_CONVERSION;
		this.ticks = ticks % this.TICK_CONVERSION;
	}
	
	public Time(long minutes, long ticks) {
		this(ticks);
		this.minutes += minutes;
	}
	
	public long getMinute() {
		return this.minutes;
	}
	
	public long getTicks() {
		return this.ticks;
	}
	
	public long getTimeToTicks() {
		return this.ticks + (this.minutes * this.TICK_CONVERSION);
	}
}
