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
import com.eHo.pageobjects.HicAgentsPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_013 extends BaseTest{

	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	@Test
	public void TC_013Test()
	{
		try
		{
			test=rep.startTest("TC_013Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow of HIC Agent level policy creation ");
			openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
			navigate("appURL");//to navigate to the application
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
			test.log(LogStatus.INFO, "Clicked submit button");
			NavigationPage navigationPage=new NavigationPage(driver);
			ClientSearchPage clientSearch=new ClientSearchPage(driver);
			ClientPolicies clientPolicies=new ClientPolicies(driver);
	HicAgentsPage hicAgentsPage= new HicAgentsPage(driver);		
	
			navigationPage.clickConsent();
			navigationPage.clickManagement();
			clientSearch.setID(prop.getProperty("id"));
			test.log(LogStatus.INFO, "Searching Id");
			clientSearch.clickSearch();
			clientSearch.clickClientName();
			clientPolicies.clickNewDirective();
			
			clientPolicies.clickHICAgents();
			hicAgentsPage.selectDirectiveOutcome("Allow");
			hicAgentsPage.setPolicyDescription("HIC-Agent Domain specified, operator Not Equals, Allow Policy");
			hicAgentsPage.selectCustodiansExclude();
			hicAgentsPage.clickAddCustodian();
			hicAgentsPage.txtOrganisationNameValue("Toronto");
			hicAgentsPage.txtMuncipalityValue("Toronto");
			
			hicAgentsPage.clickSearch();
			hicAgentsPage.clickSelectedCity();
			hicAgentsPage.clickReturnValue();
		
			hicAgentsPage.clickSave();
			String expectedMessage="Policy was saved successfully.";
			String actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		
			
			softAssert.assertEquals(expectedMessage, actualMessage);
			hicAgentsPage.clickBack();
			actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
			 expectedMessage="HIC-Agent Domain specified, operator Not Equals, Allow Policy";			
			 softAssert.assertEquals(expectedMessage, actualMessage);
			 hicAgentsPage.clickPolicy();
			 hicAgentsPage.clickRevoke();
			 hicAgentsPage.clickYesConfirmation();
			expectedMessage="Policy was revoked successfully.";
			actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();			
			softAssert.assertEquals(expectedMessage, actualMessage);
			hicAgentsPage.clickCloseMessageBox();
			System.out.println("Testcase 13- passed");
			
		
		
		
			
			
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
