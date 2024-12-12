package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccessUrlandBrowser {
	public static Properties p;
	public static FileInputStream fis;
	
	public String accessBrowser(String key) throws IOException  {
		 p = new Properties();
		fis = new FileInputStream("src/test/resources/config.properties");
		p.load(fis);		
		String browser = p.getProperty(key);
		return browser;
	}
	
}
