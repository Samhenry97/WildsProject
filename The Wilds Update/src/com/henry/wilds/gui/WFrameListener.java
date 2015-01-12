package com.henry.wilds.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import com.henry.wilds.gui.projectview.Keyboard;
import com.henry.wilds.util.Constants;

/**
 * This class listens for events in the main Frame.
 * @author Samuel Henry
 * @version 2.0
 * @since November 23, 2014
 */
public class WFrameListener implements WindowListener, WindowStateListener {
	
	private WFrame frame;
	
	/**
	 * Creates the listener
	 * @param frame The main frame
	 */
	public WFrameListener(WFrame frame) {
		this.frame = frame;
	}

	/**
	 * When the state of the window is changed, such
	 * as maximized, minimized, etc...
	 */
	@Override
	public void windowStateChanged(WindowEvent e) {
		int state = e.getNewState();
		if(state == JFrame.NORMAL) Constants.MAXIMIZED = false;
		else if((state & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) Constants.MAXIMIZED = true;
	}

	/**
	 * When the window is clicked on, or gets
	 * the focus.
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	/**
	 * After the window has closed
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	/**
	 * When the user clicks the 'x' button
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		frame.exit();
	}

	/**
	 * When the window is clicked away from
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		Keyboard.resetKeys();
	}

	/**
	 * When the icon is taken away from the window
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
			
	}

	/**
	 * When an icon is added to the window
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	/**
	 * When the window is created and set visible
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

}