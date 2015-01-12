package com.henry.wilds.gui.projectview;

import static com.henry.wilds.gui.projectview.ProjectView.Action.SELECT;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.henry.wilds.util.Constants;

/**
 * The class for the mouse listener in the
 * ProjectView.
 * @author Samuel Henry
 * @since November 23, 2014
 * @version 2.0
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	private static boolean[] buttons = new boolean[Constants.TOTAL_MOUSE_BUTTONS];
	private static int x = 0;
	private static int y = 0;
	private static int dx = 0;
	private static int dy = 0;
	private static boolean isInside = false;
	
	/**
	 * Tells whether or not a specific mouse
	 * button is pressed down
	 * @param button The button to check 
	 * @return True if the button is down, false if not
	 */
	public static boolean isButtonDown(int button) {
		if(button < 0 || button > Constants.TOTAL_MOUSE_BUTTONS) return false;
		
		return buttons[button];
	}
	
	/**
	 * Gets the x position of the mouse relative
	 * to the ProjectView
	 * @return the x position of the mouse
	 */
	public static int getX() {
		return x;
	}
	
	/**
	 * Gets the y position of the mouse relative
	 * to the ProjectView
	 * @return the y position of the mouse
	 */
	public static int getY() {
		return y;
	}
	
	/**
	 * Returns the "delta x" of the mouse,
	 * or how much it has moved in the x axis
	 * @return
	 */
	public static int getDX() {
		return dx;
	}
	
	/**
	 * Returns the "delta y" of the mouse,
	 * or how muc hit has moved in the y axis
	 * @return
	 */
	public static int getDY() {
		return dy;
	}
	
	/**
	 * Whether or not the mouse is inside the ProjectView
	 * @return True if inside, false if not
	 */
	public static boolean isInside() {
		return isInside;
	}
	
	//*************************************************************************
	
	private ProjectView pv;
	
	/**
	 * Creates the mouse
	 */
	public Mouse(ProjectView pv) {
		this.pv = pv;
	}

	/**
	 * When the mouse is dragged (pressed and moved)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		setMousePos(e);
		
		pv.dragEvent();
	}

	/**
	 * When the mouse is moved at all - the first
	 * positions does not equal the last position
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		setMousePos(e);
	}

	/**
	 * When the mouse is clicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	/**
	 * When the mouse enters the component,
	 * in this case the ProjectView
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		isInside = true;
	}

	/**
	 * When the mouse exits the component,
	 * in this case the ProjectView
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		isInside = false;
	}

	/**
	 * When the mouse is pressed inside the ProjectView
	 */
	@Override
	public void mousePressed(MouseEvent e) {		
		buttons[e.getButton()] = true;
		
		if(pv.getAction() == SELECT) {
			pv.selectEvent();
		}
	}

	/**
	 * When the mouse is released inside the ProjectView
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()]  = false;
	}
	
	public void setMousePos(MouseEvent e) {
		dx = e.getX() - x;
		dy = e.getY() - y;
		
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() < 0) {
			pv.zoomIn();
		} else if(e.getWheelRotation() > 0) {
			pv.zoomOut();
		}
	}

}