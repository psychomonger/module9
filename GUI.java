/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 9 | SDLC (Part 2) Assignment
 * 
 * @author George E. Mitchell
 * @since 07/07/2023
***********************************************************************/
package application;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.Group;
import javafx.scene.text.FontPosture;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 


/**
 * This class produces the application's GUI interface.
 * 
 * @author George Mitchell
 * @since 07/07/2023
 */
public class GUI extends Application implements EventHandler<ActionEvent> {
	
	// Declare objects.
	Button button;
	Text text;
	Text text1;
	Text text2;
	Group root;
	Scene scene;
	TextArea textarea;
	Label label;
	Font font;
	TextField textfield;

	
	/**
	 * This required method starts the GUI interface. 
	 * 
	 * @param stage JavaFX Stage object.
	 * @author George Mitchell
	 * @since 07/07/2023 
	 */
    public void start(Stage stage) {
        	
    	//Creating a Text object 
    	text = new Text();      
    	text.setText("The Raven Text Analyzer!"); 
    	text.setX(10); 
    	text.setY(30);
    	font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16);
    	text.setFont(font); 
    			         
    	//Creating a Text object 
    	text1 = new Text();      
    	text1.setText("This program extracts the poem The Raven by Edgar Allen Poe from an HTML text file and outputs a count of the 20 most frequently used words. Click the RUN button to start the program."); 
    	text1.setX(10); 
    	text1.setY(60);
    	text1.setWrappingWidth(750);
    	font = Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14);
    	text1.setFont(font);
    				
    	button = new Button();
    	button.setText("RUN");
    	button.setLayoutX(10); 
    	button.setLayoutY(100);
    	button.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
    	button.setOnAction(this);
    			
    	label = new Label("RESULTS");
    	label.setLayoutX(10);
    	label.setLayoutY(150);
    	font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
    	label.setFont(font);
    	
    	text2 = new Text();      
    	text2.setText(""); 
    	text2.setX(10); 
    	text2.setY(200);
    	font = Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14);
    	text2.setFont(font);
    			  			            
    	//Creating a Group object   
    	root = new Group(text, text1, label, text2, button);   
   			               
    	//Creating a scene object 
    	scene = new Scene(root, 800, 800);  
    	      
    	//Setting title to the Stage 
    	stage.setTitle("Module 6 | UI Design Assignment"); 
    			         
    	//Adding scene to the stage 
    	stage.setScene(scene); 
    			         
    	//Displaying the contents of the stage 
    	stage.show(); 
    
    }

    /**
	 * This method handles the application process and GUI interface.
	 * 
	 * @param arg0 JavaFX ActiveEvent object interface.
	 * @author George Mitchell
	 * @since 07/07/2023 
	 */
	public void handle(ActionEvent arg0) {
		
		// Declare and initialize required objects and variables.
		FileManager fm = new FileManager();
		TextAnalyzer ta = new TextAnalyzer();
		String html = null;
		String text = null;
		String fileURL = null;
		String startOfTextDelim = null;
		String endOfTextDelim = null;
		int numResultsToOutput = 0;
		String[] array = null;
		
		// Inputs
		fileURL = "C://TheRavenPoemWithHTMLTags.txt";
		startOfTextDelim = "<h1>The Raven</h1>";
		endOfTextDelim = "<!--end chapter-->";
		numResultsToOutput = 20;
		
		html = fm.readFileAsString(fileURL);
		text = ta.getTextFromHTML(html, startOfTextDelim, endOfTextDelim);		
		array = ta.convertText2Array(text);

		// Output results to GUI.
		this.outputResultsToGUI(array, numResultsToOutput);
		
	}
	
	
	/**
	 * This method outputs the results to the GUI.
	 * 
	 * @param array String array of words to count.
	 * @param numResultsToOutput Integer of the number of words to output.
	 * @author George Mitchell
	 * @since 07/07/2023 
	 */
	public void outputResultsToGUI(String[] array, int numResultsToOutput) {
		
		ArrayList<String> arrayWord = new ArrayList<String>();
		ArrayList<Integer> arrayCount = new ArrayList<Integer>();
		String oldWord = "";
		String newWord = "";
		String output = "";
		int count = 0;
		
		// Iterate array to create arrayWord to create distinct list of words.
		for (int i = 0; i < array.length; i++) {
			newWord = array[i];
			if(newWord.equals(oldWord) != true) {	
				arrayWord.add(newWord);
				oldWord = newWord;
			}
		}
				
		// Iterate arrayWord and count number of occurrences in array.
		for (String word : arrayWord) {
			count = 0;
			for (int i = 0; i < array.length; i++) {
				if(word.equals(array[i])) {
					count ++;
				}
			}
			arrayCount.add(count);
		}
		
		for(int i = 1; i <= numResultsToOutput; i++) {
			
			int maxVal = Collections.max(arrayCount);
			int maxIdx = arrayCount.indexOf(maxVal);
					
			//System.out.println(i + " " + arrayWord.get(maxIdx) + " " + maxVal);
			output = output + i + " " + arrayWord.get(maxIdx) + " " + maxVal + System.lineSeparator();
					
			arrayWord.remove(maxIdx);
			arrayCount.remove(maxIdx);
					
		}
		
		text2.setText(output); 
	
	}

}
