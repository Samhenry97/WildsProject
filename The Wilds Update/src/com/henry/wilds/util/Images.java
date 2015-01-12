package com.henry.wilds.util;

import java.awt.image.BufferedImage;

/**
 * This class contains all the images for the program
 * @author Samuel Henry
 * @version 2.0
 * @since November 22, 2014
 */
public class Images {

	//Images
	public static BufferedImage ICON;
	public static BufferedImage GRID;
	public static BufferedImage ADD_COUNS;
	public static BufferedImage ADD_TEAM;
	public static BufferedImage EDIT_COUNS;
	public static BufferedImage EDIT_TEAM;
	public static BufferedImage TABLE_IMAGE;
	
	/**
	 * Loads all the images in the program
	 */
	public static void loadImages() {
		Console.startBlock("Loading Images");
		
		ICON = Util.getImage("icons/favicon.png");
		GRID = Util.getImage("icons/grid.png");
		ADD_COUNS = Util.getImage("general/add_couns.png");
		ADD_TEAM = Util.getImage("general/add_team.png");
		EDIT_COUNS = Util.getImage("general/edit_couns.png");
		EDIT_TEAM= Util.getImage("general/edit_team.png");
		TABLE_IMAGE = Util.getImage("general/table.png");
		
		Console.endBlock();
	}

}