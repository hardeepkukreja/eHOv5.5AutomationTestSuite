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
import com.eHo.pageobjects.GlobalPage;
import com.eHo.pageobjects.HicAgentsPage;
import com.eHo.pageobjects.HicRecordsPage;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.RecordLevelPolicyDetailPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_017 extends BaseTest{
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_0017Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_0017 Test");
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
		// record level policy 
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny");  
		recordLevelPolicyDetailPage.setPolicyDescription("Record Level, domain specific, operator equals Policy");
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
		recordLevelPolicyDetailPage.selectDomainType("CDR");
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		recordLevelPolicyDetailPage.selectRecordType();
		recordLevelPolicyDetailPage.setRecordText("ABC");
		recordLevelPolicyDetailPage.clickSave();
		
		String expectedMessage="Policy was saved successfully.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		//checking if the policy is created 

		 actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
		 expectedMessage="Record Level, domain specific, operator equals Policy";
		
		 softAssert.assertEquals(expectedMessage, actualMessage);
		 // agent  level -2
		 test=rep.startTest("Agent Level Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow of Agent level policy creation ");
			AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
			AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
			clientPolicies.clickNewDirective();
			clientPolicies.clickAgent();
			agentPolicyDetailPage.selectDirectiveOutcome("Deny");
			agentPolicyDetailPage.setPolicyDescription("Agent Domain specified , operator Equals, Deny Policy");
			agentPolicyDetailPage.clickAdd();
			agentSelectPage.clickManualEntry();
			agentSelectPage.setID("2.16.840.1.113883.3.239.18.14410003977");
			agentSelectPage.clickReturnSelected();
			agentPolicyDetailPage.clickSave();
			
			String expectedMessage1="Policy was saved successfully.";
			String actualMessage1=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
			softAssert.assertEquals(expectedMessage1, actualMessage1);
			agentPolicyDetailPage.clickBack();
			actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:1:j_id_6l']")).getText();
			 expectedMessage="Agent Domain specified , operator Equals, Deny Policy";			
			 softAssert.assertEquals(expectedMessage, actualMessage);
				
			 
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	//HIC Agent level 
					HicAgentsPage hicAgentsPage= new HicAgentsPage(driver);			
					clientPolicies.clickNewDirective();
					clientPolicies.clickHICAgents();
					hicAgentsPage.selectDirectiveOutcome("Deny");
					hicAgentsPage.setPolicyDescription("HIC-Agent Domain specified, operator Not Equals, Deny Policy");
					hicAgentsPage.selectCustodiansExclude();
					hicAgentsPage.clickAddCustodian();
					hicAgentsPage.txtOrganisationNameValue("Toronto");
					hicAgentsPage.txtMuncipalityValue("Toronto");
					hicAgentsPage.clickSearch();
					hicAgentsPage.clickSelectedCity();
					hicAgentsPage.clickReturnValue();
			     	hicAgentsPage.clickSave();
					//hicAgentsPage.clickForceSave();
					String expectedMessage2="Policy was saved successfully.";
					String actualMessage2=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();				
					softAssert.assertEquals(expectedMessage2, actualMessage2);
					hicAgentsPage.clickBack();
					actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:2:j_id_6l']")).getText();
					expectedMessage="HIC-Agent Domain specified, operator Not Equals, Deny Policy";			
					softAssert.assertEquals(expectedMessage, actualMessage);
		
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
		
	// hic records agent
	   HicRecordsPage hicRecordsPage=new HicRecordsPage(driver);
		clientPolicies.clickNewDirective();
		clientPolicies.clickHICRecords();
		hicRecordsPage.selectDirectiveOutcome("Deny");
		hicRecordsPage.setPolicyDescription("Record Domain specified , operator Not Equals, Deny Policy");
		hicRecordsPage.clickDomainAll();
		hicRecordsPage.selectCustodiansExclude();
		hicRecordsPage.selectCustodians("HIC Source 1");
		hicRecordsPage.clickSave();
		String expectedMessage4="Policy was saved successfully.";
		String actualMessage4=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage4, actualMessage4);
		hicRecordsPage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:3:j_id_6l']")).getText();
		 expectedMessage="Record Domain specified , operator Not Equals, Deny Policy";			
		 softAssert.assertEquals(expectedMessage, actualMessage);

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	// Global level 
						
		GlobalPage globalpage= new GlobalPage(driver);

		clientPolicies.clickNewDirective();
		clientPolicies.clickGlobal();
		globalpage.selectDirectiveOutcome("Deny");
		globalpage.setPolicyDescription("Global Domain specified,deny Policy");
		globalpage.clickDomainAll();
		globalpage.clickSave();
	
		expectedMessage="Policy was saved successfully.";
		actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		globalpage.clickBack();
	
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:4:j_id_6l']")).getText();
		expectedMessage="Global Domain specified,deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		

		//***********use array for storing values **** a[0][1]= 1 && a[0][1] = record level 	
						
		
		
		//String order;
		String expected_Text;
		String actual_Text;
		
		expected_Text= "Record Level" ;
		actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
		System.out.println(expected_Text);
		System.out.println(actual_Text);
		
		softAssert.assertEquals(expected_Text, actual_Text);	
		driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
			
		//revoking  first policy 
				
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickCloseMessageBox();
		System.out.println("record level revoked");	
		recordLevelPolicyDetailPage.clickBack();
		
		// revoking second 
		
		
		expected_Text= "Agent" ;
		
		actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
		System.out.println(expected_Text);
		System.out.println(actual_Text);
		softAssert.assertEquals(expected_Text, actual_Text);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickCloseMessageBox();
		System.out.println("Agent level revoked");	
		recordLevelPolicyDetailPage.clickBack();
	
		
		// revoking third 
		
		
