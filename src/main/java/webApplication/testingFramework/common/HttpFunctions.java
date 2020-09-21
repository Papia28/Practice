package webApplication.testingFramework.common;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpFunctions {
	
	public static Logger log = LogManager.getLogger(HttpFunctions.class.getName()); 
	
	public static int getResponseCode(URL url) throws Throwable
	{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {			
			connection.connect();
			return connection.getResponseCode();			 
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the response code.");
			throw t;
		}
		finally
		{
			connection.disconnect();
		}
	}
}
