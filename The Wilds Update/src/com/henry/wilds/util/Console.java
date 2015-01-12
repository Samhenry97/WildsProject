package com.henry.wilds.util;

/**
 * This class contains methods for printing objects as
 * string to the standard output stream.
 * @author Samuel Henry
 * @since November 23, 2014
 * @version 2.0
 */
public class Console {
	
	private static int indent = 0;
	private static boolean endLine = true;
	
	/**
	 * Writes a line to the output stream. Basically, writes
	 * some text and ends with newline.
	 * @param obj The object to print to the stream
	 */
	public static void writeLine(Object obj) {
		StringBuilder ind = new StringBuilder();
		
		if(endLine) {
			for(int i = 0; i < indent * Constants.INDENT_AMOUNT; i++) {
				ind.append(" ");
			}
		}
		
		System.out.println(ind + obj.toString());
		
		endLine = true;
	}
	
	/**
	 * Writes an object to the output stream.
	 * @param obj The object to print to the stream
	 */
	public static void write(Object obj) {
		StringBuilder ind = new StringBuilder();
		
		if(endLine) {
			for(int i = 0; i < indent * Constants.INDENT_AMOUNT; i++) {
				ind.append(" ");
			}
		}
		
		System.out.print(ind + obj.toString());
		
		endLine = false;
	}
	
	/**
	 * Starts a "code block" in the console
	 * @param obj The string that starts the block
	 */
	public static void startBlock(Object obj) {
		writeLine(obj + " {");
		
		indent();
	}
	
	/**
	 * Ends a "code block" in the console
	 */
	public static void endBlock() {
		unIndent();
		
		if(indent == 0) {
			writeLine("}\n");
		} else {
			writeLine("}");
		}
	}
	
	private static void indent() {		
		indent++;
	}
	
	/**
	 * Unindents all future lines.
	 */
	private static void unIndent() {
		indent--;
	}
	
}