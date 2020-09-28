package webApplication.testingFramework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import webApplication.testingFramework.seleniumBaseFramework.readConfig;

public class PageObjects extends readConfig
{
	private static File pageObjectFile = null;
	private static FileInputStream pageObjectInputStream = null;
	private static final Properties pageObjectProperty = new Properties();
	public static Logger log = LogManager.getLogger(PageObjects.class.getName());
	
	//to set global variables for pageObjects
	public static void setPageObjects() throws Throwable {
		try {
			
			/** convert pageObjects.properties to type File. 
			 * Assign it to previously created File type variable
			 */

			pageObjectFile = new File("src/test/resources/config/pageObjectsToolsQADemo.properties");
			
			
			/** convert configFile to FileInputStream type. 
			 * Assign it to previously created FileInputStream type variable
			 */

			pageObjectInputStream = new FileInputStream(pageObjectFile);
			
			
			// load pageObjectProperty via FileInputStream type variable
			pageObjectProperty.load(pageObjectInputStream);
			
			log.info("Page Object properties file loaded successfully!");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			log.fatal("File not found in the specified path!");
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.fatal("Error in reading pageObjects file!");
			throw e;
		}
	}
	
	//method to provide the actual locator values
	public static String getActualLocatorValue(String key) throws Throwable {
		try {		
			log.debug("Getting the actual locator value of " + key);
			return pageObjectProperty.getProperty(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.error("Error in getActualLocatorValue()!");
			throw e;
		}
	}
}
