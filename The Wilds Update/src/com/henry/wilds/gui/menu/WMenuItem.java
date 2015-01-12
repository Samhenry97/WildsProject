package com.henry.wilds.gui.menu;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * The class for a JMenuItem inside a JPopupMenu
 * or a JMenu. It has easier constructors than the
 * actual java constructors.
 * @author Samuel Henry
 * @since November 26, 2014
 * @version 2.0
 */
public class WMenuItem extends JMenuItem {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a MenuItem with the specified name as
	 * part of a menu
	 * @param name The name of the MenuItem
	 * @param topMenu The menu to add the MenuItem to
	 */
	public WMenuItem(String name, Object topMenu) {
		this(name, ' ', null, topMenu);
	}
	
	/**
	 * Creates a MenuItem with the specified name and mnemonic
	 * as part of a menu
	 * @param name The name of the MenuItem
	 * @param mnemonic The mnemonic of the MenuItem
	 * @param topMenu the menu to add the MenuItem to
	 */
	public WMenuItem(String name, char mnemonic, Object topMenu) {
		this(name, mnemonic, null, topMenu);
	}
	
	/**
	 * Creates a MenuItem with the specified name and accelerator
	 * as part of a menu
	 * @param name The name of the MenuItem
	 * @param accelerator The accelerator of the MenuItem
	 * @param topMenu The menu to add the MenuItem to
	 */
	public WMenuItem(String name, String accelerator, Object topMenu) {
		this(name, ' ', accelerator, topMenu);
	}
	
	/**
	 * Creates a MenuItem with the specified name, accelerator,
	 * and mnemonic as part of a menu.
	 * @param name The name of the MenuItem
	 * @param mnemonic The mnemonic of the MenuItem
	 * @param accelerator The accelerator of the MenuItem
	 * @param topMenu The menu to add the MenuItem to
	 */
	public WMenuItem(String name, char mnemonic, String accelerator, Object topMenu) {
		super(name);
		
		if(mnemonic != ' ') {
			setMnemonic(mnemonic);
		}
		
		if(accelerator != null) {
			setAccelerator(KeyStroke.getKeyStroke(accelerator));
		}
		
		if(topMenu instanceof WMenu) {
			((WMenu) topMenu).add(this);
		}
	}
}