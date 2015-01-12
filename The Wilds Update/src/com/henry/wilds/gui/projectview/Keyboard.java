package com.henry.wilds.gui.projectview;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.henry.wilds.util.Constants;

/**
 * The KeyListener for the ProjectView
 * @author Samuel Henry
 * @version 2.0
 * @since November 23, 2014
 */
public class Keyboard implements KeyListener {
	
	private static boolean[] keys = new boolean[Constants.TOTAL_KEY_COMBOS];
	
	/**
	 * Resets all of the keys to false
	 */
	public static void resetKeys() {
		for(int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}
	
	/**
	 * Tells whether or not the user has a key down on the keyboard
	 * @param keyCode The key's code
	 * @return True if the key is down, false if not.
	 */
	public static boolean isKeyDown(int keyCode) {
		if(keyCode < 0 || keyCode > Constants.TOTAL_KEY_COMBOS) return false;

		return keys[keyCode];
	}
	
	//****************************************************************************************

	/**
	 * When a key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	/**
	 * When a key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	/**
	 * When a key is typed (pressed and released)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}