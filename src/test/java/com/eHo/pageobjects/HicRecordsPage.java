package com.eHo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HicRecordsPage {
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
	WebElement dropDomainValue;
	
	@FindBy(id="detail:domainList")
	WebElement dropDomainType;
	
	
	@FindBy(xpath=".//*[@id='detail:hicRecordEqualOrNotEqual2']")
	WebElement dropCustodiansValue;
	
	
	@FindBy(xpath="//*[@id='domainRadio']/label[2]/span")
	WebElement domainSpecify;
	
	
	@FindBy(xpath=".//*[@id='detail:domainList']")
	WebElement domainDropDown;
	
	@FindBy(id="detail:saveBtn")
	WebElement btnSave;
	
	@FindBy(id="detail:j_id_9y")
	WebElement btnCancel;
	
	@FindBy(id="detail:j_id_a0")
	WebElement btnBack;
	

	@FindBy(xpath="//*[@id='domainRadio']/label[1]/span")
	WebElement domainAll;
	
	@FindBy(id="detail:j_id_9d")
	WebElement btnAddCustodian;
	
	
	
	@FindBy(id="detail:j_id_9p")
	WebElement btnRevoke;
			
	@FindBy(id="policiesResult:j_id_6j:0:j_id_6l")
	WebElement btnActivePolicy;
	
					
	@FindBy(xpath="html/body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")
	WebElement btnYesConfirmation;
	
	@FindBy(xpath="html/body/div[6]/div[1]/button")
	WebElement btnCloseMessage;
	
	@FindBy(xpath=".//*[@id='detail:hicRecordEqualOrNotEqual2']")
	WebElement dropCustodian;
	
	

	@FindBy(id="detail:hicRecordList")
	WebElement dropCustodianList;
	
	
	
	public HicRecordsPage(WebDriver d)
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
		
	public void selectDomainEqual()
	{
		Select drop=new Select(dropDomainValue);
		drop.selectByIndex(0);	
	}
	
	public void selectDomainNotEqual()
	{
		Select drop=new Select(dropDomainValue); // notequal
		drop.selectByIndex(1);	
	}
	
	
	public void selectDomainType(String value)
	{
		Select drop=new Select(dropDomainType);
		drop.selectByVisibleText(value);
	}
	
	
	
	
	public void clickSave()
	{
		
		btnSave.click(); 
		
		
		
	}
	
	public void clickCancel()
	{
	btnSave.click();
	}
	
	public void clickBack()
	{
		btnBack.click();
	}
	
	public void clickDomainAll()
	{
		domainAll.click();
	}
	
	public void clickDomainSpecify()
	{
		domainSpecify.click();
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
		try { btnYesConfirmation.click(); }
		catch(Exception e) {
		driver.findElement(By.xpath("html/body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")).click();
		}
	}
	
	public void clickCloseMessageBox()
	{
		btnCloseMessage.click();
	}
	
	public void selectCustodiansNotEqual()
	{
		Select drop=new Select(dropCustodiansValue); // 
		drop.selectByIndex(1);	
	}
	
	public void selectCustodiansEqual()
	{
		Select drop=new Select(dropCustodiansValue); // 
		drop.selectByIndex(0);	
	}
	public void selectCustodians(String value)
	{
		Select drop=new Select(dropCustodianList); // 
		
		try{
			drop.selectByValue(value);
		}
		catch (Exception ex)
		{
			drop.selectByIndex(1);
		}
	}
	
	
	
	public void selectDomainDD(String Value)
	{
		Select drop = new Select(domainDropDown); 
		drop.selectByVisibleText(Value);
	}
	
	

}
