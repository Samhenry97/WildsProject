package com.henry.wilds.gui;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.henry.wilds.util.Constants;

/**
 * This class is the UIManager for this program. It contains
 * methods for setting the look and feel to the system and
 * for setting the "look and feel" of the actual program.
 * @author Samuel Henry
 * @version 2.0
 * @since November 22, 2014
 */
public class WUIManager {
	
	/**
	 * Sets the look and feel of the program to the 
	 * operating system's look and feel. The function
	 * is "to system look and feel (LAF)"
	 */
	public static void toSystemLAF() {
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			
	}
	
	/**
	 * Sets the program to the look and feel of this program itself
	 */
	public static void toProgramLAF() {
		//Buttons
		UIManager.put("Button.background", Constants.BACKGROUND);
		UIManager.put("Button.foreground", Color.BLACK);
		
		//JPanels
		UIManager.put("Panel.background", Constants.BACKGROUND);
	}

}