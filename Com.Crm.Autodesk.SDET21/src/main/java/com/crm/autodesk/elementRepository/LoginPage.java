package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  //rule 1: create a sEperate class for evry webPage

	//rule 4: create a constructor and use pagefactory class to initialize
    public LoginPage(WebDriver driver)  
    {
	    PageFactory.initElements(driver, this);
    }
	
	//rule 2: identify all the webelements using @FindBy, @findBys and @Find All annotatiosn
    @FindBy(name="user_name")
    private WebElement userNameEdt;
    
    @FindBy(name="user_password")
    private WebElement passwordEdt;
    
    @FindBy(id="submitButton")
    private WebElement loginBtn;

    //rule 3: Declare all the web-elements as private and provide the getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//rule 5: access the web-elements using getters()/business methods
	public void login(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
