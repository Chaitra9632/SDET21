package com.crm.autodesk.GenericUtils;

import java.util.Random;

/**
 * This class contains generic methods pertaining to java 
 * @author Chaitra
 *
 */

public class JavaUtility {
	
	/**
	 * This method generates random number
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int randomNum = ran.nextInt(1000);
		return randomNum;
		
	}


}
