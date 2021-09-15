package com.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {
	
	@Test
	public void createUser()
	{
		System.out.println("user craeted");
	}
	
	@Test
	public void modifyUser()
	{
		System.out.println("user modified");
	}
	
	@Test(enabled = false)
	public void deleteUser()
	{
		System.out.println("user deleted");
	}

}
