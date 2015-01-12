package com.henry.wilds.util;

import java.awt.Color;
import java.awt.Dimension;

/**
 * All the constants for the program.
 * @author Samuel Henry
 * @version 2.0
 * @since November 22, 2014
 */
public class Constants {
	//Frame constants
	//***************************************************************************************
	
	/**
	 * The minimum width of the WFrame
	 */
	private static int MIN_WIDTH = 640;
	
	/**
	 * The minimum height of the WFrame
	 */
	private static int MIN_HEIGHT = 480;
	
	/**
	 * The minimum size of the WFrame
	 */
	public static Dimension MIN_SIZE = new Dimension(MIN_WIDTH, MIN_HEIGHT);
	
	/**
	 * The default width of the WFrame
	 */
	public static int WIDTH = 800;
	
	/**
	 * The default height of the WFrame
	 */
	public static int HEIGHT = 600;
	
	/**
	 * Whether or not the WFrame is maximized
	 */
	public static boolean MAXIMIZED = true;
	
	/**
	 * The title of the WFrame
	 */
	public static String TITLE = "Wilds Dining Hall";
	
	//Project View Constants
	//******************************************************************************************
	
	/**
	 * Minimum width of ProjectView
	 */
	private static int PV_MIN_WIDTH = 800;
	
	/**
	 * Minimum height of ProjectView
	 */
	private static int PV_MIN_HEIGHT = 800;
	
	/**
	 * Default width of ProjectView
	 */
	private static int PV_WIDTH = 1000;
	
	/**
	 * Default height of ProjectView
	 */
	private static int PV_HEIGHT = 1000;
	
	/**
	 * Default size of ProjectView
	 */
	public static Dimension PV_SIZE = new Dimension(PV_WIDTH, PV_HEIGHT);
	
	/**
	 * Minimum size of ProjectView
	 */
	public static Dimension PV_MIN_SIZE = new Dimension(PV_MIN_WIDTH, PV_MIN_HEIGHT);
	
	/**
	 * The background color of the ProjectView
	 */
	public static Color PV_BACKGROUND = new Color(50, 110, 190);
	
	/**
	 * The minimum zoom of the ProjectView
	 */
	public static int MIN_ZOOM = 20;
	
	/**
	 * The maximum zoom of the ProjectView
	 */
	public static int MAX_ZOOM = 400;
	
	/**
	 * The amount the zoom is changed
	 */
	public static int ZOOM_CHANGE = 10;
	
	//Dialog constants
	//******************************************************************************************
	
	/**
	 * Minimum width of the Info JScrollPane
	 */
	private static int INFO_MIN_WIDTH = 200;
	
	/**
	 * Minimum height of the Info JScrollPane
	 */
	private static int INFO_MIN_HEIGHT = 400;
	
	/**
	 * Minimum size of the Info JScrollPane
	 */
	public static Dimension INFO_MIN_SIZE = new Dimension(INFO_MIN_WIDTH, INFO_MIN_HEIGHT);
	
	//Tablel constants
	//*******************************************************************************************
	
	/**
	 * The color of the table's text
	 */
	public static Color TABLE_TEXT_COL = Color.WHITE;
	
	/**
	 * The table's shadow's offset
	 */
	public static int TABLE_SHADOW_OFFS = 15;
	
	/**
	 * The table's default width
	 */
	public static int TABLE_WIDTH = 100;
	
	/**
	 * The table's default height
	 */
	public static int TABLE_HEIGHT = 50;
	
	//General constants
	//*******************************************************************************************
	
	/**
	 * Total key combinations
	 */
	public static int TOTAL_KEY_COMBOS = 65538;
	
	/**
	 * Total mouse buttons
	 */
	public static int TOTAL_MOUSE_BUTTONS = 5;
	
	/**
	 * The amount to indent strings in the console
	 */
	public static int INDENT_AMOUNT = 4;
	
	/**
	 * The max frame-rate of the program.
	 */
	public static int FRAME_CAP = 60;
	
	/**
	 * The main background color of the whole panel
	 */
	public static Color BACKGROUND = new Color(50, 50, 50);
	
	/**
	 * The table speed while moving it using arrow keys
	 */
	public static int TABLE_SPEED = 3;

}