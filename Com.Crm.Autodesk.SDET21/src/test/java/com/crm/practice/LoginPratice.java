package com.crm.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;
import com.crm.autodesk.elementRepository.LoginPage;

public class LoginPratice {
	 WebDriver driver;
	@Test
	public void loginPractice() throws Throwable
	{
		       
		        //read all the neccessary data
				JSONFileUtility jsonLib = new JSONFileUtility();
				JavaUtility jLib = new JavaUtility();
				WebDriverUtility wLib = new WebDriverUtility();
				ExcelFileUtility eLib = new ExcelFileUtility();
				
				String URL = jsonLib.readDataFromJSON("url");
				String BROWSER = jsonLib.readDataFromJSON("browser");
				String USERNAME = jsonLib.readDataFromJSON("username");
				String PASSWORD = jsonLib.readDataFromJSON("password");
				
				String contactName = eLib.getExcelData("Sheet1", 1, 2);
				String OrgName=eLib.getExcelData("Sheet1", 1, 3);
				
				//Launch the browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser");
				}
				
				wLib.waitForPageLoad(driver);
				wLib.maximiseWindow(driver);
				driver.get(URL);
				
				LoginPage lp = new LoginPage(driver);
				lp.login(USERNAME, PASSWORD);
				
				System.out.println("login successful");
	}

}
