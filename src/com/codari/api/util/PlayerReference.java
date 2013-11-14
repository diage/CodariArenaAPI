package com.codari.api.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import com.codari.api.Codari;

@SerializableAs("Player_Reference")
public final class PlayerReference implements Metadatable, OfflinePlayer, Comparable<PlayerReference> {
	//-----Static Fields-----//
	private final static Map<String, PlayerReference> players = new HashMap<>();
	
	//-----Static Constructor-----//
	public static void _(){}
	static {
		Bukkit.getPluginManager().registerEvents(new PlayerReferenceUpdater(), Codari.INSTANCE);
		ConfigurationSerialization.registerClass(PlayerReference.class, "Player_Reference");
	}
	
	//-----Static Methods-----//
	public static PlayerReference instanceOf(String name) {
		PlayerReference instance = players.get(name.toLowerCase());
		if (instance == null) {
			instance = new PlayerReference(name);
			players.put(name.toLowerCase(), instance);
		}
		return instance;
	}
	
	public static PlayerReference instanceOf(OfflinePlayer player) {
		return instanceOf(player.getName());
	}
	
	public static void kickAllPlayers() {
		for (PlayerReference r : players.values()) {
			if (r.isOnline()) {
				r.getPlayer().kickPlayer("Server Stoppingsafhklhklsfhafhalkfas");
			}
		}
	}
	
	//-----Fields-----//
	private OfflinePlayer player;
	
	//-----Constructor-----//
	private PlayerReference(String name) {
		this.player = Bukkit.getOfflinePlayer(name);
	}
	
	//-----Public Methods-----//
	@Override
	public boolean isOp() {
		return this.getInstance().isOp();
	}
	
	@Override
	public void setOp(boolean value) {
		this.getInstance().setOp(value);
	}
	
	@Override
	public Location getBedSpawnLocation() {
		return this.getInstance().getBedSpawnLocation();
	}
	
	@Override
	public long getFirstPlayed() {
		return this.getInstance().getFirstPlayed();
	}
	
	@Override
	public long getLastPlayed() {
		return this.getInstance().getLastPlayed();
	}
	
	@Override
	public String getName() {
		return this.getInstance().getName();
	}
	
	@Override
	public Player getPlayer() {
		if (this.isOnline()) {
			return (Player) this.getInstance();
		}
		return null;
	}
	
	@Override
	public boolean hasPlayedBefore() {
		return this.getInstance().hasPlayedBefore();
	}
	
	@Override
	public boolean isBanned() {
		return this.getInstance().isBanned();
	}
	
	@Override
	public boolean isOnline() {
		return this.getInstance() instanceof Player;
	}
	
	@Override
	public boolean isWhitelisted() {
		return this.getInstance().isWhitelisted();
	}
	
	@Override
	public void setBanned(boolean banned) {
		this.getInstance().setBanned(banned);
	}
	
	@Override
	public void setWhitelisted(boolean value) {
		this.getInstance().setWhitelisted(value);
	}
	
	public OfflinePlayer getInstance() {
		return this.player;
	}
	
	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return Codari.INSTANCE.getMetadataManager().getPlayerMetadataStore().getMetadata(this, metadataKey);
	}
	
	@Override
	public boolean hasMetadata(String metadataKey) {
		return Codari.INSTANCE.getMetadataManager().getPlayerMetadataStore().hasMetadata(this, metadataKey);
	}
	
	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		Codari.INSTANCE.getMetadataManager().getPlayerMetadataStore().removeMetadata(this, metadataKey, owningPlugin);
	}
	
	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		Codari.INSTANCE.getMetadataManager().getPlayerMetadataStore().setMetadata(this, metadataKey, newMetadataValue);
	}
	
	//-----Private Methods-----//
	private void update() {
		this.player = Bukkit.getOfflinePlayer(this.getName());
	}
	
	//-----Utility Methods-----//
	@Override
	public int compareTo(PlayerReference other) {
		return this.getName().compareToIgnoreCase(other.getName());
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public int hashCode() {
		return 2551 * 5 + this.getName().toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PlayerReference) {
			return this.getName().equalsIgnoreCase(((PlayerReference) obj).getName());
		}
		return false;
	}
	
	//-----Serialization-----//
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("name", this.getName());
		return result;
	}
	
	public static PlayerReference deserialize(Map<String, Object> args) {
		return PlayerReference.instanceOf((String) args.get("name"));
	}
	
	//-----Player Reference Updater-----//
	private final static class PlayerReferenceUpdater implements Listener {
		//-----Events-----//
		@EventHandler(priority = EventPriority.LOWEST)
		public void playerJoin(PlayerJoinEvent e) {
			PlayerReference.instanceOf(e.getPlayer()).update();
		}
		
		@EventHandler(priority = EventPriority.LOWEST)
		public void playerQuit(final PlayerQuitEvent e) {
			Bukkit.getScheduler().runTask(Codari.INSTANCE, new Runnable() {
				@Override
				public void run() {
					PlayerReference.instanceOf(e.getPlayer()).update();
				}
			});
		}
	}
}