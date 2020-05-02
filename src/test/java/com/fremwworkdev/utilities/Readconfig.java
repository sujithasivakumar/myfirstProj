package com.fremwworkdev.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class Readconfig 
{
	Properties pro;
	public Readconfig()
	{
		try
		{
			File src= new File("./configuration/config.properties");
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Error Message:"+e.getMessage());
		}

	}
	 
	public String getApplicationURL()
	{
		String ApplicationURL=pro.getProperty("Url");
		return ApplicationURL  ;
		
	}
	
	public String GetLoginId()
	{
		String username=pro.getProperty("username");
		return username  ;		
	}
	
	public String GetPassword()
	{
		String password=pro.getProperty("password");
		return password  ;		
	}
	
	public String getDriverPath()
	{
		String driverpath=pro.getProperty("chromepath");
		return driverpath  ;		
	}
	
}