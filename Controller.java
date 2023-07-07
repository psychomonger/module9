/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 9 | SDLC (Part 2) Assignment
 * 
 * This application reads an HTML file to extract a poem for analysis;
 * specifically to count the number of occurrences of each word and
 * output a list of the most used words. This is achieved by creating 
 * two parallel arrays lists, one to record the word itself and the other 
 * to record the number of occurrences. 
 * 
 * @author George Mitchell
 * @since 07/07/2023
***********************************************************************/
package application;
import javafx.application.Application;

/**
 * This is the main class which kicks off the application.
 * 
 * @author George Mitchell
 * @since 07/07/2023
 */
public class Controller {
	
	/**
	 * This is the main method.
	 * 
	 * @param args Array of strings containing required parameters.
	 * @author George Mitchell
	 * @since 07/07/2023
	 */
	public static void main(String[] args) {
		
		// Launching application GUI.
    	Application.launch(GUI.class, args);
    
    }

}