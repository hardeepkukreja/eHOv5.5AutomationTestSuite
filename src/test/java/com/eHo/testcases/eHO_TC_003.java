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

public class eHO_TC_003 extends BaseTest {
	//Scenario 3: A record level ‘Deny’ policy with domain specific, operator not equals will be created 
	
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_003Test()
	{
		try
		{
		test=rep.startTest("TC_003Test");
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
		
		recordLevelPolicyDetailPage.setPolicyDescription("Record level domain specific ,Operator Not equals,Deny policy");
		
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Not Equal");
	
		recordLevelPolicyDetailPage.selectDomainType("CDR");
		
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		
		recordLevelPolicyDetailPage.selectRecordType();
		
		recordLevelPolicyDetailPage.setRecordText("Sample");
	
		recordLevelPolicyDetailPage.clickSave();
		
		String expectedMessage="Policy was saved successfully.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		
		 actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();	
		 expectedMessage="Record level domain specific ,Operator Not equals,Deny policy";			
		 
		 softAssert.assertEquals(expectedMessage, actualMessage);
	
		
		//revoking the policy 
		recordLevelPolicyDetailPage.clickPolicy();
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
	
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickCloseMessageBox();
		System.out.println("Passed TC _003");
		
			
		
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
