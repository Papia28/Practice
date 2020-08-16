package webApplication.testingFramework.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import webApplication.testingFramework.seleniumBaseFramework.readConfig;

public class PageObjects extends readConfig{

	private static File pageObjectFile = null;
	private static FileInputStream pageObjectInputStream = null;
	private static final Properties pageObjectProperty = new Properties();
	
	//to set global variables for pageObjects
	public static void setPageObjects() throws Throwable {
		try {
			// convert pageObjects.properties to type File and assign it to previously
			// created File type variable
			//pageObjectFile = new File("src/test/resources/config/pageObjectsSeleniumEasy.properties");
			pageObjectFile = new File("src/test/resources/config/pageObjectsToolsQADemo.properties");
			
			// convert configFile to FileInputStream type and assign it to previously
			// created FileInputStream type variable
			pageObjectInputStream = new FileInputStream(pageObjectFile);
			
			// load pageObjectProperty via FileInputStream type variable
			pageObjectProperty.load(pageObjectInputStream);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading pageObjects file!");
			throw e;
		}
	}
	
	//method to provide the actual locator values
	public static String getActualLocatorValue(String value) throws Throwable {
		try {		
			return pageObjectProperty.getProperty(value);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getActualLocatorValue()!");
			throw e;
		}
	}
}
