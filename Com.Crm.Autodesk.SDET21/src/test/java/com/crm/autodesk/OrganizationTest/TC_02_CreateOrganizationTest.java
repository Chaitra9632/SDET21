package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.GenericUtils.ExcelFileUtility;
import com.crm.autodesk.GenericUtils.JSONFileUtility;
import com.crm.autodesk.GenericUtils.JavaUtility;
import com.crm.autodesk.GenericUtils.WebDriverUtility;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class TC_02_CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void createOrganizationTest() throws Throwable
	{
	    String OrgName = eLib.getExcelData("Sheet1", 1, 3) + jLib.getRandomNum();
	    
		//Navigate to organizations page
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		Reporter.log("org link has been clicked");
		
		//Navigate to create organizations page
		OrganizationsPage OrgPage = new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrgImg();
		Reporter.log("create org link has been clicked");
		
		//Create organization
		CreateOrganizationPage createOrgP = new CreateOrganizationPage(driver);
		createOrgP.createOrganization(OrgName);
		Reporter.log("Organization has been cretaed");
		
		//Verification
		OrganizationsInfoPage OrgInfoP = new OrganizationsInfoPage(driver);
		String actualOrgInfo = OrgInfoP.getOrganizationsInfomation();
		Assert.assertTrue(actualOrgInfo.contains(OrgName));
		System.out.println(actualOrgInfo);
		Reporter.log("Verification successfull", true);

	}
	
	@Test
	public void createOrgWithType() {
		System.out.println("cretae organization with Industry");
	}

}
