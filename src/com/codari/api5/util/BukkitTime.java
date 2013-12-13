package com.codari.api5.util;

public enum BukkitTime {
	//-----Enumerations-----//
	TICK(1),
	SECOND(TICK.tickUnit() * 20),
	MINUTE(SECOND.tickUnit() * 60),
	HOUR(MINUTE.tickUnit() * 60),
	DAY(HOUR.tickUnit() * 24),
	WEEK(DAY.tickUnit() * 7);
	
	//-----Fields-----//
	private final long tickUnit;
	
	//-----Constructor-----//
	private BukkitTime(long tickUnit) {
		this.tickUnit = tickUnit;
	}
	
	//-----Public Methods-----//
	public long tickUnit() {
		return this.tickUnit;
	}
	
	public long tickValue(double value) {
		return Math.round(this.toTicks(value));
	}
	
	public double fromTicks(long ticks) {
		return (double) ticks / this.tickUnit();
	}
	
	public double convert(double value, BukkitTime unit) {
		return this.fromTicks(unit.tickValue(value));
	}
	
	public double toTicks(double value) {
		return value * this.tickUnit();
	}
	
	public double toSeconds(double value) {
		return BukkitTime.SECOND.convert(value, this);
	}
	
	public double toMinutes(double value) {
		return BukkitTime.MINUTE.convert(value, this);
	}
	
	public double toHours(double value) {
		return BukkitTime.HOUR.convert(value, this);
	}
	
	public double toDays(double value) {
		return BukkitTime.DAY.convert(value, this);
	}
	
	public double toWeeks(double value) {
		return BukkitTime.WEEK.convert(value, this);
	}
}
