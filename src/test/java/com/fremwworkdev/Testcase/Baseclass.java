package com.fremwworkdev.Testcase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fameworkdev.pageobject.PageObjectClass_login;
import com.fremwworkdev.utilities.Readconfig;
import com.fremwworkdev.utilities.takesScreenshot;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampService;
public class Baseclass 
{
	Logger log;
	Readconfig readconfig = new Readconfig();
	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.GetLoginId();
	public String password=readconfig.GetPassword();
	public static WebDriver driver;
	PageObjectClass_login pageObject;
	String screenshot_loc;
	
	
	@BeforeSuite
	public void setup(ITestContext result)
	{ 
		 System.setProperty("webdriver.chrome.driver",readconfig.getDriverPath());
		 log=Logger.getLogger(result.getName());
		 PropertyConfigurator.configure("Log4j.properties");
		 driver= new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver. manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 log.info("Browser Launched");
	}
	
/*	@BeforeClass
	public void beforeClass(ITestContext result)
	{
		System.out.println(result.getName());
	
	}*/

	
	@AfterSuite
	public void terminate() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	/**@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException
	{
		log=log.getLogger(result.getName());
		TakesScreenshot ts = (TakesScreenshot)driver ;
		log.info("Screen shot taken");
		File src= ts.getScreenshotAs(OutputType.FILE);
		String screenshot_loc= System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		File target= new File(screenshot_loc);	
		FileUtils.copyFile(src,target);
		log.info("copied Screenshot to Screenshots location");
		
	}**/
	
	
}
