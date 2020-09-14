package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadDownloadFiles {
	
	public static Logger log = LogManager.getLogger(UploadDownloadFiles.class.getName());
	
	public static String uploadSampleFile(String filePath, String execPath) throws Throwable
	{
		try {
			String actualExecPath = PageObjects.getActualLocatorValue(execPath);
			Runtime.getRuntime().exec(actualExecPath);
			Thread.sleep(5000);
			
			String actualFfilePath = PageObjects.getActualLocatorValue(filePath);
			int index = actualFfilePath.lastIndexOf('\\');
			String fileName = actualFfilePath.substring(index+1);			
			
			return fileName;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in uploading the required file!");
			throw t;
		}
	}
	
	public static void verifyDownloadedFile(String fileName, String path) throws Throwable
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
