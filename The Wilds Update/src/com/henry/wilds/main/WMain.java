package com.henry.wilds.main;

import javax.swing.SwingUtilities;

import com.henry.wilds.gui.WFrame;


/**
 * This is the entry point of the whole program.
 * @author Samuel Henry
 * @since June 20, 2014
 * @version 2.0
 * @since November 22, 2014
 */
public class WMain {
	
	/**
	 * The entry point of the program, sending in the
	 * command-line arguments.
	 * @param args The command-line arguments in a string array.
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					String fileToOpen = "";
					if(args.length == 1) 	fileToOpen = args[0];
					
					WFrame frame = new WFrame(fileToOpen);
					frame.setVisible(true);
					
					frame.getProjectView().requestFocus();
					frame.getProjectView().requestFocusInWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}