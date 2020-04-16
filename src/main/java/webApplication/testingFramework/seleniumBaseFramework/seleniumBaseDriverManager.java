package webApplication.testingFramework.seleniumBaseFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumBaseDriverManager {
	public readConfig rc = new readConfig();
	public String browser = null;
	
	protected void setDriverManager()throws Exception {
		try {
			//config.getConfig();
			browser = rc.getBrowser();
			switch(browser) {
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
				//WebDriverManager.chromedriver().setup();
				//TODO for headless
				break;
			case "Safari":
				//WebDriverManager.safaridriver().setup();
				//TODO for Safari
				break;
			}
		} catch (Exception e) {
			System.out.println("Error occurred: setDriver()");
			e.printStackTrace();
		}
		
	}
	
}
