package com.crm.autodesk.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains generic methods to read data from property file
 * @author Chaitra
 *
 */
public class PropertyFileUtility {
	
	/**
	 * this method reads data from property file
	 * @throws Throwable 
	 */
    public String getPropertyFileData(String key) throws Throwable
    {
    	FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
    	Properties p = new Properties();
    	p.load(fis);
    	String value = p.getProperty(key);
    	
    	return value;
    	 
    	
    }
}
