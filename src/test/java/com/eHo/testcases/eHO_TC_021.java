// testing help page for report section 
package com.eHo.testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.ActivePolicyReportPage;

import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_021 extends BaseTest{
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_021Test()
	{
		try
		{
			test=rep.startTest("TC_0021Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow reports scheduling creation ");
			openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
			navigate("appURL");//to navigate to the application
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
			test.log(LogStatus.INFO, "Clicked submit button");
			NavigationPage navigationPage=new NavigationPage(driver);
			
			
			//report page 
			navigationPage.clickReport();
			navigationPage.clickPolicyReports();
			ActivePolicyReportPage activepolicyreportpage= new ActivePolicyReportPage(driver);
			activepolicyreportpage.clickActivePolicyReportTab();
			
			navigationPage.clickHelp();
			Set <String> separate=driver.getWindowHandles();
			for(String i:separate)
		
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.switchTo().window(i).getTitle();
				
				String actualMessage = driver.findElement(By.xpath(".//*[@id='_Toc508028015']")).getText();
				String expectedMessage="Active Policies Report";
				softAssert.assertEquals(expectedMessage, actualMessage);
				driver.close();
			}
			
	

}
		catch(Exception ex)
		{
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case failed");
			test.log(LogStatus.INFO, ex.getLocalizedMessage());
		}
}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	afterTest(result);
	}
}