expected_Text= "HIC-Agents" ;
		
		actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
		System.out.println(expected_Text);
		System.out.println(actual_Text);
		
		softAssert.assertEquals(expected_Text, actual_Text);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
				recordLevelPolicyDetailPage.clickRevoke();
				recordLevelPolicyDetailPage.clickYesConfirmation();
				expectedMessage="Policy was revoked successfully.";
				actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				softAssert.assertEquals(expectedMessage, actualMessage);
				recordLevelPolicyDetailPage.clickCloseMessageBox();
				System.out.println("HIC-Agents level revoked");	
				recordLevelPolicyDetailPage.clickBack();
				
		
				// revoking fourth 
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				expected_Text= "HIC-Records";
				
				actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
				System.out.println(expected_Text);
				System.out.println(actual_Text);
				softAssert.assertEquals(expected_Text, actual_Text);
				
				
				driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
				recordLevelPolicyDetailPage.clickRevoke();
				recordLevelPolicyDetailPage.clickYesConfirmation();
				expectedMessage="Policy was revoked successfully.";
				actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				softAssert.assertEquals(expectedMessage, actualMessage);
				recordLevelPolicyDetailPage.clickCloseMessageBox();
				System.out.println("HIC-Records level revoked");	
				recordLevelPolicyDetailPage.clickBack();
				
		
				// revoking fifth 
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
expected_Text= "Global";
				
				actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
				System.out.println(expected_Text);
				System.out.println(actual_Text);
				softAssert.assertEquals(expected_Text, actual_Text);
				
				
				driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
				recordLevelPolicyDetailPage.clickRevoke();
				recordLevelPolicyDetailPage.clickYesConfirmation();
				expectedMessage="Policy was revoked successfully.";
				actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				softAssert.assertEquals(expectedMessage, actualMessage);
				recordLevelPolicyDetailPage.clickCloseMessageBox();
				System.out.println("Global level revoked");	
				recordLevelPolicyDetailPage.clickBack();
				
		
				
				
	
	/*	order= driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[1]")).getText();
		 if(order=="1")
		{
			 System.out.println(order); 		 
				
			expected_Text= "Record Level" ;
			actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[1]/td[3]")).getText();
			softAssert.assertEquals(expected_Text, actual_Text);		
		}
		order= driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[2]/td[1]")).getText();	
		 if (order=="2")
		{
			 System.out.println(order); 		 
				
			expected_Text= "Agent" ;
			actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[2]/td[3]")).getText();
			softAssert.assertEquals(expected_Text, actual_Text);	
		}
		
		 order= driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[3]/td[1]")).getText();
		 if(order=="3") 
		{
			 System.out.println(order); 		 
				
			 expected_Text= "HIC-Agents" ;
			 actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[3]/td[3]")).getText();
		softAssert.assertEquals(expected_Text, actual_Text);	
			
		}
		
		 order= driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[4]/td[1]")).getText();
		 if(order=="4")
		{
			 System.out.println(order); 		 
				
			 expected_Text= "HIC-Records" ;
			 actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[4]/td[3]")).getText();
		softAssert.assertEquals(expected_Text, actual_Text);	
			
		}
		
		 
		 order= driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[5]/td[1]")).getText();
		 if(order=="5")
		{
			 System.out.println(order); 		 
			 expected_Text= "Global" ;
			 actual_Text=driver.findElement(By.xpath(".//*[@id='resultData']/tbody/tr[5]/td[3]")).getText();
			 softAssert.assertEquals(expected_Text, actual_Text);	
			
		}
		
		 for(int i=0;i<=5;i++)
		 {
			driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).click();		
			globalpage.clickRevoke();
			globalpage.clickYesConfirmation();
			//String expectedMessage="Policy was revoked successfully.";
		//	String	actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();			
			softAssert.assertEquals(expectedMessage, actualMessage);
			globalpage.clickCloseMessageBox();	
			
			System.out.println("inside for loop");
		 }
		 */
	
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
