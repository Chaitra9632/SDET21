package com.crm.autodesk.GenericUtils;
/**
 * This class contains all the basic configuration annotations
 * @author Chaitra
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dbLib = new DataBaseUtility();
	public JSONFileUtility jsonLib = new JSONFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void ConnectDB() throws Throwable
	{
		//dbLib.connectToDB();
		System.out.println("=====MakeDBConnection====");
	}
	//@Parameters("Browser")
	@BeforeClass(groups =  {"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable
	{
		System.out.println("=====launchBbrowesr======");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		
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
		
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups =  {"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws Throwable
	{
		System.out.println("======LogintoApp======");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logoutOfApp() {
		System.out.println("=====logoutOfApp======");
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}
	
	@AfterClass(groups =  {"SmokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		System.out.println("=====closeBbrowesr======");
		driver.close();
	}
	
	
	@AfterSuite(groups =  {"SmokeSuite","RegressionSuite"})
	public void closeDB() throws Throwable
	{
		//dbLib.closeDB();
		System.out.println("=====closeDB======");
	}

}
