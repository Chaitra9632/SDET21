package com.crm.autodesk.GenericUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * this class contains methods tpo read data from json file
 * @author Chaitra
 *
 */

public class JSONFileUtility {
	
	/**
	 * this method reads the data from json file
	 * @throws Throwable 
	 */
	public String readDataFromJSON(String key) throws Throwable
	{
		//read the data from json file
    	FileReader file = new FileReader("./commonData.json");
    	
    	//convert the json file into java object
    	JSONParser jsonobj = new JSONParser();
    	Object jobj = jsonobj.parse(file);
    	
    	//type cast java ob to hashmap
    	HashMap map = (HashMap)jobj;
    	String value = map.get(key).toString();
    	
    	//return the value
    	return value;
	}

}
