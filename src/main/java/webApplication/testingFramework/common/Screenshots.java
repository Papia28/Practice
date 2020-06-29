package webApplication.testingFramework.common;

import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots {
	
	// method to take simple screenshot via Selenium
	public static String saveScreenshot(WebDriver driver, String name) throws Throwable 
	{
		String desPath = System.getProperty("user.dir") + "\\report\\" + name + ".png";
		File scrFile = null;
		try {
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(desPath));
			return desPath;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in taking screenshot");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	//method to take screenshot via AShot
	public static String saveAshotScreenshot(WebDriver driver, String name)throws Throwable
	{
		String desPath = System.getProperty("user.dir") + "\\report\\" + name + ".png";
		Screenshot screenshot = null;
		try {
			screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "png", new File(desPath));
			return desPath;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in taking screenshot via AShot.");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	//method to take full page screenshot via AShot
	public static String fullPageScreenshot(WebDriver driver, String name)throws Throwable
	{
		String desPath = System.getProperty("user.dir") + "\\report\\" + name + ".png";
		Screenshot screenshot = null;
		try {
			screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "png", new File(desPath));
			return desPath;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in taking full page screenshot!");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
}
