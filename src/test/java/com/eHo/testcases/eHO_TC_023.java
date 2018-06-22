// Conflicting policies :  allow all and deny all policy creation and revoking them
package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.ClientPolicies;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.RecordLevelPolicyDetailPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_023  extends BaseTest {

	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_023Test()
	{
		try
		{
		test=rep.startTest("Deny all policy Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		ClientSearchPage clientSearch=new ClientSearchPage(driver);
		ClientPolicies clientPolicies=new ClientPolicies(driver);
		RecordLevelPolicyDetailPage recordLevelPolicyDetailPage=new RecordLevelPolicyDetailPage(driver);
		
		navigationPage.clickConsent();
		navigationPage.clickManagement();
		clientSearch.setID(prop.getProperty("id"));
		test.log(LogStatus.INFO, "Searching Id");
		clientSearch.clickSearch();
		clientSearch.clickClientName();
		clientPolicies.clickNewDirective();
		clientPolicies.clickRecordLevel();
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny");  
		recordLevelPolicyDetailPage.setPolicyDescription("Record Level Deny Policy");
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
		recordLevelPolicyDetailPage.selectDomainType("CDR");
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		recordLevelPolicyDetailPage.selectRecordType();
		recordLevelPolicyDetailPage.setRecordText("Test1");
		recordLevelPolicyDetailPage.clickSave();
		
		String expectedMessage="Policy was saved successfully.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		System.out.println(expectedMessage);
		System.out.println(actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		//checking if the policy is created 
		logger.info("TC_023 record leveln deny all policy is created  ");	
		
		 actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
		 expectedMessage="Record Level Deny Policy";
		
		 softAssert.assertEquals(expectedMessage, actualMessage);
	
		clientPolicies.clickNewDirective();
		clientPolicies.clickRecordLevel();
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Allow"); 
		recordLevelPolicyDetailPage.setPolicyDescription("Record Level Allow Policy");
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
		recordLevelPolicyDetailPage.selectDomainType("CDR"); //
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		recordLevelPolicyDetailPage.selectRecordType();
		recordLevelPolicyDetailPage.setRecordText("Test1");
		recordLevelPolicyDetailPage.clickSave();
		logger.info("TC_023 record level allow all policy is created  ");	
		
		String expectedMessage1="This Policy 'Record Level Allow Policy' conflicts with the existing Policy 'Record Level Deny Policy'";
		
		String actualMessage1=driver.findElement(By.xpath(".//*[@id='attnMessagesDialog']/table/tbody/tr/td")).getText();
	
		
		softAssert.assertEquals(expectedMessage1, actualMessage1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// force save 
		recordLevelPolicyDetailPage.clickbtnForceSave();
		// checking the policy is saved 
		expectedMessage="Policy was saved successfully.";
		logger.info("TC_023 record level allow all policy is created  ");	
		
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		
		// revoking first policy 
		
		recordLevelPolicyDetailPage.clickPolicy();
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickbtnBackRevoke();
		logger.info("TC_023 record level allow all policy is revoked   ");	
		
		// second policy
		recordLevelPolicyDetailPage.clickPolicy();
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		

		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		logger.info("TC_023 record level allow all policy is revoked   ");	
		logger.info("TC_023TestCase reached end of execution ");	
		
		System.out.println("TestCase reached end of execution");
		
		
			
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
