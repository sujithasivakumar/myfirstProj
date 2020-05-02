package com.fremwworkdev.utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fremwworkdev.Testcase.Baseclass;

public class ListenerClass1 extends TestListenerAdapter 
{
	
	ExtentHtmlReporter HtmlReporter;
	ExtentReports Reports;
	ExtentTest test;
	String screenshot_loc;
	Logger log;
	takesScreenshot sc;
	
	@Override
	public void onStart(ITestContext context)
	{
	
		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/ myreport.html");
		HtmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		Reports = new ExtentReports();
		Reports.attachReporter(HtmlReporter);
		
		//System Info
		Reports.setSystemInfo("OS", "Windows");
		Reports.setSystemInfo("Env", "QAF1");
		
		//Report Configurations
		HtmlReporter.config().setDocumentTitle("ExecutionReport");
		HtmlReporter.config().setReportName("Execution Report");
		HtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		HtmlReporter.config().setTheme(Theme.DARK);
		HtmlReporter.config().getChartVisibilityOnOpen();
		PropertyConfigurator.configure("Log4j.properties");
		
			
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		log=Logger.getLogger(result.getName());
		sc= new takesScreenshot(Baseclass.driver,result.getName());
		try {
			sc.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Testcase" + result.getName() +"is passed");
		test = Reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Passed", ExtentColor.GREEN));
		screenshot_loc=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		try {
			log.info("Trying to fetch Screenshot to add to report..");
			test.addScreenCaptureFromPath(screenshot_loc);
			log.info("screenshot added to Report");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Failed to add screen shot");
		}
		log.info("Closing"+result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		log=Logger.getLogger(result.getName());
		sc= new takesScreenshot(Baseclass.driver,result.getName());
		try {
			sc.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Testcase" + result.getName() +"is failed");	
		
		String screenshot_loc=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		test = Reports.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Failed", ExtentColor.GREEN));
		screenshot_loc=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		test.log(Status.INFO,result.getThrowable());
		try 
		{
			log.info("Trying to fetch Screenshot to add to report..");
			test.addScreenCaptureFromPath(screenshot_loc);
			log.info("screenshot added to Report");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Failed to add screen shot");
		}
		log.info("Closing"+result.getName());
		
	}
	
	@Override
    public void onFinish(ITestContext context)
    {  
        Reports.flush(); 
       
    }
}

	
	
	

