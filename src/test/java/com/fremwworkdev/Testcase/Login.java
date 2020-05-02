package com.fremwworkdev.Testcase;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.fameworkdev.pageobject.PageObjectClass_login;
import com.fameworkdev.pageobject.page_objectclass_customerfunctions;
import com.fremwworkdev.utilities.takesScreenshot;


public class Login extends Baseclass
{
	
	@Test(priority=1)
	public void Login_in() throws IOException
	{
		
		PageObjectClass_login pgobj = new PageObjectClass_login(driver,this.getClass().getSimpleName());
		driver.get(baseUrl);
		pgobj.EnterUsername(username);
		pgobj.EnterPassword(password);
		pgobj.Login();
		
	}
	
		

	

}
