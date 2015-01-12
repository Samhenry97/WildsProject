package com.henry.wilds.core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import com.henry.wilds.gui.projectview.Keyboard;
import com.henry.wilds.gui.projectview.Mouse;
import com.henry.wilds.gui.projectview.ProjectView;
import com.henry.wilds.util.Constants;

/**
 * The main class for a Wilds Project. It contains
 * an <code>ArrayList</code> for all of the counselors,
 * anotther <code>ArrayList</code> for the teams, and
 * one more <code>ArrayList</code> for all of the tables.
 * 
 * @author Samuel Henry
 * @version 2.0
 * @since November 22, 2014
 */
public class Project {
	
	private ArrayList<Counselor> counselors = new ArrayList<Counselor>();
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<Table> tables = new ArrayList<Table>();
	private File file;
	
	/**
	 * Creates the project with a file for
	 * the project location
	 * @param file The file location
	 */
	public Project(File file) {
		this.file = file;
	}
	
	/**
	 * Draws the project to the ProjectView
	 * @param g The graphics to render with
	 */
	public void render(Graphics g) {
		for(int i = 0; i < tables.size(); i++) {
			tables.get(i).renderShadow(g);
		}
		
		for(int i = 0; i < tables.size(); i++) {
			tables.get(i).render(g);
		}
	}
	
	/**
	 * Updates the Project with the user's input
	 * @param pv The ProjectView JPanel 
	 */
	public void update(ProjectView pv) {
		getKeyInput(pv);
	}
	
	/**
	 * Gets the user's key input and does whatever
	 * needs to be done based on the input
	 * @param pv The ProjectView JPanel
	 */
	public void getKeyInput(ProjectView pv) {
		boolean left = Keyboard.isKeyDown(KeyEvent.VK_LEFT) || Keyboard.isKeyDown(KeyEvent.VK_A);
		boolean right = Keyboard.isKeyDown(KeyEvent.VK_RIGHT) || Keyboard.isKeyDown(KeyEvent.VK_D);
		boolean up = Keyboard.isKeyDown(KeyEvent.VK_UP) || Keyboard.isKeyDown(KeyEvent.VK_W);
		boolean down = Keyboard.isKeyDown(KeyEvent.VK_DOWN) || Keyboard.isKeyDown(KeyEvent.VK_S);
		
		int yDir = 0, xDir = 0;
		
		if(!(up && down)) {
			if(up) yDir = -1;
			else if(down) yDir = 1;
		}
		
		if(!(left && right)) {
			if(left) xDir = -1;
			else if(right) xDir = 1;
		}
		
		if(yDir != 0 || xDir != 0)
			moveAllTables(xDir, yDir, pv);
		
		if(Keyboard.isKeyDown(KeyEvent.VK_DELETE)) {
			for(int i = 0; i < tables.size(); i++) {
				Table t = tables.get(i);
				
				if(pv.getSelectedTables().contains(t)) {
					removeTable(t);
				}
			}
			
			pv.getSelectedTables().clear();
		}
	}
	
	/**
	 * Moves all of the tables in the specified x and y
	 * direction at the constant table's speed
	 * @param xDir The direction to move in the x direction.
	 *    Possible values: {-1, 0, 1}
	 * @param yDir The direction to move in the y direction.
	 *    Possible values: {-1, 0, 1}
	 * @param pv The ProjectView that holds all of the
	 * selected tables
	 */
	public void moveAllTables(int xDir, int yDir, ProjectView pv) {
		for(int i = 0; i < pv.getSelectedTables().size(); i++) {
			Table t = pv.getSelectedTables().get(i);
			
			t.addX(xDir * Constants.TABLE_SPEED);
			t.addY(yDir * Constants.TABLE_SPEED);
			
			t.clamp(pv);
		}
	}
	
	/**
	 * Gets the table that the mouse is currently hovering over
	 * @return The table that the mouse is over
	 */
	public Table mouseOnTable() {
		for(int i = 0; i < tables.size(); i++) {
			Table t = tables.get(i);
			
			if(t.contains(Mouse.getX(), Mouse.getY())) {
				return t;
			}
		}
		
		return null;
	}
	
	/**
	 * Adds a counselor to the counselor <code>ArrayList</code>
	 * @param couns The new counselor
	 */
	public void addCounselor(Counselor couns) {
		counselors.add(couns);
	}
	
	/**
	 * Removes a counselor from the counselor <code>ArrayList</code>
	 * @param couns The counselor to remove
	 */
	public void removeCounselor(Counselor couns) {
		counselors.remove(couns);
	}
	
	/**
	 * Adds a team to the team <code>ArrayList</code>
	 * @param team The team to add
	 */
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	/**
	 * Removes a specified team from the team <code>ArrayList</code>
	 * @param team The team to remove
	 */
	public void removeTeam(Team team) {
		teams.remove(team);
	}
	
	/**
	 * Adds a table to the table <code>ArrayList</code>
	 * @param t The new table
	 */
	public void addTable(Table t) {
		tables.add(t);
	}
	
	/**
	 * Removes a specified table from the table <code>ArrayList</code>
	 * @param t The table to remove
	 */
	public void removeTable(Table t) {
		tables.remove(t);
	}
	
	/**
	 * Gets the Project's name, which is the same as the file name
	 * @return The project's name
	 */
	public String getName() {
		return file.getName();
	}
	
	/**
	 * Gets the ArrayList of all of the tables in the project
	 * @return
	 */
	public ArrayList<Table> getTables() {
		return tables;
	}

}