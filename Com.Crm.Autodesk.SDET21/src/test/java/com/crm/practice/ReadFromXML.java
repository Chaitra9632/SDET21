package com.crm.practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXML {
	
	@Test
	public void readDataFromXML(XmlTest xmlObj)
	{
		System.out.println(xmlObj.getParameter("browser"));
		System.out.println(xmlObj.getParameter("url"));
	}

}
