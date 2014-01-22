package com.codari.api5.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("Stupid_Class")
public class Time implements ConfigurationSerializable {
	//-----Constants-----//
	public final static Time NULL = new Time(0, 0, 0);
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
		//FIXME - leave be or include a prefix?
		return this.tick.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.tick.equals(obj);
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("tick", this.tick);
		return result;
	}
	
	public Time(Map<String, Object> args) {
		this.tick = (Tick) args.get("tick");
	}
}
