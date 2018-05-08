package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.ActivePolicyReportPage;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_018 extends BaseTest{
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_018Test()
	{
		try
		{
			test=rep.startTest("TC_0018Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow reports creation ");
			openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
			navigate("appURL");//to navigate to the application
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
			test.log(LogStatus.INFO, "Clicked submit button");
			NavigationPage navigationPage=new NavigationPage(driver);
		
			navigationPage.clickReport();
			navigationPage.clickPolicyReports();
			ActivePolicyReportPage activepolicyreportpage= new ActivePolicyReportPage(driver);
			activepolicyreportpage.clickActivePolicyReportTab();
			activepolicyreportpage.clickBtnSelectName();
			
			//
			
			ClientSearchPage clientSearch=new ClientSearchPage(driver);
			clientSearch.setID(prop.getProperty("id"));
			test.log(LogStatus.INFO, "Searching Id");
			clientSearch.clickSearch();
			
			
			
			
			
			activepolicyreportpage.clickSelectName();
			activepolicyreportpage.clickReturnName();
			activepolicyreportpage.clickScheduleTab();
			activepolicyreportpage.txtScheduleDesc("Automation");
			activepolicyreportpage.clickbtnSchedule();
			activepolicyreportpage.clickbtnPdfSchedule();
			String expectedMessage1="Your report has been scheduled. You will be notified when it is completed.";
			String	actualMessage1=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
			
			softAssert.assertEquals(expectedMessage1, actualMessage1);
			

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			navigationPage.clickReport();
			navigationPage.clickScheduledReports();
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
			
		String actualSource=driver.getPageSource();
			boolean a= actualSource.contains("Automation");
			if(a==true)
			{	
				System.out.println("Passed");
				softAssert.assertFalse(false);
			}	
			
			expectedMessage1="Automation";
			actualMessage1=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]/div")).getText();		
			System.out.println(actualMessage1);
			
			String statusActual =driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[4]/div")).getText();
			String statusExpected= "Scheduled";
			softAssert.assertEquals(statusActual, statusExpected);
			
			
			
			
			
			
		}
		catch(Exception ex)
		{
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case is fail");
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
	
	
	
	
	
	

