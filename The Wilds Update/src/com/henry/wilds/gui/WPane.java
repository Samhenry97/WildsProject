package com.henry.wilds.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.henry.wilds.gui.tabs.TabPane;

/**
 * The main JPanel for the whole window
 * @author Samuel Henry
 * @since November 22, 2014
 * @version 2.0
 */
@SuppressWarnings("serial")
public class WPane extends JPanel {
	
	private WSplitPane splitPane;
	private TabPane tabPane;
	
	/**
	 * Creates and adds a JPanel with all components
	 * in it to the main JFrame
	 * @param frame The main frame of the program
	 */
	public WPane(WFrame frame) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {15, 770, 15}; //Sum == WIDTH
		layout.rowHeights = new int[] {50, 15, 520, 15}; //Sum == HEIGHT
		layout.columnWeights = new double[] {Double.MIN_VALUE, 1, Double.MIN_VALUE};
		layout.rowWeights = new double[] {Double.MIN_VALUE, Double.MIN_VALUE, 1, Double.MIN_VALUE};
		setLayout(layout);
		
		//toolbar = new Toolbar(frame);
		GridBagConstraints toolbarConstraints = new GridBagConstraints();
		toolbarConstraints.fill = GridBagConstraints.BOTH;
		toolbarConstraints.gridx = 1;
		toolbarConstraints.gridy = 0;
		//add(toolbar, toolbarConstraints);
		
		tabPane = new TabPane(frame);
		GridBagConstraints tabPanelConstraints = new GridBagConstraints();
		tabPanelConstraints.fill = GridBagConstraints.BOTH;
		tabPanelConstraints.gridx = 1;
		tabPanelConstraints.gridy = 1;
		add(tabPane, tabPanelConstraints);
		
		splitPane = new WSplitPane(frame);
		GridBagConstraints splitConstraints = new GridBagConstraints();
		splitConstraints.fill = GridBagConstraints.BOTH;
		splitConstraints.gridx = 1;
		splitConstraints.gridy = 2;
		add(splitPane, splitConstraints);
	}
	
	/**
	 * Gets the splitpane inside the main contentPane
	 * @return The splitPane
	 */
	public WSplitPane getSplitPane() {
		return splitPane;
	}
	
	public TabPane getTabPane() {
		return tabPane;
	}
	
}