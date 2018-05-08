package com.eHo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HicAgentsPage {
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
	
	
	@FindBy(xpath=".//*[@id='hicAgentSelectDiv']/select[1]")
	WebElement dropCustodiansValue;
	
	
	
	@FindBy(xpath=".//*[@id='detail:saveBtn']")
	WebElement btnSave1;
	
	@FindBy(id="detail:j_id_9y")
	WebElement btnCancel;
	
	@FindBy(id="detail:j_id_a0")
	WebElement btnBack;
	
	@FindBy(xpath="//*[@id='domainRadio']/label[2]/span")
	WebElement domainSpecify;
	
	
	@FindBy(xpath=".//*[@id='detail:domainList']")
	WebElement domainDropDown;
	
	@FindBy(id="detail:j_id_92")
	WebElement btnAdd;

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
	
	
	@FindBy(xpath=".//*[@id='detail:forceSaveBtn']")
	WebElement btnForceSave;
	
	
// provider organisation select 
	
	@FindBy(id="criteria:name3")
	WebElement txtOrganisationName;
	
	@FindBy(id="criteria:addrCity3")
	WebElement txtMuncipality;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch;
	
	@FindBy(xpath=".//*[@id='resultData']/tbody/tr/td[1]/div/label")
	WebElement selectedCity;
	
	@FindBy(id="result:returnBtn")
	WebElement btnSelectedReturn;
	
	
	
	public HicAgentsPage(WebDriver d)
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
		try{
		btnSave1.click(); 
		}
		catch(Exception ex)
		{ 
				
		btnForceSave.click();
		}
	
	}
		public void clickForceSave()
		{
			btnForceSave.click();
		}
		
	
	public void clickCancel()
	{
	btnCancel.click();
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
	
	public void selectDomainDD(String Value)
	{
		Select drop = new Select(domainDropDown); 
		drop.selectByVisibleText(Value);
	}

	public void clickAdd()
	{
		btnAdd.click();
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
		//btnYesConfirmation.click();
		driver.findElement(By.xpath("html/body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")).click();
		
	}
	
	public void clickCloseMessageBox()
	{
		btnCloseMessage.click();
	}
	
	
	public void selectCustodiansInclude()
	{
		Select drop=new Select(dropCustodiansValue); // 
		drop.selectByIndex(2);	
	}
	
	public void selectCustodiansExclude()
	{
		Select drop=new Select(dropCustodiansValue); // 
		drop.selectByIndex(1);	
	}


	public void clickAddCustodian()
	{
		btnAddCustodian.click();
		
	}
	public void txtOrganisationNameValue(String value)
	{
		txtOrganisationName.sendKeys(value);
	}
	
	
	
	public void txtMuncipalityValue(String value)
	{
		
		txtMuncipality.sendKeys(value);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}

	public void clickSelectedCity()
	{
		selectedCity.click();
	}
	public void clickReturnValue()
	{
		btnSelectedReturn.click();
	}
	
	
}
