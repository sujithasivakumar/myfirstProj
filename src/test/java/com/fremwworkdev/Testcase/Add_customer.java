package com.fremwworkdev.Testcase;

import java.io.IOException;

import org.testng.annotations.Test;


import com.fameworkdev.pageobject.page_objectclass_customerfunctions;
import com.fremwworkdev.utilities.takesScreenshot;

public class Add_customer extends Baseclass
{
	takesScreenshot sc;
	@Test(priority=1)
	public void call_Add_customer() throws IOException
	{
		page_objectclass_customerfunctions pgobj= new page_objectclass_customerfunctions(driver,this.getClass().getSimpleName());
		pgobj.add_customer();
		System.out.println("going to call tscreenshot method");
		sc = new takesScreenshot(driver, this.getClass().getSimpleName());
		
		sc.captureScreenshot();
		System.out.println("going to call tscreenshot method. Enddd");
	}
}
