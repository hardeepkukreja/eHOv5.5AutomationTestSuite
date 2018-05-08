package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPolicies {
	
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='policiesResult']/div[2]/div/input")
	WebElement btnNewDirective;
	
	@FindBy(id="policiesResult:j_id_6x:0:j_id_6z")
	WebElement recordLevel;
	
	@FindBy(id="policiesResult:j_id_6x:1:j_id_6z")
	WebElement agent;
	
	@FindBy(id="policiesResult:j_id_6x:2:j_id_6z")
	WebElement hicAgents;
	
	@FindBy(id="policiesResult:j_id_6x:3:j_id_6z")
	WebElement hicRecords;
	
	@FindBy(id="policiesResult:j_id_6x:4:j_id_6z")
	WebElement global;
	
	@FindBy(id="policiesResult:j_id_74")
	WebElement btnBack;
			
	@FindBy(id="detail:j_id_4y")
	WebElement policyListTab;
	
	
	
	public ClientPolicies(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d,this);
	}
	
	
	public void clickNewDirective()
	{
		btnNewDirective.click();
	}
	
	public void clickRecordLevel()
	{
		recordLevel.click();
	}
	
	public void clickAgent()
	{
		agent.click();
	}
	
	public void clickHICAgents()
	{
		hicAgents.click();
	}
	
	public void clickHICRecords()
	{
		hicRecords.click();
	}
	
	public void clickGlobal()
	{
		global.click();
	}
	
	public void clickBack()
	{
		btnBack.click();
	}

	public void clickPolicyListTab()
	{
		policyListTab.click();
	}

}

