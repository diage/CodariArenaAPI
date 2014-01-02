package com.codari.api5.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("Serializable_Location")
public class SerializableLocation implements Serializable, ConfigurationSerializable {
	private static final long serialVersionUID = 2703591957855073815L;
	//-----Fields-----//
	private transient Location location;
	private final String worldName;
	private final double x, y, z;
	private final float yaw, pitch;
	
	//-----Constructors-----//
	public SerializableLocation(final Location location) {
		if (location == null) {
			throw new NullPointerException("Location can not be null");
		}
		this.location = location;
		this.worldName = location.getWorld().getName();
		this.x = location.getX();
		this.y = location.getY();
		this.z = location.getZ();
		this.yaw = location.getYaw();
		this.pitch = location.getPitch();
	}
	
	//-----Public Methods-----//
	public Location getLocation(World world) {
		if (world == null) {
			throw new IllegalArgumentException("World can not be null");
		}
		return new Location(world, this.x, this.y, this.z, this.yaw, this.pitch);
	}
	
	public Location getLocation() {
		if (this.location == null) {
			World world = Bukkit.getWorld(this.worldName);
			if (world == null) {
				throw new IllegalArgumentException("World named " + this.worldName + " is not loaded");
			}
			this.location = this.getLocation(world);
		}
		return this.location;
	}
	
	//-----Overridden Methods-----//
	@Override
	public String toString() {
		return "SerializableLocation [worldName=" + this.worldName + ", x=" + this.x + ", y=" +
				this.y + ", z=" + this.z + ", yaw=" + this.yaw + ", pitch=" + this.pitch + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.worldName == null) ? 0 : this.worldName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(this.yaw);
		result = prime * result + Float.floatToIntBits(this.pitch);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SerializableLocation)) {
			return false;
		}
		SerializableLocation other = (SerializableLocation) obj;
		if (this.worldName == null) {
			if (other.worldName != null) {
				return false;
			}
		} else if (!this.worldName.equals(other.worldName)) {
			return false;
		}
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		if (Float.floatToIntBits(this.yaw) != Float.floatToIntBits(other.yaw)) {
			return false;
		}
		if (Float.floatToIntBits(this.pitch) != Float.floatToIntBits(other.pitch)) {
			return false;
		}
		return true;
	}
	
	//-----Serialization Method-----//
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("World_Name", this.worldName);
		result.put("X", this.x);
		result.put("Y", this.y);
		result.put("Z", this.z);
		result.put("Yaw", this.yaw);
		result.put("Pitch", this.pitch);
		return result;
	}
	
	//-----Deserialization Constructor-----//
	public SerializableLocation(final Map<String, Object> args) {
		this.worldName = (String) args.get("World_Name");
		this.x = (double) args.get("X");
		this.y = (double) args.get("Y");
		this.z = (double) args.get("Z");
		this.yaw = (float) args.get("Yaw");
		this.pitch = (float) args.get("Pitch");
	}
}