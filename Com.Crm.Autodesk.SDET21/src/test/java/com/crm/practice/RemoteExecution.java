package com.crm.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class RemoteExecution {
	
	@Test
	public void remoteExecutionTest() throws Throwable
	{
		JSONFileUtility jLib = new JSONFileUtility();
		
		String BROWSER = jLib.readDataFromJSON("browser");
		
		URL url = new URL("http://18.216.125.190:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(BROWSER.equals("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(BROWSER.equals("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://gmail.com");
		System.out.println("browser launched successfully");
		
	}

}
