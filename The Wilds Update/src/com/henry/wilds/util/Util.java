package com.henry.wilds.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class holding all of the helpful functions
 * for the program, such as loading images and
 * sleeping threads.
 * @author Samuel Henry
 * @version 2.0
 * @since November 23, 2014
 */
public class Util {
	
	/**
	 * Loads an image from the classpath resources folder.
	 * @param path The path as a string
	 * @return A BufferedImage loaded from the path
	 */
	public static BufferedImage getImage(String path) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(Util.class.getResource("/images/" + path));
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Console.writeLine("Util.getImage(\"res/" + path + "\");");
		
		return img;
	}
	
	/**
	 * Sleeps the current thread for the given
	 * amount of time in milliseconds
	 * @param millis The number of milliseconds to sleep
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}