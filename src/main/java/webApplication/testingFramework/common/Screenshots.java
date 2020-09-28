package webApplication.testingFramework.common;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots 
{	
	public static Logger log = LogManager.getLogger(Screenshots.class.getName());
	
	// method to take simple screenshot via Selenium
	public static String saveScreenshot(WebDriver driver, String name) throws Throwable 
	{
		File scrFile = null;
		String desPath = null;
		log.debug("Proceeding to take screenshot.");
		try {
			name = name + "_" + DateTimeUtility.getCurrentDateTime();
			desPath = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";			
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(desPath));
			log.info("Screenshot captured successfully!");
			return desPath;
		} 
		catch (NullPointerException e) {
			e.printStackTrace();
			log.error("Source/Destination path is null!");
			throw e;
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error("IO error while copying the screenshot!");
			throw e;
		}
		catch (ScreenshotException e) {
			e.printStackTrace();
			log.error("Not possible to capture a screenshot!");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in taking screenshot");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	//method to take screenshot via AShot
	public static String saveAshotScreenshot(WebDriver driver, String name)throws Throwable
	{
		Screenshot screenshot = null;
		String desPath = null;
		log.debug("Proceeding to take screenshot.");
		try {
			name = name + "_" + DateTimeUtility.getCurrentDateTime();
			desPath = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
			screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "png", new File(desPath));
			log.info("Screenshot captured successfully!");
			return desPath;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			log.error("Destination path is null!");
			throw e;
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.error("Null parameters!");
			throw e;
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error("IO error while writing the screenshot!");
			throw e;
		}
		catch (ScreenshotException e) {
			e.printStackTrace();
			log.error("Not possible to capture a screenshot!");
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in taking screenshot via AShot.");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	//method to take full page screenshot via AShot
	public static String fullPageScreenshot(WebDriver driver, String name)throws Throwable
	{		
		Screenshot screenshot = null;
		String desPath = null;
		log.debug("Proceeding to take screenshot.");
		try {
			name = name + "_" + DateTimeUtility.getCurrentDateTime();
			desPath = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
			screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "png", new File(desPath));
			log.info("Screenshot captured successfully!");
			return desPath;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			log.error("Destination path is null!");
			throw e;
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.error("Null parameters!");
			throw e;
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error("IO error while writing the screenshot!");
			throw e;
		}
		catch (ScreenshotException e) {
			e.printStackTrace();
			log.error("Not possible to capture a screenshot!");
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in taking full page screenshot!");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
}
