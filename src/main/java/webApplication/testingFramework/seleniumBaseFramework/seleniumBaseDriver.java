package webApplication.testingFramework.seleniumBaseFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;

public class seleniumBaseDriver extends seleniumBaseDriverManager {
	private WebDriver seleniumBaseDriver;

	protected WebDriver getSeleniumBaseDriver() {
		return seleniumBaseDriver;
	}

	protected void setSeleniumBaseDriver(WebDriver driver) throws Exception {
		try {
			seleniumBaseDriver = driver;
			switch (super.browser) {
			case "Chrome":
				seleniumBaseDriver = new ChromeDriver();
				break;
			case "Firefox":
				seleniumBaseDriver = new FirefoxDriver();
				break;
			case "Internet Explorer":
				seleniumBaseDriver = new InternetExplorerDriver();
				break;
			case "Microsoft Edge":
				seleniumBaseDriver = new EdgeDriver();
				break;
			case "Headless":
				seleniumBaseDriver = new HtmlUnitDriver();
				break;
			/*case "Safari":
				return this.seleniumBaseDriver = new SafariDriver();*/
			}
		}
		catch (Exception e) {
			System.out.println("Error occurred: setSeleniumBaseDriver()");
			e.printStackTrace();
		}
	}
}
