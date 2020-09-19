package webApplication.testingFramework.seleniumBaseFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class readConfig {

	// create variable of type File and FileInputStream to keep the custom
	// properties into it
	private static File configFile = null;
	private static FileInputStream configInputStream = null;
	private static final Properties configProperties = new Properties();
	private static Logger log = LogManager.getLogger(readConfig.class.getName());

	//to read the customConfig.properties file
	public static void setReadConfig() throws Throwable{
		try {
			// convert customConfig.properties to type File and assign it to previously
			// created File type variable
			configFile = new File("src/main/resources/configuration/customConfig.properties");
			
			// convert configFile to FileInputStream type and assign it to previously
			// created FileInputStream type variable
			configInputStream = new FileInputStream(configFile);

			// load configProperties via FileInputStream type variable
			configProperties.load(configInputStream);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			log.fatal("Failure! Specified file with location is not found.");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.fatal("Failure! Error in reading config file.");
			throw e;
		}
	}

	
	//method to return the value of browser from customConfig.properties file
	public static String getBrowser()throws Exception {
		try {
			return configProperties.getProperty("browser");
		}
		catch(Throwable e) {
			log.fatal("Failure! Error in getting browser name.");
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//method to return the value of URL from customConfig.properties file
	public static String getURL()throws Exception {
		try {
			return configProperties.getProperty("url");
		}
		catch(Throwable e) {
			log.fatal("Failure! Error in getting URL.");
			e.printStackTrace();
			throw e;
		}		
	}
	
	
	//method to return the value of username from customConfig.properties file
	public static String getUsername()throws Exception{
		try {
			return configProperties.getProperty("username");
		}
		catch(Throwable e) {
			log.fatal("Failure! Error in getting username.");
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//method to return the password from customConfig.properties file
	public static String getPassword()throws Exception {
		try {
			return configProperties.getProperty("password");
		}
		catch(Throwable e) {
			log.fatal("Failure! Error in getting password.");
			e.printStackTrace();
			throw e;
		}
	}
}
