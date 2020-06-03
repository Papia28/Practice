package webApplication.testingFramework.common;

//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class assertions extends baseFunctions {
	
	//private static final WebDriver driver = baseFunctions.driver;
	//public ArrayList<Integer> list1 = new ArrayList<Integer>();
	//LinkedHashMap <Character, Integer> map1 = new LinkedHashMap <Character, Integer>();
	
	//method to assert a equal value
	public boolean assertEqualValue(String value1, String value2)throws Throwable {
		try {			
			System.out.println("Actual: " + value1);
			System.out.println("Expected: " + value2);
			Assert.assertEquals(value1, value2);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error! Verification unsuccessfull!");
			return false;
		}
	}
}
