package com.henry.wilds.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * The basic menu of the program. 
 * @author Samuel Henry
 * @version 2.0
 * @since November 26, 2014
 */
@SuppressWarnings("serial")
public class WMenu extends JMenu {

	/**
	 * Creates a menu with a name and
	 * its parent MenuBar
	 * @param name The name of the menu
	 * @param topMenuBar The MenuBar it will be under
	 */
	public WMenu(String name, Object topMenuBar) {
		this(name, ' ', topMenuBar);
	}

	/**
	 * Creates a menu with a name, mnemonic, and
	 * its parent MenuBar
	 * @param name The name of the menu
	 * @param mnemonic The mnemonic for the menu
	 * @param topMenuBar The MenuBar it will be under
	 */
	public WMenu(String name, char mnemonic, Object topMenuBar) {
		super(name);
		
		if(mnemonic != ' ') {
			setMnemonic(mnemonic);
		}
		
		if(topMenuBar instanceof JMenuBar) {
			((JMenuBar) topMenuBar).add(this);
		} else if(topMenuBar instanceof JMenu) {
			((JMenu) topMenuBar).add(this);
		}
	}
}