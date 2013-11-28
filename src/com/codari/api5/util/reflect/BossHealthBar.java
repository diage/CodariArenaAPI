package com.codari.api5.util.reflect;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.codari.api5.CodariI;

@SuppressWarnings("deprecation")
public final class BossHealthBar {
	//-----Constants-----//
	private final static int ENTITY_ID = 255000000;
	private final static int WITHER_ID = EntityType.WITHER.getTypeId();
	
	//-----Static Methods-----//
	private static void sendPacket(Player player, Reflector packet) {
		try {
			new Reflector(player).invokeCommand("getHandle().playerConnection.sendPacket(1)", packet.fetch());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}
	
	private static Reflector getMobPacket(String text, Location location)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Reflector mobPacket = Reflector.invokeConstructor(Reflector.classFromNMS("Packet24MobSpawn"));
		
		mobPacket
		.set("a", ENTITY_ID)
		.set("b", WITHER_ID)
		.set("c", (int) Math.floor(location.getBlockX() * 32.0D))
		.set("d", (int) Math.floor(location.getBlockY() * 32.0D))
		.set("e", (int) Math.floor(location.getBlockZ() * 32.0D))
		.set("f", 0)
		.set("g", 0)
		.set("h", 0)
		.set("i", (byte) 0)
		.set("j", (byte) 0)
		.set("k", (byte) 0);
		
		Reflector watcher = getDataWatcher(text, 300);
		mobPacket.set("t", watcher.fetch());
		
		return mobPacket;
	}
	
	private static Reflector getDestroyEntityPacket()
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException,InvocationTargetException, ClassNotFoundException {
		Reflector packet = Reflector.invokeConstructor(Reflector.classFromNMS("Packet29DestroyEntity"));
		return packet.set("a", new int[]{ENTITY_ID});
	}
	
	private static Reflector getMetadataPacket(Reflector watcher)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException,InvocationTargetException, ClassNotFoundException {
		Reflector metaPacket = Reflector.invokeConstructor(Reflector.classFromNMS("Packet40EntityMetadata"));
		
		metaPacket
		.set("a", (int) ENTITY_ID)
		.set("b", watcher.invoke("c").fetch());
		
		return metaPacket;
	}
	
	private static Reflector getDataWatcher(String text, int health)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException,InvocationTargetException, ClassNotFoundException {
		Reflector watcher = Reflector.invokeConstructor(Reflector.classFromNMS("DataWatcher"));
		
		watcher.invoke("a", 0, (Byte) (byte) 0x20);
		watcher.invoke("a", 6, (Float) (float) health);
		watcher.invoke("a", 10, (String) text);
		watcher.invoke("a", 11, (Byte) (byte) 1);
		
		return watcher;
	}
	
	@Deprecated
	public static void displayTextBar(String text, final Player player, long duration) {
		try {
			Reflector mobPacket = getMobPacket(text, player.getLocation());
			sendPacket(player, mobPacket);
			final Reflector destroyEntityPacket = getDestroyEntityPacket();
			new BukkitRunnable(){
				@Override
				public void run(){
					sendPacket(player, destroyEntityPacket);
				}
			}.runTaskLater(CodariI.INSTANCE, duration);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	@Deprecated
	public static void displayLoadingBar(final String text, final String completeText, final Player player,
			final int healthAdd, final long delay, final boolean loadUp) {
		try {
			Reflector mobPacket = getMobPacket(text, player.getLocation());
			sendPacket(player, mobPacket);
			new BukkitRunnable(){
				int health = (loadUp ? 0 : 300);
				
				@Override
				public void run(){
					try {
						if((loadUp ? health < 300 : health > 0)){
							Reflector watcher = getDataWatcher(text, health);
							Reflector metaPacket = getMetadataPacket(watcher);
							
							sendPacket(player, metaPacket);
							
							if(loadUp){
								health += healthAdd;
							} else {
								health -= healthAdd;
							}
						} else {
							Reflector watcher = getDataWatcher(text, (loadUp ? 300 : 0));
							Reflector metaPacket = getMetadataPacket(watcher);
							Reflector destroyEntityPacket = getDestroyEntityPacket();
							
							sendPacket(player, metaPacket);					
							sendPacket(player, destroyEntityPacket);
							
							//Complete text
							Reflector mobPacket = getMobPacket(completeText, player.getLocation());
							sendPacket(player, mobPacket);
							
							Reflector watcher2 = getDataWatcher(completeText, 300);
							Reflector metaPacket2 = getMetadataPacket(watcher2);
							
							sendPacket(player, metaPacket2);
							
							new BukkitRunnable(){
								@Override
								public void run(){
									try {
									Reflector destroyEntityPacket = getDestroyEntityPacket();
									sendPacket(player, destroyEntityPacket);
									} catch (InstantiationException | IllegalAccessException |
											IllegalArgumentException | InvocationTargetException |
											ClassNotFoundException ex) {
										ex.printStackTrace();
									}
								}
							}.runTaskLater(CodariI.INSTANCE, 40L);
							
							this.cancel();
						}
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
							InvocationTargetException | ClassNotFoundException ex) {
						ex.printStackTrace();
					}
				}
			}.runTaskTimer(CodariI.INSTANCE, delay, delay);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	@Deprecated
	public static void displayLoadingBar(final String text, final String completeText, final Player player,
			final int secondsDelay, final boolean loadUp){
		int healthChangePerSecond = 300 / secondsDelay;
		displayLoadingBar(text, completeText, player, healthChangePerSecond, 20L, loadUp);
	}
}