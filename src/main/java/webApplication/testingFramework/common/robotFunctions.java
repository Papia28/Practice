package webApplication.testingFramework.common;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class robotFunctions extends genericFunctions {
	
	private static final WebDriver driver = genericFunctions.driver;
	private static final pageObjects po = genericFunctions.po;
	private static final assertions a = genericFunctions.a;
	
	public String[] dragAndDropElements(String locatorType, String sourcePath, String targetPath) throws Throwable {
		try {
			String source = po.getActualLocatorValue(sourcePath);
			String target = po.getActualLocatorValue(targetPath);
			List<WebElement> sourceList = getElements(locatorType, source);
			String[] values = new String[sourceList.size()];
			WebElement sourceElement = null;
			WebElement targetElement = getElement(locatorType, target);
			Robot robot = new Robot();
			Point coordinates1 = null, coordinates2 = targetElement.getLocation();
			
			for (int i = 0; i < sourceList.size(); i++) 
			{
				sourceElement = sourceList.get(i);
				coordinates1 = sourceElement.getLocation();
				robot.mouseMove(coordinates1.getX(), coordinates1.getY());
				Thread.sleep(100);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(100);
				robot.mouseMove(coordinates2.getX(), coordinates2.getY());
				Thread.sleep(100);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(100);
			}

			return values;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}
}
