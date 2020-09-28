package webApplication.testingFramework.common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpFunctions {
	
	public static Logger log = LogManager.getLogger(HttpFunctions.class.getName()); 
	private static HttpURLConnection connection = null;
	
	public static int getResponseCode(URL url) throws Throwable
	{		
		try {		
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			return connection.getResponseCode();			 
		}
		catch(SocketTimeoutException t)
		{
			t.printStackTrace();
			log.error("Timeout error while connecting!");
			throw t;
		}
		catch(IOException t)
		{
			t.printStackTrace();
			log.error("IO error while opening connection or getting response code!");
			throw t;
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
