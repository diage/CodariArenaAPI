package com.codari.api5.util;

public final class Tick extends Number implements Comparable<Tick> {
	private static final long serialVersionUID = 4253814235314171195L;
	//-----Constants-----//
	public final static long TICK = 1;
	public final static long SECOND = 20;
	public final static long MINUTE = SECOND * 60;
	public final static long HOUR = MINUTE * 60;
	public final static long DAY = HOUR * 24;
	public final static long WEEK = DAY * 7;
	
	//-----Fields-----//
	private final long ticks;
	
	//-----Constructor-----//
	public Tick(long ticks) {
		this.ticks = ticks;
	}
	
	public Tick(String string) throws NumberFormatException {
		this.ticks = Long.parseLong(string);
	}
	
	//-----Public Methods-----//
	@Override
	public double doubleValue() {
		return this.ticks;
	}

	@Override
	public float floatValue() {
		return this.ticks;
	}

	@Override
	public int intValue() {
		return (int) this.ticks;
	}

	@Override
	public long longValue() {
		return this.ticks;
	}
	
	public long ticks() {
		return this.longValue();
	}
	
	public double seconds() {
		return this.doubleValue() / SECOND;
	}
	
	public double minutes() {
		return this.doubleValue() / MINUTE;
	}
	
	public double hours() {
		return this.doubleValue() / HOUR;
	}
	
	public double days() {
		return this.doubleValue() / DAY;
	}
	
	public double weeks() {
		return this.doubleValue() / WEEK;
	}
	
	//-----Utility Methods-----//
	@Override
	public int compareTo(Tick other) {
		return Long.compare(this.ticks, other.ticks);
	}
	
	@Override
	public String toString() {
		//FIXME - leave be or include a prefix?
		return Long.toString(this.ticks);
	}

	@Override
	public int hashCode() {
		return 5 * ((int) (this.ticks ^ (this.ticks >>> 32)));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tick) {
			return this.ticks == ((Tick) obj).ticks;
		}
		return false;
	}
}