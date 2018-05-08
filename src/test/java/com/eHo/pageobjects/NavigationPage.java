package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {
	public static WebDriver driver;
	
	@FindBy(id="appMenu:j_id_e")
	WebElement homeMenu;
	
	@FindBy(id="appMenu:j_id_j")
	WebElement consentMenu;
	
	@FindBy(id="appMenu:j_id_m")
	WebElement managementMenu;
	
	@FindBy(id="appMenu:j_id_s")
	WebElement systemDirectivesMenu;
	
	@FindBy(id="appMenu:j_id_w")
	WebElement resolvePCRChangesMenu;
	
	@FindBy(id="appMenu:j_id_y")
	WebElement policyReconcilationMenu;
	
	@FindBy(id="appMenu:j_id_10")
	WebElement internalClientSearchMenu;
	
	@FindBy(id="appMenu:j_id_15")
	WebElement reportMenu;
	
	@FindBy(id="appMenu:j_id_18")
	WebElement policyReportsMenu;
	
	@FindBy(id="appMenu:j_id_1a")
	WebElement auditReportsMenu;
	

	@FindBy(xpath=".//*[@id='appMenu:j_id_1c']")
	WebElement scheduledReportsMenu;

	
	
	@FindBy(xpath="//*[@id='applicationMenu']/li[7]/a/div[2]")
	WebElement helpMenu;
	
	@FindBy(id="appMenu:j_id_4g")
	WebElement logoutMenu;
	
	
	@FindBy(id="appMenu:j_id_1g")
	WebElement auditRepository;
	
	@FindBy(id="appMenu:j_id_1j")
	WebElement securityAlert;
	
	@FindBy(id="appMenu:j_id_1p")
	WebElement administration;
	
	@FindBy(id="appMenu:j_id_22")
	WebElement listMaintainance; 
	

	@FindBy(id="appMenu:j_id_26")
	WebElement consentList; 
	
	@FindBy(id="appMenu:j_id_28")
	WebElement purposeOfUse; 
	
	

	
	
	public NavigationPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickConsent()
	{
		Actions act = new Actions(driver);
		act.moveToElement(consentMenu).build().perform();
		
	}
	
	public void clickManagement()
	{
		managementMenu.click();
	}
	
	public void clickSystemDirectives()
	{
		systemDirectivesMenu.click();
	}
	
	public void clickResolvePCRChanges()
	{
		Actions act = new Actions(driver);
		act.moveToElement(resolvePCRChangesMenu).build().perform();
	}
	
	public void clickPolicyReconcilation()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(policyReconcilationMenu).build().perform();
	}
	
	public void clickInternalClientSearch()
	{
		Actions act = new Actions(driver);
		act.moveToElement(policyReconcilationMenu).build().perform();
		internalClientSearchMenu.click();
	}
	
	public void clickReport()
	{
		Actions act = new Actions(driver);
		act.moveToElement(reportMenu).build().perform();
	}
	
	public void clickPolicyReports()
	{
		policyReportsMenu.click();
	}
	
	public void clickAuditReports()
	{
		auditReportsMenu.click();
	}
	
	public void clickScheduledReports()
	{
		scheduledReportsMenu.click();
	}
	
	public void clickHelp()
	{
		helpMenu.click();
	}
	public void clickLogout()
	{
		logoutMenu.click();
	}


	public void clickAuditRepository()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(auditRepository).build().perform();	
	}

	public void clickSecurityAlert()
	{
			securityAlert.click();
	}
	
	public void clickAdministration()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(administration).build().perform();	
	}
	
	
	public void clickListMaintainance()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(listMaintainance).build().perform();	
	}
	public void clickConsentList()
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(consentList).build().perform();	
	}
	
	public void clickPurposeOfUse()
	{
		
		purposeOfUse.click();
		// Actions act = new Actions(driver);
	//	act.moveToElement(purposeOfUse).build().perform();	
	}

	
	
	
}
