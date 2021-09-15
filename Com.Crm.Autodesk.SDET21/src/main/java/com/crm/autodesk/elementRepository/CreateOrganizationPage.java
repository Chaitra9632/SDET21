package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;
	//constructor
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//locate all the webelements
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//provide getters
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business logic
	/**
	 * This method will create organization with mandatory field
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization by choosing an industry type
	 * @param OrgName
	 * @param indType
	 */
	public void createOrganizationWithIndustry(String OrgName, String indType)
	{
		OrgNameEdt.sendKeys(OrgName);
	    select(industryDropdown, indType);
	    saveBtn.click();
	}
	
	
}
