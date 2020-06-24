package webApplication.testingFramework.seleniumBaseFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumBaseDriverManager 
{
	//private static readConfig rc = new readConfig();
	private static String browser = null;
	
	//getter method for browser
	protected String getBrowser()
	{
		return browser;
	}
	
	//setter method for browser
	protected void setBrowser(String browser)
	{
		seleniumBaseDriverManager.browser = browser;
	}
	
	//getter method for 
	
	protected void setDriverManager()throws Exception {
		try {
			//set value for browser
			setBrowser(readConfig.getBrowser());
			
			//switch the browser obtained from config file
			switch(browser) 
			{
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				break;
			case "Internet Explorer":
				WebDriverManager.iedriver().setup();
				break;
			case "Microsoft Edge":
				WebDriverManager.edgedriver().setup();
				break;
			case "Headless":
				//TODO for headless
				break;
			case "Safari":
				//TODO for Safari
				break;
			}
		} 
		catch (Exception e) {
			System.out.println("Error occurred: setDriver()");
			e.printStackTrace();
		}
		
	}
	
}
