package webApplication.testingFramework.common;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class RobotFunctions {
	
	public static Logger log = LogManager.getLogger(RobotFunctions.class.getName());
	
	public static void dragAndDropElementRobot(WebElement source, WebElement target) throws Throwable 
	{
		try {
			//initialize new Robot class object
			Robot robot = new Robot();
			
			//find the coordinates of the source and target element
			Point coordinates1 = source.getLocation();
			Point coordinates2 = target.getLocation();				
				
				//move the mouse pointer via the Robot class object to required position
				robot.mouseMove(coordinates1.getX(), coordinates1.getY());
				//Thread.sleep(100);
				
				//press and hold down the left mouse button via Robot object
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				//Thread.sleep(100);
				
				//drag the source element via Robot object to the target element
				robot.mouseMove(coordinates2.getX(), coordinates2.getY());
				//Thread.sleep(100);
				
				//release the source element into the target element via Robot object
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				
				Thread.sleep(100);			
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in dragAndDropElementRobot().");
			throw e;
		}		
	}
}
