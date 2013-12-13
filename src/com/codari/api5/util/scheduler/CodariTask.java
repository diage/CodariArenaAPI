package com.codari.api5.util.scheduler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public final class CodariTask {
	//-----Fields-----//
	private final Plugin plugin;
	private BukkitTask task;
	
	//-----Constructor-----//
	public CodariTask(Plugin plugin) {
		if (plugin == null) {
			throw new NullPointerException();
		}
		this.plugin = plugin;
	}
	
	//-----Public Methods-----//
	public synchronized Plugin getOwner() {
		return this.plugin;
	}
	
	public synchronized BukkitTask getHandle() {
		return this.task;
	}
	
	public synchronized int getTaskId() {
		return this.isRunning() ? this.task.getTaskId() : -1;
	}
	
	public synchronized void cancel() {
		if (this.isRunning()) {
			this.task.cancel();
			this.task = null;
		}
	}
	
	public synchronized boolean isRunning() {
		return this.task != null;
	}
	
	public synchronized BukkitTask runTask(Runnable runnable,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTask(this.plugin,
				new TaskHandlerRunnable(runnable));
		return this.task;
	}
	
	public synchronized BukkitTask runTaskAsynchronously(Runnable runnable,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
				new TaskHandlerRunnable(runnable));
		return this.task;
	}
	
	public synchronized BukkitTask runTaskLater(Runnable runnable, long delay,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTaskLater(this.plugin,
				new TaskHandlerRunnable(runnable), delay);
		return this.task;
	}
	
	public synchronized BukkitTask runTaskLaterAsynchronously(Runnable runnable, long delay,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTaskLaterAsynchronously(this.plugin,
				new TaskHandlerRunnable(runnable), delay);
		return this.task;
	}
	
	public synchronized BukkitTask runTaskTimer(Runnable runnable, long delay,long period,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTaskTimer(this.plugin,
				runnable, delay, period);
		return this.task;
	}
	
	public synchronized BukkitTask runTaskTimerAsynchronously(Runnable runnable, long delay, long period,
			boolean override) throws IllegalStateException {
		this.checkState(override);
		this.task = Bukkit.getScheduler().runTaskTimerAsynchronously(this.plugin,
				runnable, delay, period);
		return this.task;
	}
	
	//-----Private Methods-----//
	private void checkState(boolean override) {
		if (this.isRunning()) {
			if (override) {
				this.cancel();
			} else {
				throw new IllegalStateException("Already running as task id: " + this.getTaskId());
			}
		}
	}
	
	//-----Task Handler Runnable-----//
	private final class TaskHandlerRunnable implements Runnable {
		//-----Fields-----//
		private final Runnable runnable;
		
		//-----Constructor-----//
		private TaskHandlerRunnable(Runnable runnable) {
			this.runnable = runnable;
		}
		
		//-----Run Method-----//
		@Override
		public void run() {
			this.runnable.run();
			task = null;
		}
	}
}
