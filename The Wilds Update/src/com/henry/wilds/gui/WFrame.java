package com.henry.wilds.gui;

import java.io.File;

import javax.swing.JFrame;

import com.henry.wilds.core.Project;
import com.henry.wilds.core.Table;
import com.henry.wilds.gui.menu.WMenuBar;
import com.henry.wilds.gui.projectview.ProjectView;
import com.henry.wilds.util.Console;
import com.henry.wilds.util.Constants;
import com.henry.wilds.util.ImageIcons;
import com.henry.wilds.util.Images;

/**
 * This is the class for the main window of the
 * whole program. It contains all the dialogs
 * and the user interface.
 * @author Samuel Henry
 * @since November 22, 2014
 * @version 2.0
 */
@SuppressWarnings("serial")
public class WFrame extends JFrame {
	
	private WPane contentPane;
	
	/**
	 * Creates the main frame of the program
	 * @param loadFile If the user opens the program by double-clicking on
	 * a Wilds Project file (*.wip), it will load that file into the program.
	 */
	public WFrame(String loadFile) {
		WUIManager.toSystemLAF();
		WUIManager.toProgramLAF();
		
		Images.loadImages();
		ImageIcons.loadIcons();
		
		createWindow();
		createMenu();
	}
	
	/**
	 * Actually creates the window and its components
	 */
	private void createWindow() {
		Console.startBlock("Creating window");
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(Constants.WIDTH, Constants.HEIGHT);
		setLocationRelativeTo(null);
		if(Constants.MAXIMIZED) setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
		setMinimumSize(Constants.MIN_SIZE);
		setTitle(Constants.TITLE);
		setIconImage(Images.ICON);
		
		contentPane = new WPane(this);
		setContentPane(contentPane);
		addTab(getProjectView().getProject());
		
		Project p = new Project(new File("new2.wip"));
		p.addTable(new Table());
		addTab(p);
		
		createWindowListeners();
		
		Console.endBlock();
	}
	
	/**
	 * Create the menu of the window
	 */
	private void createMenu() {
		WMenuBar menuBar = new WMenuBar(this);
		
		setJMenuBar(menuBar);
	}
	
	/**
	 * Creates the listeners for the window, telling
	 * if the window is closing or being minimized
	 * or maximized.
	 */
	private void createWindowListeners() {
		Console.write("Creating window listeners... ");
		
		WFrameListener l = new WFrameListener(this);
		
		addWindowListener(l);
		addWindowStateListener(l);
		
		Console.writeLine("Done.");
	}
	
	public void addTab(Project p) {
		contentPane.getTabPane().addTab(p);
	}
	
	/**
	 * Gets the ProjectView inside the frame.
	 */
	public ProjectView getProjectView() {
		return contentPane.getSplitPane().getProjectView();
	}
	
	/**
	 * Exits the whole program, saving the current project
	 * if the user says. Also saves the initialization file.
	 */
	public void exit() {
		System.exit(0);
	}
	
}