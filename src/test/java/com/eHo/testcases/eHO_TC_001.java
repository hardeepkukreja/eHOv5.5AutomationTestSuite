/* revoking all the */
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
import com.eHo.pageobjects.AgentPolicyDetailPage;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_001 extends BaseTest {

		@BeforeMethod()
		public void setUp()
		{
			init();	//this is the method of BaseTest class to perform initialization
		}
		
		@Test
		public void TC_001Test()
		{
			try {
				test=rep.startTest("TC_001Test");
				test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
				openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
				navigate("appURL");//to navigate to the application
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
				test.log(LogStatus.INFO, "Clicked submit button");
				NavigationPage navigationPage=new NavigationPage(driver);
				ClientSearchPage clientSearch=new ClientSearchPage(driver);
			
				AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				navigationPage.clickConsent();
				navigationPage.clickManagement();
				clientSearch.setID(prop.getProperty("id4"));
				logger.info("Id is searched ....");	
				clientSearch.clickSearch();
				clientSearch.clickClientName();
				String expectedMessage, actualMessage;
				
				List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='resultData']/tbody/tr"));
				
				int j=rows.size();
                System.out.println("number of rows:" + j);
                int k=j+1;
                System.out.println("loop will be executed :" + k);
				for (int i=1; i<k; i++) 
				{					
					driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();
					agentPolicyDetailPage.clickRevoke();
					agentPolicyDetailPage.clickYesConfirmation();
					expectedMessage="Policy was revoked successfully.";
					actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();						
					softAssert.assertEquals(expectedMessage, actualMessage);
					agentPolicyDetailPage.clickCloseMessageBox();
					agentPolicyDetailPage.clickBack();				
				}
				
				softAssert.assertAll();
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
