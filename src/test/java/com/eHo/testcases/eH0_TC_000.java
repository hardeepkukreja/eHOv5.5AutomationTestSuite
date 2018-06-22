/* revoke all the System Directives*/
package com.eHo.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.SystemDirectivePage;
import com.relevantcodes.extentreports.LogStatus;

public class eH0_TC_000
	extends BaseTest{
		
		@BeforeMethod()
		public void setUp()
		{
			init();	//this is the method of BaseTest class to perform initialization
		}
		@Test
		public void TC_000Test() // SD revoke
		{
			try
			{
				test=rep.startTest("TC_000 Test");
				test.log(LogStatus.INFO, "creation of System Directive");
				openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
				navigate("appURL");//to navigate to the application
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
				test.log(LogStatus.INFO, "Clicked submit button");
				NavigationPage navigationPage=new NavigationPage(driver);
				logger.info("TC_026 code is s testcase began  ");
				
				navigationPage.clickConsent();
				navigationPage.clickSystemDirectives();
				SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
				String expectedMessage, actualMessage;
				List<WebElement> activeSD_Row = driver.findElements(By.xpath("//*[@id='sort']/tbody/tr"));
				System.out.println(activeSD_Row.size());
				int j=activeSD_Row.size()+1;
				System.out.println(j);
				
				for (int i=0; i<j; i++)
				{
					
					try 
					{ 
					 systemdirectivepage.clickActiveDirective();
					}
					catch(Exception ex)
					{
					systemdirectivepage.clickActiveSD();
					}
					systemdirectivepage.clickBtnRevoke();
					systemdirectivepage.clickBtnRevokeContinue();
					expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
					actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
					softAssert.assertEquals(expectedMessage, actualMessage);	
					systemdirectivepage.clickBtnBack();
					
				}
				
				String pageSource = driver.getPageSource();
				softAssert.assertTrue(pageSource.contains("No data available in table"));

				softAssert.assertAll();
				
				

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
