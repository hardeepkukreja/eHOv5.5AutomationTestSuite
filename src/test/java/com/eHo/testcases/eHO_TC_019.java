/* Scheduling reports */
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

public class eHO_TC_019 extends BaseTest{
		
		@BeforeMethod()
		public void setUp()
		{
			init();	//this is the method of BaseTest class to perform initialization
		}
		
		@Test
		public void TC_019Test()
		{
			try
			{
				test=rep.startTest("TC_0019Test");
				test.log(LogStatus.INFO, "Starting the test case to check the basic flow reports scheduling creation ");
				openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
				navigate("appURL");//to navigate to the application
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
				test.log(LogStatus.INFO, "Clicked submit button");
				NavigationPage navigationPage=new NavigationPage(driver);
				ClientSearchPage clientSearch=new ClientSearchPage(driver);
				
				
				
				//report page 
				navigationPage.clickReport();
				navigationPage.clickPolicyReports();
				ActivePolicyReportPage activepolicyreportpage= new ActivePolicyReportPage(driver);
				activepolicyreportpage.clickActivePolicyReportTab();
				activepolicyreportpage.clickBtnSelectName();				
				
				clientSearch.setID(prop.getProperty("id"));
				test.log(LogStatus.INFO, "Searching Id");
				logger.info("TC_019 ID is searched ");	
				
				clientSearch.clickSearch();
				activepolicyreportpage.clickSelectName();
				activepolicyreportpage.clickReturnName();
				activepolicyreportpage.clickScheduleTab();
				activepolicyreportpage.txtScheduleDesc("Automation_Test01");
				activepolicyreportpage.clickbtnSchedule();
				activepolicyreportpage.clickbtnPdfSchedule();
				String expectedMessage1="Your report has been scheduled. You will be notified when it is completed.";
				String	actualMessage1=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				softAssert.assertEquals(expectedMessage1, actualMessage1);
				logger.info("TC_019 report is scheduled ");	
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				navigationPage.clickReport();
				navigationPage.clickScheduledReports();
				
					
			String actualSource=driver.getPageSource();
				boolean a= actualSource.contains("Automation_Test01");
				if(a==true)
				{	
					System.out.println("Passed");
					softAssert.assertFalse(false);
				}	
				
				expectedMessage1="Automation_Test01";
				actualMessage1=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]/div")).getText();		
				System.out.println(actualMessage1);
				
				String statusActual =driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[4]/div")).getText();
				String statusExpected= "Scheduled";
				softAssert.assertEquals(statusActual, statusExpected);
				logger.info("TC_019  passed for report generation  report generation  ");	
				
				
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

		
		
		
		
		
		
		
		
	



