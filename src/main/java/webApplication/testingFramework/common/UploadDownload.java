package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadDownload {
	
	public static Logger log = LogManager.getLogger(UploadDownload.class.getName());
	
	public void uploadFile(String path) throws Throwable
	{
		try {
			String execPath = PageObjects.getActualLocatorValue(path);
			Thread.sleep(5000);
			Runtime.getRuntime().exec(execPath);
			Thread.sleep(3000);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in uploading the required file!");
			throw t;
		}
	}
	
	public void verifyDownloadedFile(String fileName, String path) throws Throwable
	{
		try {
			//String 
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in downloading required file!");
			throw t;
		}
	}

}
