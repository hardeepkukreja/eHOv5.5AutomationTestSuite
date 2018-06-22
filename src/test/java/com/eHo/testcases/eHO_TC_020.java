// Help page - Verify content is displayed

package com.eHo.testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_020 extends BaseTest{
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_020Test()
	{
		try
		{
			test=rep.startTest("TC_020Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow of Agent level policy creation ");
			openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
			navigate("appURL");//to navigate to the application
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
			test.log(LogStatus.INFO, "Clicked submit button");
			NavigationPage navigationPage=new NavigationPage(driver);
			ClientSearchPage clientSearch=new ClientSearchPage(driver);
			navigationPage.clickConsent();
			navigationPage.clickManagement();
			clientSearch.setID(prop.getProperty("id"));
			test.log(LogStatus.INFO, "Searching Id");
			clientSearch.clickSearch();
			navigationPage.clickHelp();
			Set <String> separate=driver.getWindowHandles();
			for(String i:separate)
		
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				String title=driver.switchTo().window(i).getTitle();
				System.out.println(title);	
				String actualMessage = driver.findElement(By.xpath(".//*[@id='_Toc508027978']")).getText();
				String expectedMessage="Searching by Identifier";
				softAssert.assertEquals(expectedMessage, actualMessage);
				driver.close();
			}
			logger.info("TC_020  Passed ");	
			
			
		
		}	
		catch(Exception ex)
		{
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case is fail");
			test.log(LogStatus.INFO, ex.getLocalizedMessage());
	
		}
	}
		@AfterMethod
		public void tearDown(ITestResult result)
		{
		afterTest(result);
		}
		
}

