package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(linkText = "Organizations")
	private WebElement orgnizationLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(linkText = "Contacts")
    private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	
	// generate getters 

	public WebElement getOrgnizationLnk() {
		return orgnizationLnk;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	// provide business login
	
	public void clickOnOrganizations()
	{
		orgnizationLnk.click();
	}
	
	public void clickOnContacts()
	{
		contactsLnk.click();
	}
	
	public void signOut(WebDriver driver)
	{
		waitForElementToBeVisible(driver, administatorImg);
	    mouseOver(driver, administatorImg);
	    signoutLnk.click();
	}
	
	public void clickOnLeads()
	{
		leadsLnk.click();
	}

}
