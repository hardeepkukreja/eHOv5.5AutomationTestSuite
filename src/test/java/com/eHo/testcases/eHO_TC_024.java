// security search 
package com.eHo.testcases;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.SecurityAlertSearchPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_024 extends BaseTest{

	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization

	}
	
	
	
	@Test
	public void TC_024Test()
	{
		try
		{
		test=rep.startTest("TC_024Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		navigationPage.clickAuditRepository();
		navigationPage.clickSecurityAlert();
	
		SecurityAlertSearchPage securityalertsearchpage= new SecurityAlertSearchPage(driver);
		securityalertsearchpage.clickBtnSearch();
		
		String actualMessage=driver.getTitle();
		System.out.println(actualMessage);
		String expectedMessage= "HIPAAT eSuite Admin";
		softAssert.assertEquals(expectedMessage, actualMessage);
		logger.info("TC_024 TestCase checked for admin title  ");	
		
		int rows=driver.findElements(By.xpath(".//*[@id='resultData']/tbody/tr")).size(); // in the table body , each row is being counted and saved into integer 
		System.out.println("Security alert messages  have : "+rows+ "  rows ");
		
		try
			{
			//driver.findElement(By.id("attnMessagesDialog")).isDisplayed();
			driver.findElement(By.xpath(".//*[@id='attnMessagesDialog']/table/tbody/tr/td")).isDisplayed();
			fail("Element should not have been displayed ");	
			}
		catch (NoSuchElementException e) 
			{
			System.out.println("Passed");	
			softAssert.assertFalse(false);
			logger.info("TC_024 TestCase passed  ");	
			
				}
		logger.info("TC_024 TestCase reached end of execution ");		
		}
		catch(Exception ex)
			{
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case is failed");
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
