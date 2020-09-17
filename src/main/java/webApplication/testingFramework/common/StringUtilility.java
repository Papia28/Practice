package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtilility {
	
	public static Logger log = LogManager.getLogger(StringUtilility.class.getName());
	
	public static String getFeatureName(String name) throws Throwable
	{
		try {
			//login-to-the-app;login-to-the-app-with-password
			String str[] = name.split(";");
			String rawFeatureName = str[0].replace('-', ' ');
			String featureName = rawFeatureName.replace(rawFeatureName.charAt(0), Character.toUpperCase(rawFeatureName.charAt(0)));
			return featureName;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the feature name.");
			throw t;
		}
	}

}
