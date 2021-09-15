package com.crm.autodesk.OrganizationTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.BaseClass;
import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;

public class CreateOrganizationWithMultipleData extends BaseClass {
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("Sheet2");
	}
	
	@Test(dataProvider = "getData")
	public void createOrgWithMultipleData(String OrgName, String IndType) {
		
		//navigate To Organizations 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		
		//Click on create Organization
		OrganizationsPage orgp = new OrganizationsPage(driver);
		orgp.clickOnCreateOrgImg();
		
		//createOrg
		CreateOrganizationPage createP = new CreateOrganizationPage(driver);
		createP.createOrganizationWithIndustry(OrgName, IndType);
		
		//Validate
		OrganizationsInfoPage orgIn=new OrganizationsInfoPage(driver);
		String actualData=orgIn.getOrganizationsInfomation();
		Assert.assertTrue(actualData.contains(OrgName));
		System.out.println(OrgName);
		
		String actIndustryData = orgIn.getIndustriesInfo();
		Assert.assertTrue(actIndustryData.contains(IndType));
		System.out.println(IndType);
	}

}
