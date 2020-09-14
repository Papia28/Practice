package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.lang.Throwable;

public class AssertionsAndVerifications {
	
	public static Logger log = LogManager.getLogger(AssertionsAndVerifications.class.getName());
	
	//method to assert an equality for two values
	public static void assertEqualValue(String value1, String value2)throws Throwable {
		try {			
			log.debug("Actual: " + value1);
			log.debug("Expected: " + value2);
			Assert.assertEquals(value1, value2);
			log.info("Success! Values match!");
		}
		catch(AssertionError e) {
			e.printStackTrace();
			log.error("assertEqualValue(): Failure! Values do not match!");
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in assertEqualValue()!");
			throw e;
		}
	}
	
	//method to assert whether value true or not
	public static void assertTrueValue(boolean value) throws Throwable{
		try {
			log.debug("Value: " + value);
			Assert.assertTrue(value);
		}
		catch(AssertionError e) {
			e.printStackTrace();
			log.error("assertTrueValue(): Failure! Value not true!");
			throw e;
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in assertTrueValue()!");
			throw e;
		}
	}
	
	//method to check whether true or false without assertion
	public static boolean checkTrueFalse(boolean value) throws Throwable {
		try {
			log.debug("Value: " + value);
			if(value == true)
				return true;
			else if(value == false)
				return false;
			else
				throw new Throwable();
		}
		catch(Throwable e) {
			e.printStackTrace();
			log.error("Error in checkTrueFalse()!");
			throw e;
		}
	}
	
	//method to assert an equality for three values
		public static void assertEqualValue(String value1, String value2, String value3)throws Throwable {
			try {			
				log.debug("Actual Value1: " + value1);
				log.debug("Actual Value2: " + value2);
				log.debug("Expected: " + value3);
				Assert.assertEquals(value1, value3);
				Assert.assertEquals(value2, value3);
				Assert.assertEquals(value1, value2);
				log.info("Success! Values match!");
			}
			catch(AssertionError e) {
				e.printStackTrace();
				log.error("assertEqualValue(): Failure! Values do not match!");
				throw e;
			}
			catch(Throwable e) {
				e.printStackTrace();
				log.error("Error in assertEqualValue()!");
				throw e;
			}
		}
}
