package com.henry.wilds.util;

/**
 * This class holds just a few helpful time functions,
 * mostly for keeping the fps at a constant rate
 * @author Samuel Henry
 * @since November 26, 2014
 * @version 2.0
 */
public class Time {
	public static final long SECOND = 1000000000L;

	/**
	 * Gets the current time
	 * @return The time in nanoseconds (long)
	 */
	public static long getTime() {
		return System.nanoTime();
	}

}