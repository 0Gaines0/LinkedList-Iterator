package edu.westga.dsdm;

import edu.westga.dsdm.controller.Controller;

/**
 * The Class Main
 * 
 * The entry point into the application
 * 
 * @author CS3151
 * @version Spring 2023
 */
public class Main {

	/**
	 * Entry point into the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.run();
	}
}
