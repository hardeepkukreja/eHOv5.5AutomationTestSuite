package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.AgentPolicyDetailPage;
import com.eHo.pageobjects.AgentSelectPage;
import com.eHo.pageobjects.ClientPolicies;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_007 extends BaseTest{
		
		@BeforeMethod()
		public void setUp()
		{
			init();	//this is the method of BaseTest class to perform initialization
		}
		
		@Test
		public void TC_007Test()
		{
			try
			{
				test=rep.startTest("TC_007Test");
				test.log(LogStatus.INFO, "Starting the test case to check the basic flow of Agent level policy creation ");
				openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
				navigate("appURL");//to navigate to the application
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
				test.log(LogStatus.INFO, "Clicked submit button");
				NavigationPage navigationPage=new NavigationPage(driver);
				ClientSearchPage clientSearch=new ClientSearchPage(driver);
				ClientPolicies clientPolicies=new ClientPolicies(driver);
				AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
				AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
				navigationPage.clickConsent();
				navigationPage.clickManagement();
				clientSearch.setID(prop.getProperty("id"));
				test.log(LogStatus.INFO, "Searching Id");
				clientSearch.clickSearch();
				clientSearch.clickClientName();
				clientPolicies.clickNewDirective();
				clientPolicies.clickAgent();
				agentPolicyDetailPage.selectDirectiveOutcome("Deny");
				agentPolicyDetailPage.setPolicyDescription("Agent Domain specified , operator Equals, Deny Policy");
				agentPolicyDetailPage.clickDomainSpecify();
				
				agentPolicyDetailPage.selectDomainNotEqual();
				agentPolicyDetailPage.selectDomainType("CDR");
				agentPolicyDetailPage.clickAdd();
				agentSelectPage.clickManualEntry();
				agentSelectPage.setID("2.16.840.1.113883.3.239.18.14410003977");
				agentSelectPage.clickReturnSelected();
				
				agentPolicyDetailPage.clickSave();
				
				String expectedMessage="Policy was saved successfully.";
				String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
				softAssert.assertEquals(expectedMessage, actualMessage);
				agentPolicyDetailPage.clickBack();
			
				actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
				 expectedMessage="Agent Domain specified , operator Equals, Deny Policy";			
				 softAssert.assertEquals(expectedMessage, actualMessage);
				
				
				
				agentPolicyDetailPage.clickPolicy();
				agentPolicyDetailPage.clickRevoke();
				agentPolicyDetailPage.clickYesConfirmation();
				
				expectedMessage="Policy was revoked successfully.";
				actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				
				softAssert.assertEquals(expectedMessage, actualMessage);
				agentPolicyDetailPage.clickCloseMessageBox();
				System.out.println("Passed TC _007");
			
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
