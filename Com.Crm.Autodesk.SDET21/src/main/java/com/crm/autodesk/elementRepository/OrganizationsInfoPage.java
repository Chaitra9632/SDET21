package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	
	//constructor
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//locate web-elements
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;
	
    //provide getters
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	
	//provide business methods
	/**
	 * get organization information
	 * @return 
	 */
	public String getOrganizationsInfomation()
	{
		String value = organizationInfo.getText();
		return value;
		
	}
	
	/**
	 * get industry information
	 */
	public String getIndustriesInfo() {
		return industryInfo.getText();
		
	}
	
}
