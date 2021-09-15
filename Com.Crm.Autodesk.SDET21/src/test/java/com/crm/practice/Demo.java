package com.crm.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;

public class Demo {

	@Test
	public void demo() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		String contactName = eLib.getExcelData("Sheet1", 1, 2);
		String OrgName=eLib.getExcelData("Sheet1", 1, 3)+jLib.getRandomNum();
		
		System.out.println(contactName);
		System.out.println(OrgName);
	}

}
