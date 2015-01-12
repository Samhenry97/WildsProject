package com.henry.wilds.gui.tabs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.henry.wilds.core.Project;

/**
 * The class for a tab in this program.
 * It will hold the data for a project
 * to be edited.
 * @author Samuel Henry
 * @since November 27, 2014
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Tab extends JButton {
	
	private Project project;
	private TabPane pane;
	
	/**
	 * Creates the tab
	 * @param pane The tab pane that the tab is inside
	 * @param project The tab's project
	 */
	public Tab(TabPane pane, Project project) {
		super(project.getName());
		
		this.project = project;
		this.pane = pane;
		
		addClickListener();
	}
	
	/**
	 * Adds the listener for the click event of the tab
	 */
	private void addClickListener(){ 
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.changeTab(Tab.this);
			}
		});
	}
	
	/**
	 * Gets the tab's synced project
	 * @return The tab's project
	 */
	public Project getProject() {
		return project;
	}

}