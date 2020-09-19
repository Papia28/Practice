package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import webApplication.testingFramework.base.PageObjects;

public class UploadDownloadFiles {
	
	public static Logger log = LogManager.getLogger(UploadDownloadFiles.class.getName());
	
	public static String uploadSampleFile(String filePath, String execPath) throws Throwable
	{
		try {		
			String actualFilePath = PageObjects.getActualLocatorValue(filePath);
			int index = actualFilePath.lastIndexOf('\\');
			String fileName = actualFilePath.substring(index+1, actualFilePath.length()-1);	
			
			String actualExecPath = PageObjects.getActualLocatorValue(execPath) + " " + actualFilePath;	
			
			Runtime.getRuntime().exec(actualExecPath);
			
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
