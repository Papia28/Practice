package webApplication.testingFramework.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class pageObjectProperties {

	protected String getActualLocatorValue(String value) throws Throwable {
		try {
			File file = new File("src/main/resources/config/pageObjects.properties");
			FileInputStream inputStream = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(inputStream);
			String propertyValue = prop.getProperty(value);
			return propertyValue;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getLocatorValue()");
			return null;
		}
	}
}
