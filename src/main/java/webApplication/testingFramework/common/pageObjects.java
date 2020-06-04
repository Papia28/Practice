package webApplication.testingFramework.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import webApplication.testingFramework.seleniumBaseFramework.readConfig;

public class pageObjects extends readConfig{

	private static File file = null;
	private static FileInputStream inputStream = null;
	private static final Properties property = new Properties();
	private static String propertyValue =  null;
	
	//method to provide the actual locator values
	protected String getActualLocatorValue(String value) throws Throwable {
		try {		
			file = new File("src/main/resources/config/pageObjects.properties");
			inputStream = new FileInputStream(file);
			property.load(inputStream);
			propertyValue = property.getProperty(value);
			return propertyValue;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getLocatorValue(String).");
			return null;
		}
	}
}
