package webApplication.testingFramework.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DateTimeUtility {
	
	public static Logger log = LogManager.getLogger(DateTimeUtility.class.getName());
	
	public static String getCurrentDateTime() throws Throwable
	{
		/** Date(): Allocates a Date object and initializes it.
		 * It represents the time at which it was allocated, measured to the nearest millisecond.
		 */
		
		/** Month: If the number of pattern letters is 3 or more, 
		 * the month is interpreted as text; 
		 * otherwise, it is interpreted as a number. 
		 */	
		
		try {
			log.debug("Getting local date and time.");
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss a");
			Date date = new Date();
			return formatter.format(date);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the current date and time.");
			throw t;
		}
	}

}
