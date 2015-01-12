package com.henry.wilds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import com.henry.wilds.gui.projectview.ProjectView;
import com.henry.wilds.util.Constants;

/**
 * This class is the JSplitPane that holds the actual finished view
 * of the dining hall with all the tables and counselors and such in it.
 * It contains a JScrollPane and JPanel for the view, and a JPanel for
 * the info of the table currently selected.
 * @author Samuel Henry
 * @version 2.0
 * @since November 22, 2014
 */
@SuppressWarnings("serial")
public class WSplitPane extends JSplitPane {
	
	private ProjectView pv;
	
	/**
	 * Creates the split pane inside the main frame. The Info is
	 * on the left, and the ProjectView is on the right.
	 * @param frame The main frame, for access
	 */
	public WSplitPane(WFrame frame) {
		super(HORIZONTAL_SPLIT);
		setContinuousLayout(true);
		disableArrowKeyScrolling();

		Info info = new Info();		
		JScrollPane infoPane = new JScrollPane(info);
		infoPane.setMinimumSize(Constants.INFO_MIN_SIZE);
		
		pv = new ProjectView(frame, info);
		JScrollPane projectViewHolder = new JScrollPane(pv);
		projectViewHolder.setMinimumSize(Constants.PV_MIN_SIZE);
		projectViewHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		projectViewHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		setLeftComponent(infoPane);
		setRightComponent(projectViewHolder);
	}
	
	/**
	 * Disables scrolling with arrow keys in JScrollPanes. 
	 * Scrolling is not needed, since arrows are used to move the tables.
	 */
	private void disableArrowKeyScrolling() {
		InputMap  actionMap = (InputMap) UIManager.getDefaults().get("ScrollPane.ancestorInputMap");
		
		actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), new AbstractAction() { //Down key scrolling
			public static final long serialVersionUID = 1L;
		    public void actionPerformed(ActionEvent e) {

		    }
		});
		
		actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), new AbstractAction() { //Up key scrolling
			public static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
		    }
		});
		
		actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), new AbstractAction() { //Left key scrolling
			public static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
		    }
		});
		
		actionMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), new AbstractAction() { //Right key scrolling
			public static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				
		    }
		});
	}
	
	/**
	 * Gets the project view inside the right side of the pane.
	 * @return
	 */
	public ProjectView getProjectView() {
		return pv;
	}
	
}