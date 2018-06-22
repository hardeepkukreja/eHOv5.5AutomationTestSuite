package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.AuditReportsPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_029 extends BaseTest {
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}

	
	@Test public void TC_029Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_029 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);

		logger.info("TC_029 scheduled pdf audit report testcase began  ");
		
		navigationPage.clickReport();
		navigationPage.clickAuditReports();
		AuditReportsPage auditreportspage= new AuditReportsPage(driver);
		auditreportspage.clickfrequentCriteria();
		auditreportspage.selectClient();
		auditreportspage.selectEvent();
		auditreportspage.selectUser();
		
		
		// change to schedule 
		auditreportspage.clickScheduleTab();
		auditreportspage.txtScheduleDesc("Scheduled audit report");
		auditreportspage.clickbtnSchedule();
		auditreportspage.clickbtnPdfSchedule();

		logger.info("TC_029 scheduled pdf audit report ");
		
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		navigationPage.clickReport();
		navigationPage.clickScheduledReports();
		

		// schedule report - copy from active policy report page 
		
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains("Scheduled audit report");
		if(a==true)
		{	
			System.out.println("Passed");
			softAssert.assertFalse(false);
		}	
		
		 String expectedMessage1="Scheduled audit report";
	 	String actualMessage1=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]/div")).getText();		
		System.out.println(actualMessage1);
		softAssert.assertEquals(expectedMessage1, actualMessage1);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		
		String statusActual =driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[4]/div")).getText();
		String statusExpected= "Scheduled";
		softAssert.assertEquals(statusActual, statusExpected);
		
		logger.info("TC_029 scheduled audit report testcase passed  ");
		
	
		}
		catch(Exception ex)
		{
			
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case for record level is failed");
			test.log(LogStatus.INFO, ex.getLocalizedMessage());
		}	

		softAssert.assertAll();
	}
		@AfterMethod
		public void tearDown(ITestResult result)
		{
			afterTest(result);
		} 
		}

