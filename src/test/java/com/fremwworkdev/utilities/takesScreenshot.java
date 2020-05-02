package com.fremwworkdev.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class takesScreenshot 
{
	Logger log;
	String screenshot_loc;
	WebDriver driver;
	String Testcasename;
	public takesScreenshot(WebDriver driver, String Testcasename )
	{
		System.out.println("Inside Constructor");
		log=log.getLogger(Testcasename);
		PropertyConfigurator.configure("log4j.properties");
		this.driver=driver;
		this.Testcasename=Testcasename;
	}
	
	
	public void captureScreenshot() throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver ;
		log.info("Screen shot taken");
		File src= ts.getScreenshotAs(OutputType.FILE);
		System.out.println(Testcasename);
		screenshot_loc= System.getProperty("user.dir")+"/Screenshots/"+ Testcasename +".png";
		File target= new File(screenshot_loc);	
		FileUtils.copyFile(src,target);
		log.info("copied Screenshot to Screenshots location");
		
	}
}
