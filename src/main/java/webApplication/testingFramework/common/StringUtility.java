package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtility {
	
	public static Logger log = LogManager.getLogger(StringUtility.class.getName());
	
	public static String getFeatureName(String name) throws Throwable
	{
		try {
			return name.substring(name.lastIndexOf('/')+1, name.indexOf('.'));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the feature name.");
			throw t;
		}
	}
	
	public static String getTitleCase(String name) throws Throwable
	{
		try {
			char ch[] = name.toCharArray();
			for(int i=0; i<ch.length; i++)
			{
				if(i==0)
					ch[i] = Character.toUpperCase(ch[i]);
				else if(ch[i] == ' ')
				{
					ch[i+1] = Character.toUpperCase(ch[i+1]);
					i++;
					continue;
				}
				else if(i!=0 && ch[i] != ' ')
					ch[i] = Character.toLowerCase(ch[i]);
			}
			
			return String.valueOf(ch);			
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the feature name.");
			throw t;
		}
	}

}
