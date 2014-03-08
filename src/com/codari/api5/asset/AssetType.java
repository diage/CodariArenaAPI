package com.codari.api5.asset;

import com.codari.arena5.assets.DelayedPersistentAsset;
import com.codari.arena5.assets.FixedSpawnableAsset;
import com.codari.arena5.assets.ImmediatePersistentAsset;
import com.codari.arena5.assets.RandomSpawnableAsset;
import com.codari.arena5.assets.SkillAsset;
import com.codari.arena5.assets.TimedActionAsset;
import com.codari.arena5.assets.WinConditionAsset;


public enum AssetType {
	//-----Enumerations-----//
	DELAYED_PERSISTENT_ASSET(DelayedPersistentAsset.class),
	FIXED_SPAWNABLE_ASSET(FixedSpawnableAsset.class),
	IMMEDIATE_PERSISTENT_ASSET(ImmediatePersistentAsset.class),
	RANDOM_SPAWNABLE_ASSET(RandomSpawnableAsset.class),
	WIN_CONDITION(WinConditionAsset.class),
	TIMED_ACTION(TimedActionAsset.class),
	SKILL_ASSET(SkillAsset.class);
		
	//-----Static Methods-----//
	public static AssetType getType(Class<? extends Asset> clazz) {
		if (clazz == null) {
			return null;
		}
		for (AssetType value : values()) {
			if (value.getBaseClass().isAssignableFrom(clazz)) {
				return value;
			}
		}
		return null;
	}
	
	//-----Fields-----//
	private final Class<? extends Asset> baseClass;
	
	//-----Constructor-----//
	private AssetType(Class<? extends Asset> baseClass) {
		this.baseClass = baseClass;
	}
	
	//-----Methods-----// 
	public Class<? extends Asset> getBaseClass() {
		return this.baseClass;
	}
	
	//-----Utility Methods-----//2
	@Override
	public String toString() {
		return super.name().toLowerCase();
	}
}
