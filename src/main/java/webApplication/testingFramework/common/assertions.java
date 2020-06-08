package webApplication.testingFramework.common;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class assertions extends baseFunctions {
	
	//private static final WebDriver driver = baseFunctions.driver;
	
	//method to assert an equality for two values
	public boolean assertEqualValue(String value1, String value2)throws Throwable {
		try {			
			System.out.println("Actual: " + value1);
			System.out.println("Expected: " + value2);
			Assert.assertEquals(value1, value2);
			System.out.println("Success! Values match!");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("assertEqualValue(): Error! Values do not match!");
			throw e;
		}
	}
	
	//method to assert whether value true or not
	public boolean assertTrueValue(boolean value) throws Throwable{
		try {
			System.out.println("Value: " + value);
			Assert.assertTrue(value);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("assertTrueValue(): Error! Value not true!");
			throw e;
		}
	}
	
	//method to check whether true or false without assertion
	public boolean checkTrueFalse(boolean value) throws Throwable {
		try {
			if(value == true)
				return true;
			else if(value == false)
				return false;
			else
				throw new Throwable();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in checkTrueFalse().");
			throw e;
		}
	}
	
	//method to assert an equality for three values
		public boolean assertEqualValue(String value1, String value2, String value3)throws Throwable {
			try {			
				System.out.println("Actual Value1: " + value1);
				System.out.println("Actual Value2: " + value2);
				System.out.println("Expected: " + value3);
				Assert.assertEquals(value1, value3);
				Assert.assertEquals(value2, value3);
				Assert.assertEquals(value1, value2);
				System.out.println("Success! Values match!");
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("assertEqualValue(): Error! Values do not match!");
				throw e;
			}
		}
}
