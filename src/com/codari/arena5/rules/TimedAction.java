package com.codari.arena5.rules;

import com.codari.api5.util.Tick;

/**
 * A Timed action describes something happen within the game at a given point in time.
 * 	This object will perform some action at a given time with the option to wait for 
 * 	a delay and to repeat. This Time action must have it's start + delay to be within the 
 * 	time line in order to be properly added to the time line. 
 * @author Ryan
 *
 */
public abstract class TimedAction implements Runnable {
	//-----Fields-----//
	private Tick start, delay, period;
	
	//-----Constructors-----//
	/**
	 * Basic constructor, provides only for a start time from the time line.
	 * @param start The time at which to do this action. 
	 */
	public TimedAction(Tick start) {
		this.start = start;
	}
	
	/**
	 * Constructor which provides for an optional delay. 
	 * @param start The time at which to begin the delay from.
	 * @param delay The amount of time until the action is done. 
	 */
	public TimedAction(Tick start, Tick delay) {
		this(start);
		this.delay = delay;
	}
	
	/**
	 * Constructor which provides for an optional delay and for repetition.
	 * 	Delay can be set to 0 if you want it to start immediately and repeat or set to the same
	 * 	as period if you don't want it to start at the first call. 
	 * @param start The time at which to begin the action or the delay. 
	 * @param delay The amount of time until the first action is done. 
	 * @param period The amount of time between each call after the delay. 
	 */
	public TimedAction(Tick start, Tick delay, Tick period) {
		this(start, delay);
		this.period = period;
	}
	
	//-----Abstract Methods-----//
	/**
	 * This method will be called at the start if delay is 0, else at the delay 
	 * 	and each subsequent period.
	 */
	public abstract void action();
	
	@Override
	public final void run() {
		this.action();
	}
	
	//-----Getters-----//
	/**
	 * Gets the delay provided by this timed action.
	 * @return The delay.
	 */
	public final Tick getDelay() {
		return this.delay;
	}
	
	/**
	 * Gets the start time of this timed action. 
	 * @return The start time. 
	 */
	public final Tick getStart() {
		return this.start;
	}
	
	/**
	 * Gets the period of this timed action. 
	 * @return The period.
	 */
	public final Tick getPeriod() {
		return this.period;
	}
}
