/***********************************************************************
 * George E. Mitchell
 * 202330 Software Development I CEN-3024C-32552
 * Module 9 | SDLC (Part 2) Assignment
 * 
 * This JUnit test suite automates the various application unit tests.
 * 
 * @author George E. Mitchell
 * @since 07/07/2023
***********************************************************************/
package application;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


/**
 * This class is used to automate the various application unit tests.
 * 
 * @author George Mitchell
 * @since 07/07/2023
 */
@Suite
@SelectClasses({ 
		ConvertText2ArrayTest.class, 
		ReadFileAsStringTest.class 
})
public class AllTests {}


