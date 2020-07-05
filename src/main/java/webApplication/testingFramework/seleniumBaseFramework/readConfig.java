package webApplication.testingFramework.seleniumBaseFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	// create variable of type File and FileInputStream to keep the custom
	// properties into it
	private static File configFile = null;
	private static FileInputStream configInputStream = null;
	private static final Properties configProperties = new Properties();

	//constructor to read the customConfig.properties file
	public static void setReadConfig() throws Throwable{
		try {
			// convert customConfig.properties to type File and assign it to previously
			// created File type variable
			configFile = new File("src/main/resources/config/customConfig.properties");
			
			// convert configFile to FileInputStream type and assign it to previously
			// created FileInputStream type variable
			configInputStream = new FileInputStream(configFile);

			// load configProperties via FileInputStream type variable
			configProperties.load(configInputStream);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in reading config file!");
			throw e;
		}
	}

	
	//method to return the value of browser from customConfig.properties file
	public static String getBrowser()throws Exception {
		try {
			return configProperties.getProperty("browser");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getBrowser()");
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//method to return the value of URL from customConfig.properties file
	public static String getURL()throws Exception {
		try {
			return configProperties.getProperty("url");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getURL()");
			e.printStackTrace();
			throw e;
		}		
	}
	
	
	//method to return the value of username from customConfig.properties file
	public static String getUsername()throws Exception{
		try {
			return configProperties.getProperty("username");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getUsername()");
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//method to return the password from customConfig.properties file
	public static String getPassword()throws Exception {
		try {
			return configProperties.getProperty("password");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getPassword()");
			e.printStackTrace();
			throw e;
		}
	}
}
