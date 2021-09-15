package com.crm.autodesk.GenericUtils;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related tow ebdriver actions
 * @author Chaitra
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method wil wait for the page load for 20 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method will maximize the window
	 */
    public void maximiseWindow(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
    
    /**
     * This method will select from the drop-down using visible text
     * @param element
     * @param value
     */
    public void select(WebElement element, String value)
    {
    	Select sel = new Select(element);
    	sel.selectByVisibleText(value);
    }
    
    /**
     * This method will select from drop-down using index
     * @param element
     * @param index
     */
    public void select(WebElement element, int index)
    {
    	Select sel = new Select(element);
    	sel.selectByIndex(index);
    }
    
    /**
     * this method is used for mouse over actions
     * @param driver
     * @param element
     */
    public void mouseOver(WebDriver driver, WebElement element)
    {
    	
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    }
    
    /**
     * this method is used to do right click
     * @param driver
     * @param element
     */
    public void rightClick(WebDriver driver, WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    /**
     * this method will double click
     * @param driver
     * @param element
     */
    public void doubleClick(WebDriver driver, WebElement element)
    {
    	Actions act = new Actions(driver);
    	act.doubleClick(element).perform();
    }
    
    /**
     * accept the alert popup
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    /**
     * this method will cancel the alert popup
     * @param driver
     */
    public void dismissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    /**
     * this method will switch to frame wrt to index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver, int index)
    {
    	driver.switchTo().frame(index);
    }
    
    /**
     * this method will switch to frame wrt to id
     * @param driver
     * @param frameid
     */
    public void switchToFrame(WebDriver driver, String frameid)
    {
    	driver.switchTo().frame(frameid);
    }
    
    /**
     * this method will switch to frame wrt to element
     * @param driver
     * @param frameElement
     */
    public void switchToFrame(WebDriver driver, WebElement frameElement)
    {
    	driver.switchTo().frame(frameElement);
    }
    
    /**
     * this method will switch to window wrt to partial window title
     * @param driver
     * @param partialwinTitle
     */
    public void switchToWindow(WebDriver driver, String partialwinTitle)
    {
    	Set<String> windowHandles = driver.getWindowHandles();
    	Iterator<String> it = windowHandles.iterator();
    	while(it.hasNext())
    	{
    		String winId = it.next();
    		String actTitle = driver.switchTo().window(winId).getTitle();
    		if(actTitle.contains(partialwinTitle))
    		{
    			driver.switchTo().window(actTitle);
    			break;
    		}
    	
    	}
    }
    
    /**
     * wait for element to be visible
     * @param driver
     * @param element
     */
    public void waitForElementToBeVisible(WebDriver driver, WebElement element)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
}
