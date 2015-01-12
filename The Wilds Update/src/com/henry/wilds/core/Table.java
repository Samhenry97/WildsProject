package com.henry.wilds.core;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import com.henry.wilds.gui.projectview.ProjectView;
import com.henry.wilds.util.Constants;
import com.henry.wilds.util.Images;

/**
 * This is the main class for a Table in the program.
 * It holds the x, y, width, and height, along with the
 * Counselor and Team of the table.
 * @author Samuel Henry
 * @since November 22, 2014
 * @version 2.0
 */
public class Table {

	private Counselor counselor;
	private Team team;
	private Table partner;
	private String id;
	private boolean fixed = false;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Creates a table at 0, 0, with the constant table width and height
	 */
	public Table() {
		this(null);
	}
	
	/**
	 * Creates a table at 0, 0, with the constant width and height
	 * along with a counselor
	 * @param counselor The counselor at the table
	 */
	public Table(Counselor counselor) {
		this(counselor, 0, 0, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT);
	}
	
	/**
	 * Creates a table at a specified x, y, width, and height, along
	 * with a counselor.
	 * @param counselor The counselor at the table.
	 * @param x X position of the table.
	 * @param y Y position of the table.
	 * @param width Width of the table.
	 * @param height Height of the table.
	 */
	public Table(Counselor counselor, int x, int y, int width, int height) {
		this(counselor, null, x, y, width, height);
	}
	
	/**
	 * Creates a table at a specified x, y, width, and height, along
	 * with a counselor and team.
	 * @param counselor Counselor at the table
	 * @param team Team of the table.
	 * @param x X position of the table.
	 * @param y Y position of the table.
	 * @param width Width of the table.
	 * @param height Height of the table.
	 */
	public Table(Counselor counselor, Team team, int x, int y, int width,	int height) {
		this.counselor = counselor;
		this.team = team;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Draws the table with an image or a color,
	 * including its name and such
	 * @param g Graphics used for drawing
	 */
	public void render(Graphics g) {		
		if(Images.TABLE_IMAGE != null) {
			g.drawImage(Images.TABLE_IMAGE, x, y, width, height, null);
		} else {
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setPaint(new GradientPaint(x, y, new Color(120, 40, 0), x + width, y + height, new Color(120, 40, 0).darker()));
			g2.fillRoundRect(x, y, width, height, 5, 5);
		}
		
		if(team != null) {
			g.setColor(team.getColor());
			g.fillRect(x + width - 10, y, 10, 10);
		} else {
			g.setColor(Constants.TABLE_TEXT_COL);
		}
		
		if(counselor != null) {
			g.drawString(counselor.getName(), x + 10, y + height / 2 - g.getFont().getSize() / 2);
			g.drawString(counselor.getCabinName(), x + 10, y + height / 2 + g.getFont().getSize() / 2);
		}
	}
	
	/**
	 * Draws the table's shadow to the screen.
	 * @param g Graphics used for drawing
	 */
	public void renderShadow(Graphics g) {
		g.setColor(new Color(20, 20, 20, 150));
		g.fillRect(x + Constants.TABLE_SHADOW_OFFS, y + Constants.TABLE_SHADOW_OFFS, width, height);
	}
	
	/**
	 * Finds if a point is inside the table (usually
	 * used for mouse collision detection)
	 * @param p Point to check
	 * @return True if point is inside, false otherwise
	 */
	public boolean contains(Point p) {
		return x < p.x && x + width > p.x && y < p.y && y + height > p.y;
	}
	
	/**
	 * If the table contains a specified point
	 * from the x and y coordinates
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 * @return If the point is inside the table
	 */
	public boolean contains(int px, int py) {
		return x < px && px < x + width &&
				    y < py && py < y + height;
	}
	
	/**
	 * Clamps the table to the ProjectView's bounds
	 * @param pv The ProjectView
	 */
	public void clamp(ProjectView pv) {
		if(x < 0) {
			x = 0;
		} else if(x + width > pv.getWidth()) {
			x = pv.getWidth() - width;
		}
		
		if(y < 0) {
			y = 0;
		} else if(y + height > pv.getHeight()) {
			y = pv.getHeight() - height;
		}
	}

	/**
	 * Gets the table's counselor
	 * @return Table's counselor
	 */
	public Counselor getCounselor() {
		return counselor;
	}
	
	/**
	 * Sets the table's counselor
	 * @param counselor Counselor to add to table
	 */
	public void setCounselor(Counselor counselor) {
		this.counselor = counselor;
	}

	/**
	 * Gets the table's x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the table's x position
	 * @param x New x position for table.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Adds a certain amount to the x position
	 * @param amount Amount to add to x position
	 */
	public void addX(int amount) {
		this.x += amount;
	}

	/**
	 * Gets the table's y position
	 * @return Table's y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the table's y position
	 * @param y New y position for table
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Adds a specified amount to table's y position
	 * @param amount Amount to add to table's y position
	 */
	public void addY(int amount) {
		this.y += amount;
	}

	/**
	 * Gets the table's width
	 * @return Table's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the table's width
	 * @param width New width for table
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the table's height
	 * @return The height of the table
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the table's height
	 * @param height New height for the table.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the table's team
	 * @return the Team of the table
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Sets the table's team
	 * @param team New team for table
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	/**
	 * Gets the table's partner table
	 * @return The table's partner table
	 */
	public Table getPartner() {
		return partner;
	}
	
	/**
	 * Sets the table's partner table
	 * @param table The new partner table
	 */
	public void setPartner(Table table) {
		partner = table;
	}
	
	/**
	 * Gets the table's id
	 * @return Table's id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the table's id
	 * @param id The new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * If the table is fixed
	 * @return The boolean variable fixed
	 */
	public boolean isFixed() {
		return fixed;
	}
	
	/**
	 * Sets if the table is fixed or not
	 * @param fixed The new value for fixed
	 */
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}
	
	/**
	 * The Object <code>toString</code> method overwritten
	 * @return The textual representation of the table
	 */
	@Override
	public String toString() {
		return super.toString().replace("com.henry.wilds.inner.Table", "");
	}
	
}