package com.henry.wilds.gui.menu;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import com.henry.wilds.gui.WFrame;
import com.henry.wilds.util.ImageIcons;

/**
 * The menu bar for the main window
 * @author Samuel Henry
 * @since November 26, 2014
 * @version 2.0
 */
@SuppressWarnings("serial")
public class WMenuBar extends JMenuBar {
	
	private WFrame frame;
	
	/**
	 * Creates the menu bar and adds it to the frame
	 * @param frame
	 */
	public WMenuBar(WFrame frame) {
		this.frame = frame;
		
		createMenuBar();
	}
	
	/**
	 * Actual code for creating all the Menus
	 * and MenuItems
	 */
	public void createMenuBar() {
		frame.setJMenuBar(this);

		// File menu **********************************************************
		WMenu fileMenu = new WMenu("File", 'F', this);
		{
			WMenuItem fileNew = new WMenuItem("New Project...", 'P', "control N", fileMenu);
			fileNew.setIcon(ImageIcons.NEW);
			fileNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem fileOpen = new WMenuItem("Open...", 'O', "control O", fileMenu);
			fileOpen.setIcon(ImageIcons.OPEN);
			fileOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			fileMenu.addSeparator();
			
			WMenuItem fileSave = new WMenuItem("Save", 'S', "control S", fileMenu);
			fileSave.setIcon(ImageIcons.SAVE);
			fileSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		
			WMenuItem fileSaveAs = new WMenuItem("Save As...", 'A', "control shift S", fileMenu);
			fileSaveAs.setIcon(ImageIcons.SAVE_AS);
			fileSaveAs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			fileMenu.addSeparator();
			
			WMenuItem fileExport = new WMenuItem("Export as Image...", 'E', "control E", fileMenu);
			fileExport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			fileMenu.addSeparator();
			
			WMenuItem fileExit = new WMenuItem("Exit", 'X', "control W", fileMenu);
			fileExit.setIcon(ImageIcons.EXIT);
			fileExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.exit();
				}
			});
		}
		// End file menu****************************************************

		// Edit menu *******************************************************
		WMenu editMenu = new WMenu("Edit", 'E', this);
		{
			
			WMenuItem editCopy = new WMenuItem("Copy", 'C', "control C", editMenu);
			editCopy.setIcon(ImageIcons.COPY);
			editCopy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem editCut = new WMenuItem("Cut", 'U', "control X", editMenu);
			editCut.setIcon(ImageIcons.CUT);
			editCut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem editPaste = new WMenuItem("Paste", 'P', "control V", editMenu);
			editPaste.setIcon(ImageIcons.PASTE);
			editPaste.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem editEditCouns = new WMenuItem("Counselor...", 'O', "control alt C", editMenu);
			editEditCouns.setIcon(ImageIcons.EDIT_COUNS);
			editEditCouns.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});

			WMenuItem editEditTeam = new WMenuItem("Team...", 'T', "control alt T", editMenu);
			editEditTeam.setIcon(ImageIcons.EDIT_TEAM);
			editEditTeam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		// End edit menu *************************************************

		// Add menu ************************************************
		WMenu addMenu = new WMenu("Add", 'A', this);
		{
			WMenuItem addCouns = new WMenuItem("Counselor...", 'C', "control shift C", addMenu);
			addCouns.setIcon(ImageIcons.ADD_COUNS);
			addCouns.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});

			WMenuItem addTeam = new WMenuItem("Team...", 'T', "control shift T", addMenu);
			addTeam.setIcon(ImageIcons.ADD_TEAM);
			addTeam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem addTable = new WMenuItem("Table...", 'E', "control shift N", addMenu);
			addTable.setIcon(ImageIcons.ADD_TABLE);
			addTable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getProjectView().addTable();
				}
			});
		}
		// End add menu **************************************************
		
		// Window menu ***************************************************
		WMenu windowMenu = new WMenu("Window", 'W', this);
		{
			WMenuItem windowZoomIn = new WMenuItem("Zoom In", 'I', windowMenu);
			windowZoomIn.setIcon(ImageIcons.ZOOM_IN);
			windowZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.CTRL_MASK));
			windowZoomIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem windowZoomOut = new WMenuItem("Zoom Out", 'O', windowMenu);
			windowZoomOut.setIcon(ImageIcons.ZOOM_OUT);
			windowZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.CTRL_MASK));
			windowZoomOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem windowZoomReset = new WMenuItem("Reset Zoom", 'R', "control R", windowMenu);
			windowZoomReset.setIcon(ImageIcons.ZOOM_DEFAULT);
			windowZoomReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem windowPreferences = new WMenuItem("Settings...", 'S', "control shift P", windowMenu);
			windowPreferences.setIcon(ImageIcons.SETTINGS);
			windowPreferences.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem windowGlobalPreferences = new WMenuItem("Preferences...", 'P', "control alt P", windowMenu);
			windowGlobalPreferences.setIcon(ImageIcons.PREFS);
			windowGlobalPreferences.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});			
		}
		// End Window Menu **************************************************************
		
		// Help Menu ********************************************************************
		WMenu helpMenu = new WMenu("Help", 'H', this);
		{
			WMenuItem help = new WMenuItem("Help", 'H', "control H", helpMenu);
			help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			WMenuItem about = new WMenuItem("About", 'A', "control Alt A", helpMenu);
			about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		//End Help Menu *****************************************************************
	}
}