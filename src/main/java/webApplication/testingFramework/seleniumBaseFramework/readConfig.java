package webApplication.testingFramework.seleniumBaseFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class readConfig {

	// create variable of type File and FileInputStream to keep the custom
	// properties into it
	private File configFile = null;
	private FileInputStream configFileInput = null;
	private Properties prop = null;

	//method to read the customConfig.properties file
	//public void getConfig() throws Exception {
	public readConfig() {
		try {

			// convert the custom properties to type File and assign it to previously
			// created
			// File type variable
			configFile = new File("src/main/resources/config/customConfig.properties");
			// convert the configFile to FileInputStream type and assign it to previously
			// created FileInputStream type variable
			configFileInput = new FileInputStream(configFile);

			// initiate Properties type variable
			prop = new Properties();

			// load the properties via FileInputType variable
			prop.load(configFileInput);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//method to return the value of browser from customConfig.properties file
	public String getBrowser()throws Exception {
		try {
			return prop.getProperty("browser");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getBrowser()");
			e.printStackTrace();
			return null;
		}
	}
	
	
	//method to return the value of URL from customConfig.properties file
	public String getURL()throws Exception {
		try {
			return prop.getProperty("url");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getURL()");
			e.printStackTrace();
			return null;
		}		
	}
	
	
	//method to return the value of username from customConfig.properties file
	public String getUsername()throws Exception{
		try {
			return prop.getProperty("username");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getUsername()");
			e.printStackTrace();
			return null;
		}
	}
	
	
	//method to return the password from customConfig.properties file
	public String getPassword()throws Exception {
		try {
			return prop.getProperty("password");
		}
		catch(Exception e) {
			System.out.println("Error occurred: method getPassword()");
			e.printStackTrace();
			return null;
		}
	}
}
