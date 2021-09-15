package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class TC_01_CreateContactWithOrganizationTest {
	WebDriver driver;
	@Test
	public void createContactWithOrganization() throws Throwable
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
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//create contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//switch to child window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("ch")).click();
		
		//switch back to parent window
		wLib.switchToWindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
        //logout 	
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    wLib.mouseOver(driver, ele);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
	}

}
