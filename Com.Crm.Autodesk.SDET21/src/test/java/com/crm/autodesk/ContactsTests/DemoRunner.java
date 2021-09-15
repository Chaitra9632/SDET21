package com.crm.autodesk.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class DemoRunner extends BaseClass{
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("Sheet2");
	}
	
	
	@Test(dataProvider = "getData")
	public void demo(String OrgName, String IndType)
	{
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
