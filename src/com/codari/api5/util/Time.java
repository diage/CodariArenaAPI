package com.codari.api5.util;

public class Time {
	//-----Constants-----//
	public final static Time NULL = new Time(0, 0, -1);
	public final static Time MAX = new Time(0, 0, Long.MAX_VALUE);
	public final static Time ONE_TICK = new Time(0, 0, 1);
	
	//-----Fields----//
	private Tick tick;
	
	//-----Constructors-----//
	public Time(long minutes) {
		this.tick = new Tick(minutes*Tick.MINUTE);
	}
	
	public Time(long minutes, long seconds) {
		this.tick = new Tick(minutes*Tick.MINUTE + seconds*Tick.SECOND);
	}
	
	public Time(long minutes, long seconds, long ticks) {
		this.tick = new Tick(minutes*Tick.MINUTE + seconds*Tick.SECOND + ticks);
	}
	
	//-----Public Methods-----//
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
	
	//-----Overrode Methods-----//
	@Override
	public int hashCode() {
		return this.tick.hashCode();
	}
	
	@Override
	public String toString() {
		//TODO leave be or include a prefix?
		return this.tick.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.tick.equals(obj);
	}
}
