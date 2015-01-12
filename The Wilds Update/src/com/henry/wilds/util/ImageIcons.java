package com.henry.wilds.util;

import javax.swing.ImageIcon;

/**
 * This class holds all the ImageIcons used in the program.
 * @author Samuel Henry
 * @since November 23, 2014
 * @version 2.0
 */
public class ImageIcons {
	
	public static ImageIcon ADD_COUNS;
	public static ImageIcon ADD_TEAM;
	public static ImageIcon PREFS;
	public static ImageIcon SETTINGS;
	public static ImageIcon SAVE;
	public static ImageIcon OPEN;
	public static ImageIcon NEW;
	public static ImageIcon EDIT_COUNS;
	public static ImageIcon EDIT_TEAM;
	public static ImageIcon EXIT;
	public static ImageIcon ADD_TABLE;
	public static ImageIcon SAVE_AS;
	public static ImageIcon ZOOM_IN;
	public static ImageIcon ZOOM_OUT;
	public static ImageIcon ZOOM_DEFAULT;
	public static ImageIcon CUT;
	public static ImageIcon COPY;
	public static ImageIcon PASTE;
	public static ImageIcon RANDOMIZE;
	
	/**
	 * Loads all of the ImageIcons into the program.
	 */
	public static void loadIcons() {
		Console.startBlock("Loading ImageIcons");
		
		ADD_COUNS =  new ImageIcon(Util.getImage("icons/add_couns_icon.png"));
		ADD_TEAM = new ImageIcon(Util.getImage("icons/add_team_icon.png"));
		PREFS = new ImageIcon(Util.getImage("icons/prefs.png"));
		SETTINGS = new ImageIcon(Util.getImage("icons/gprefs.png"));
		SAVE = new ImageIcon(Util.getImage("icons/save.png"));
		OPEN = new ImageIcon(Util.getImage("icons/open.png"));
		NEW = new ImageIcon(Util.getImage("icons/new.png"));
		EDIT_COUNS = new ImageIcon(Util.getImage("icons/edit_couns_icon.png"));
		EDIT_TEAM = new ImageIcon(Util.getImage("icons/edit_team_icon.png"));
		EXIT = new ImageIcon(Util.getImage("icons/exit.png"));
		ADD_TABLE = new ImageIcon(Util.getImage("icons/add_table.png"));
		SAVE_AS = new ImageIcon(Util.getImage("icons/save_as.png"));
		ZOOM_IN = new ImageIcon(Util.getImage("icons/zoom_in.png"));
		ZOOM_OUT = new ImageIcon(Util.getImage("icons/zoom_out.png"));
		ZOOM_DEFAULT = new ImageIcon(Util.getImage("icons/reset_zoom.png"));
		CUT = new ImageIcon(Util.getImage("icons/cut.png"));
		COPY = new ImageIcon(Util.getImage("icons/copy.png"));
		PASTE = new ImageIcon(Util.getImage("icons/paste.png"));
		RANDOMIZE = new ImageIcon(Util.getImage("icons/shuffle.png"));
		
		Console.endBlock();
	}

}