package com.codari.api5.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("I_Made_This_But_Also_Think_Is_Stupid")
public final class Tick implements Comparable<Tick>, ConfigurationSerializable {
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
	public long ticks() {
		return this.ticks;
	}
	
	public double seconds() {
		return this.ticks() / SECOND;
	}
	
	public double minutes() {
		return this.ticks() / MINUTE;
	}
	
	public double hours() {
		return this.ticks() / HOUR;
	}
	
	public double days() {
		return this.ticks() / DAY;
	}
	
	public double weeks() {
		return this.ticks() / WEEK;
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

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("ticks", this.ticks);
		return result;
	}
	
	public Tick(Map<String, Object> args) {
		this.ticks = (long) args.get("ticks");
	}
}