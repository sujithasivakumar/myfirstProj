package com.fameworkdev.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;

public class PageObjectClass_login 
{
	Logger log;
    WebDriver driver;
	@FindBy (id="Email")
	@CacheLookup
	WebElement Loginid;
	
	@FindBy (id="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath=".//input[@value='Log in']")
	@CacheLookup
	WebElement Login_Btn;
	
	public PageObjectClass_login(WebDriver driver, String testcase_name)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		log =log.getLogger(testcase_name);
		PropertyConfigurator.configure("Log4j.properties");	
	
	}
	
	
	public void EnterUsername(String username)
	{
		System.out.println(username);
		log.info("About to Enter User name");
		Loginid.clear();
		Loginid.sendKeys(username);
		log.info("Username entered");
	}
	
	public void EnterPassword(String pwd)
	{
		log.info("About to Enter Password");
		password.clear();
		password.sendKeys(pwd);
		log.info("Password entered");
	}
	
	public void Login()
	{
		log.info("About to Press Click Button");
		Login_Btn.click();
		log.info("Logged In button clicked ");
		
		if(driver.getTitle().contentEquals("Dashboard / nopCommerce administration"))
		{
			
			log.info("Logged in Successfully");
			Assert.assertTrue(true);
			
		}
		else
		{
			log.info("Login Failed");
			Assert.fail();
			
		}
		// driver.getTitle();			
	}
	
}
