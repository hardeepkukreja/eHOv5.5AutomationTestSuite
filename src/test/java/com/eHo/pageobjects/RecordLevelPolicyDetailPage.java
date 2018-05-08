package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RecordLevelPolicyDetailPage {
	
	public WebDriver driver;
	
	@FindBy(id="detail:outcome")
	WebElement directiveOutcome;
	
	@FindBy(id="detail:description")
	WebElement policyDescription;
	
	@FindBy(xpath="//*[@id='initByRadio']/label[2]")
	WebElement btnSubstituteDecisionMaker;
	
	@FindBy(id="detail:consenterName")
	WebElement txtSDMakerFullName;
	
	@FindBy(id="detail:consenterRole")
	WebElement txtSDMakerRelationship;
	
	@FindBy(xpath="//*[@id='pouRadio']/label[2]")
	WebElement btnPOUSpecify;
	
	@FindBy(id="detail:domainEqualOrNotEqual2")
	WebElement dropDomainEqual;
	
	@FindBy(id="detail:domainList")
	WebElement dropDomainType;
	
	@FindBy(id="detail:recordEqualOrNotEqual2")
	WebElement dropRecordEqual;
	
	@FindBy(id="detail:recordList")
	WebElement dropRecordType;
	
	@FindBy(id="detail:recordText")
	WebElement recordTxt;
	
	@FindBy(id="detail:saveBtn")
	WebElement btnSave;
	
	@FindBy(id="detail:j_id_9y")
	WebElement btnCancel;
	
	@FindBy(id="detail:j_id_a0")
	WebElement btnBack;
	
	
	@FindBy(id="detail:j_id_9p")
	WebElement btnRevoke;
		
	
	@FindBy(id="policiesResult:j_id_6j:0:j_id_6l")
	WebElement btnActivePolicy;
	
	@FindBy(xpath="html/body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")
	WebElement btnYesConfirmation;
	
	@FindBy(xpath="html/body/div[6]/div[2]/div/div/div/div")
	WebElement windowConfirmation;
	
	@FindBy(xpath="html/body/div[6]/div[1]/button")
	WebElement btnCloseMessage;
	
	@FindBy(id="detail:forceSaveBtn")
	WebElement btnForceSave;
			
	@FindBy(id="detail:j_id_a0")
	WebElement btnBackRevoke;
	
	
	public RecordLevelPolicyDetailPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickPOUSpecify()
	{
		btnPOUSpecify.click();
	}
	public void setRelationship(String relation)
	{
		txtSDMakerRelationship.sendKeys(relation);
	}
	
	public void setFullName(String name)
	{
		txtSDMakerFullName.sendKeys(name);
	}
	
	
	public void clickSubDecisionMaker()
	{
		btnSubstituteDecisionMaker.click();
	}
	public void selectDirectiveOutcome(String value)
	{
		Select drop=new Select(directiveOutcome);
		drop.selectByVisibleText(value);
	}
	
	public void setPolicyDescription(String value)
	{
		policyDescription.clear();
		policyDescription.sendKeys(value);
	}
	
	public void selectDomainEqualNotEqual(String value)
	{
		Select drop=new Select(dropDomainEqual);
		drop.selectByVisibleText(value);
	}
	
	public void selectDomainType(String value)
	{
		Select drop=new Select(dropDomainType);
		
		try{
			//drop.selectByIndex(1);
			drop.selectByVisibleText(value);
			} 
		catch (Exception e)
		{
			System.out.println("failed to assign Domain");
		}
	}
	
	public void selectRecordEqualOrNot(String value)
	{
		Select drop=new Select(dropRecordEqual);
		drop.selectByVisibleText(value);
	}
	
	public void selectRecordType()
	{
		Select drop=new Select(dropRecordType);
		try{		
			drop.selectByIndex(1);
			}
		catch(Exception e) 
		{
			System.out.println(" Record Type failure");
		}
	}
	
	public void setRecordText(String value)
	{
		recordTxt.clear();
		recordTxt.sendKeys(value);
	}
	
	public void clickSave()
	{
		
		btnSave.click();
	
		
	}
	
	public void clickCancel()
	{
		btnCancel.click();  
	}
	
	public void clickBack()
	{
		btnBack.click();
	}
	public void clickPolicy()
	{
		btnActivePolicy.click();
	}
	public void clickRevoke() 
	{
		
		btnRevoke.click();	
	}
	public void clickYesConfirmation()
	{
		windowConfirmation.click();
		btnYesConfirmation.click();
	}
	
	public void clickCloseMessageBox()
	{
		btnCloseMessage.click();
	}
	
	
	public void clickbtnForceSave()
	{
		btnForceSave.click();
	}
	
	public void clickbtnBackRevoke()
	{
		btnBackRevoke.click();
	}
	
	
	
	
}
