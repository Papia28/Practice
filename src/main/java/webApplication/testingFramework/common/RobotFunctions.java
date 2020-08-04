package webApplication.testingFramework.common;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class RobotFunctions {
	
	//private static final assertions a = genericFunctions.a;
	private static Robot robot = null;
	
	public static String[] dragAndDropElementsRobot(List<WebElement> sourceList, WebElement target) throws Throwable {
		try {
			//initialize static Robot class object
			robot = new Robot();
			
			String[] values = new String[sourceList.size()];
			WebElement sourceElement = null;
			
			//find the coordinates of the target element
			Point coordinates1 = null, coordinates2 = target.getLocation();
			
			for (int i = 0; i < sourceList.size(); i++) 
			{
				sourceElement = sourceList.get(i);
				
				//get the coordinate of the source element
				coordinates1 = sourceElement.getLocation();
				
				//move the mouse pointer via the Robot class object to required position
				robot.mouseMove(coordinates1.getX(), coordinates1.getY());
				Thread.sleep(100);
				
				//press and hold down the left mouse button via Robot object
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(100);
				
				//drag the source element via Robot object to the target element
				robot.mouseMove(coordinates2.getX(), coordinates2.getY());
				Thread.sleep(100);
				
				//release the source element into the target element via Robot object
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(100);
				
				//assign values to names of the dragged and dropped source elements
				values[i] = sourceElement.getText();
			}
			
			//return the names of the dragged and dropped elements
			return values;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in dragAndDropElementsRobot().");
			throw e;
		}		
	}
}
