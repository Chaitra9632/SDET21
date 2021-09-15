package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateOrganizationWithIndustry extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createOrganizationWithIndusryTest() throws Throwable
	{
	    String OrgName = eLib.getExcelData("Sheet1", 3, 2) + jLib.getRandomNum();
	    String IndType = eLib.getExcelData("Sheet1", 3, 3);
		
		//Navigate to organizations page
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		
		//Navigate to create organizations page
		OrganizationsPage OrgPage = new OrganizationsPage(driver);
		OrgPage.clickOnCreateOrgImg();
		
		//Create organization
		CreateOrganizationPage createOrgP = new CreateOrganizationPage(driver);
		createOrgP.createOrganizationWithIndustry(OrgName, IndType);
		
		//Verification
		OrganizationsInfoPage OrgInfoP = new OrganizationsInfoPage(driver);
		String actualOrgInfo = OrgInfoP.getOrganizationsInfomation();
		Assert.assertTrue(actualOrgInfo.contains(OrgName));
		System.out.println(actualOrgInfo);
		String actualIndInfo = OrgInfoP.getIndustriesInfo();
		Assert.assertTrue(actualIndInfo.equals(IndType));
		System.out.println(IndType);
		
	}

}
