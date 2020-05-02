package com.fameworkdev.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class page_objectclass_customerfunctions 
{
	WebDriver driver;
	String ErrorMsg;
	Logger log;
	@FindBy(xpath="//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='main-sidebar']/div[@class='sidebar']/ul[@class='sidebar-menu tree']/li[4]/a[1]/span[1]")
	 WebElement link_customer;


	@FindBy(xpath="//li[@class='treeview menu-open']//li[1]//a[1]")
	WebElement sublink_customer;
	
	@FindBy(xpath=".//div[@class='pull-right']//a[@class='btn bg-blue']")
	WebElement btn_add;
	@FindBy(id="Email")
	WebElement emailId;
	
	@FindBy(id="Password")
	WebElement pwd;
	@FindBy(id="FirstName")
	 WebElement fname;
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="Gender_MaleName")//=.//*[@id="LastName"]
	WebElement Gender_male;//		gender male=.//*[@id="Gender_Male"]
	@FindBy(id="Gender_Female")
	WebElement Gender_Female;
	@FindBy(id="Company")
	WebElement Company;
	@FindBy(xpath=".//*[@class=\'k-icon k-delete\']")
	WebElement Regiter_del_icon;
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	@FindBy(xpath=".//*[@class=\"validation-summary-errors\"]")
	WebElement ErrorMessage;
	@FindBy (xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement success_Msg;
	

	public page_objectclass_customerfunctions (WebDriver driver, String testcasename)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		log =log.getLogger(testcasename);
		PropertyConfigurator.configure("Log4j.properties");	
		System.out.println("Inside constructor..");
		
		
	}
	public void add_customer()
	{
		link_customer.click();
		//System.out.println("Inside add xustomeradd_customer..");		
		//link_customer.click();
		System.out.println("Trying to click..");
		log.info("customer link clicked");
		sublink_customer.click();
		log.info("Sub-customer link clicked");
		
		btn_add.click();
		log.info("Add button clicked");
		emailId.sendKeys("toot@gmail.com");
		log.info("Email Id given");
		fname.sendKeys("toto");
		log.info("Name given");
		/**Regiter_del_icon.click();
		log.info("Deleted Register default value and trying to savee..");**/
		
		
		savebtn.click();
		log.info("Save button clicked");
		
		try
		{
			if(ErrorMessage.isDisplayed()) 
			{
				ErrorMsg= ErrorMessage.getText();
				log.info("Testcase failed.Reason:"+ ErrorMsg);
				Assert.fail(ErrorMsg);
			}
			else if(success_Msg.isDisplayed())
			{
				assertTrue(true);
				log.info(success_Msg.getText());
				
			}
			
			 
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
		
		
		/*if(ErrorMsg=="The new customer has been added successfully.")///(assertEquals(Message,"The new customer has been added successfully.")==1)
		{
			log.info("Cusomer Added Successfully");
			assertTrue(true);
		}*/
		
		
		
		
	}
	
	
}
