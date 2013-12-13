package com.codari.api5.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public abstract class CodariRunnable implements Runnable {
	//-----Fields-----//
	private final CodariTask task;
	
	//-----Constructor-----//
	public CodariRunnable(Plugin plugin) {
		this.task = new CodariTask(plugin);
	}
	
	//-----Public Methods-----//
	public final synchronized Plugin getOwner() {
		return this.task.getOwner();
	}
	
	public final synchronized BukkitTask getTask() {
		return this.task.getHandle();
	}
	
	public final synchronized int getTaskId() {
		return this.task.getTaskId();
	}
	
	public final synchronized void cancel() {
		this.task.cancel();
	}
	
	public final synchronized boolean isRunning() {
		return this.task.isRunning();
	}
	
	public final synchronized BukkitTask runTask(
			boolean override) throws IllegalStateException {
		return this.task.runTask(this, override);
	}
	
	public final synchronized BukkitTask runTaskAsynchronously(
			boolean override) throws IllegalStateException {
		return this.task.runTaskAsynchronously(this, override);
	}
	
	public final synchronized BukkitTask runTaskLater(long delay,
			boolean override) throws IllegalStateException {
		return this.task.runTaskLater(this, delay, override);
	}
	
	public final synchronized BukkitTask runTaskLaterAsynchronously(long delay,
			boolean override) throws IllegalStateException {
		return this.task.runTaskLaterAsynchronously(this, delay, override);
	}
	
	public final synchronized BukkitTask runTaskTimer(long delay,long period,
			boolean override) throws IllegalStateException {
		return this.task.runTaskTimer(this, delay, period, override);
	}
	
	public final synchronized BukkitTask runTaskTimerAsynchronously(long delay, long period,
			boolean override) throws IllegalStateException {
		return this.task.runTaskTimerAsynchronously(this, delay, period, override);
	}
}
