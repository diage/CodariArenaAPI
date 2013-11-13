package com.codari.api.util;

public class Time {
	private Tick tick;
	
	public Time(long minutes) {
		this.tick = new Tick(minutes*Tick.MINUTE);
	}
	
	public Time(long minutes, long seconds) {
		this.tick = new Tick(minutes*Tick.MINUTE + seconds*Tick.SECOND);
	}
	
	public Time(long minutes, long seconds, long ticks) {
		this.tick = new Tick(minutes*Tick.MINUTE + seconds*Tick.SECOND + ticks);
	}
	
	public long ticks() {
		return this.tick.ticks();
	}
	
	public double seconds() {
		return this.tick.seconds();
	}
	
	public double minutes() {
		return this.tick.minutes();
	}
	
	public int compareTo(Tick other) {
		return this.tick.compareTo(other);
	}
	
	@Override
	public int hashCode() {
		return this.tick.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.tick.equals(obj);
	}
}
