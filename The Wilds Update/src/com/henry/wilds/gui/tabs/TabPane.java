package com.henry.wilds.gui.tabs;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.henry.wilds.core.Project;
import com.henry.wilds.gui.WFrame;

/**
 * This is the JPanel that contains all of
 * the tabs for the current open projects
 * @author Samuel Henry
 * @version 2.0
 * @since November 26, 2014
 */
@SuppressWarnings("serial")
public class TabPane extends JPanel {
	
	private WFrame frame;
	
	/**
	 * Create the TabPane
	 * @param frame The main frame
	 */
	public TabPane(WFrame frame) {
		this.frame = frame;
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	public void addTab(Project p) {
		add(new Tab(this, p));
	}
	
	/**
	 * Changes the current tab to the tab clicked on
	 * @param t The new tab to change to
	 */
	public void changeTab(Tab t) {
		frame.getProjectView().setProject(t.getProject());
	}

}