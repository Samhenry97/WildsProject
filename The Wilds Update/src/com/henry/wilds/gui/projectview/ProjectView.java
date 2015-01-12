package com.henry.wilds.gui.projectview;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JViewport;

import com.henry.wilds.core.Project;
import com.henry.wilds.core.Table;
import com.henry.wilds.gui.Info;
import com.henry.wilds.gui.WFrame;
import com.henry.wilds.util.Constants;
import com.henry.wilds.util.Time;
import com.henry.wilds.util.Util;

/**
 * The ProjectView is the main JPanel of the
 * program that displays the project. It contains 
 * listeners for the user input and updates the
 * actual project based on the input.
 * @author Samuel Henry
 * @version 2.0
 * @since November 26, 2014
 */
@SuppressWarnings("serial")
public class ProjectView extends JPanel implements Runnable  {
	
	/**
	 * The enumeration for the "action" the user is currently
	 * performing: Dragging the mouse, selecting tables,
	 * or selecting partners
	 * @author Samuel Henry
	 * @version 2.0
	 * @since November 26, 2014
	 */
	public static enum Action { DRAG, SELECT, PARTNER };
	
	//**************************************************************
	
	private Project project;
	private ArrayList<Table> selected = new ArrayList<Table>();
	
	private double zoom = 100;
	private int fps = 0;
	
	private Info info;
	private Action action = Action.SELECT;
	
	private Thread thread;
	private boolean running = false;
	
	/**
	 * Creates the ProjectView JPanel
	 * @param frame The main frame the panel is inside
	 * @param info The info panel for the table's info
	 */
	public ProjectView(WFrame frame, Info info) {
		setSize(Constants.PV_SIZE);
		setPreferredSize(Constants.PV_SIZE);
		setLayout(new FlowLayout());
		
		project = new Project(new File("new.wip"));
		project.addTable(new Table(null, 50, 50, 50, 50));
		
		createListeners();
		
		this.info = info;
		
		start();
	}
	
	/**
	 * Renders the project and any other components to the
	 * panel.
	 * @param g The graphics to render with
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Get the 2D graphics for zooming and paint
		Graphics2D g2 = (Graphics2D) g;
		
		//Apply the zoom
		if(zoom != 100) g2.scale(zoom / 100, zoom / 100);
		
		//Paint the background of the ProjectView
		GradientPaint backgroundPaint = new GradientPaint(0, 0, Constants.PV_BACKGROUND, 
				getWidth() / 2, getWidth() / 2, Constants.PV_BACKGROUND.darker().darker());
		g2.setPaint(backgroundPaint);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		project.render(g);
		
		g.setColor(Color.WHITE);
		for(int i = 0; i < selected.size(); i++) {
			Table t = selected.get(i);
			
			g.drawRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());
		}
		
		g.dispose();
	}
	
	/**
	 * Updates the whole project
	 */
	public void update() {
		project.update(this);
	}
	
	/**
	 * Creates the key and mouse listeners for the program
	 */
	public void createListeners() {
		Keyboard keyboard = new Keyboard();
		Mouse mouse = new Mouse(this);
		
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addMouseWheelListener(mouse);
	}
	
	/**
	 * The "main loop" of the panel: It calls the
	 * update method <code>Constants.FRAME_CAP</code>
	 * times every second
	 */
	public void run() {
		running = true;
		
		int frames = 0;
		long frameCounter = 0;
		final double frameTime = 1.0 / Constants.FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;		
		
		while(running) {
			boolean render = false;
			
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime) {
				render = true;
				
				unprocessedTime -= frameTime;
				update();
				
				if(frameCounter >= Time.SECOND) {
					fps = frames;
					
					frames = 0;
					frameCounter = 0;
				}
			}
			
			if(render) {
				repaint();
				frames++;
			} else {
				Util.sleep(1);
			}
		}
	}
	
	/**
	 * Creates the thread for the ProjectView panel,
	 * then starts it.
	 */
	public void start() {
		try {
			thread = new Thread(this, "Project View");
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the current project being drawn to the panel
	 * and updated.
	 * @param p The new project
	 */
	public void setProject(Project p) {
		project = p;
		
		selected.clear();
	}
	
	/**
	 * Gets the current project
	 * @return The current project being edited
	 */
	public Project getProject() {
		return project;
	}
	
	/**
	 * Gets the selected ArrayList
	 * @return The selected ArrayList
	 */
	public ArrayList<Table> getSelectedTables() {
		return selected;
	}
	
	/**
	 * Adds a table to the ProjectView
	 */
	public void addTable() {
		Table t = new Table();
		Rectangle viewRect = ((JViewport) getParent()).getVisibleRect();
		
		if(Mouse.isInside()) {
			t.setX(Mouse.getX() - viewRect.x - t.getWidth() / 2);
			t.setY(Mouse.getY() - viewRect.y - t.getHeight() / 2);
		} else {
			t.setX(viewRect.x + viewRect.width / 2 - t.getWidth() / 2);
			t.setY(viewRect.y + viewRect.height / 2 - t.getHeight() / 2);
		}
		
		t.clamp(this);
		
		project.addTable(t);
	}
	
	/**
	 * Gets the user's current action
	 * @return The user's current <code>Action</code>
	 */
	public Action getAction() {
		return action;
	}
	
	public void selectEvent() {
		if(Mouse.isButtonDown(MouseEvent.BUTTON1)) {
			if(selected.isEmpty()) {
				Table t = project.mouseOnTable();
				
				if(t != null) selected.add(t);
			} else {
				if(Keyboard.isKeyDown(KeyEvent.VK_CONTROL)) {
					for(int i = 0; i < project.getTables().size(); i++) {
						Table t = project.getTables().get(i);
						
						if(t.contains(Mouse.getX(), Mouse.getY())) {
							if(!selected.contains(t)) selected.add(t);
							else selected.remove(t);
						}
					}
				} else {
					Table t = project.mouseOnTable();
					
					if(t != null && !selected.contains(t)) {
						selected.clear();
						selected.add(t);
					} else if(!selected.contains(t)) {
						selected.clear();
					}
				}
			}
		}
	}
	
	/**
	 * Gets called when the Mouse Dragged event if fired
	 */
	public void dragEvent() {
		if(selected.isEmpty()) {
			
		} else {
			for(int i = 0; i < selected.size(); i++) {
				Table t = selected.get(i);
				
				t.addX(Mouse.getDX());
				t.addY(Mouse.getDY());
				
				t.clamp(this);
			}
		}
	}
	
	/**
	 * Zooms the ProjectView out
	 */
	public void zoomOut() {
		zoom += Constants.ZOOM_CHANGE;
		
		if(zoom > Constants.MAX_ZOOM) zoom = Constants.MAX_ZOOM;
	}
	
	/**
	 * Zooms the ProjectView in
	 */
	public void zoomIn() {
		zoom -= Constants.ZOOM_CHANGE;
		
		if(zoom < Constants.MIN_ZOOM) zoom = Constants.MIN_ZOOM;
	}
	
	/**
	 * Resets the zoom of the ProjectView to 100
	 */
	public void resetZoom() {
		zoomTo(100);
	}
	
	/**
	 * Zooms to a specified value
	 * @param zoom The new zoom
	 */
	public void zoomTo(int zoom) {
		if(zoom < Constants.MIN_ZOOM || zoom > Constants.MAX_ZOOM) return;
		
		this.zoom = zoom;
	}
	
	/**
	 * Gets the zoom of the ProjectView
	 * @return The ProjectView's zoom
	 */
	public double getZoom() {
		return zoom;
	}

}