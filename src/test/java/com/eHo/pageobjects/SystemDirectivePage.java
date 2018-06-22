package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemDirectivePage {
	public static WebDriver driver;

	
	@FindBy(xpath=".//*[@id='activeResult']/div[2]/div/input")
	WebElement btnNewDirective;
	
	
	@FindBy(xpath=".//*[@id='activeResult:j_id_79']")
	WebElement btnAdvanced;
	
	
	@FindBy(id="detail:cdTitle")
	WebElement txtDirectiveTitle;
	
	@FindBy(id="detail:saveBtn")
	WebElement btnSave;
	
	
	@FindBy(xpath=".//*[@id='mustExecuteRadio']/label[1]/span")
	WebElement executeFirstNo;
	
	@FindBy(xpath=".//*[@id='mustExecuteRadio']/label[2]/span")
	WebElement executeFirstYes;
	
	@FindBy(id="save-comment")
	WebElement txtSaveComment;
	
	@FindBy(id="save-comment-btn-continue")
	WebElement btnSaveContinue;
	
	@FindBy(id="detail:cancelSystemBtn2")
	WebElement btnBack;
	
	@FindBy(id="detail:j_id_9h")
	WebElement btnRevoke;
	
	
	@FindBy(xpath=".//*[@id='activeResult:j_id_6r:0:j_id_6t']")
	WebElement ActiveDirective; // active directive 
	
	
	@FindBy(id="activeResult:j_id_5z:0:j_id_61")
	WebElement clickActiveSD;
//	.//*[@id='activeResult:j_id_5z:0:j_id_61']
	
	@FindBy(id="revoke-comment-btn-continue")
	WebElement btnRevokeContinue;
	
	@FindBy(id="detail:reopenBtn")
	WebElement btnRopen;
	
	
	
	
	public SystemDirectivePage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickBtnNewDirective()
	{
		btnNewDirective.click();
	}
	
	public void clickBtnAdvanced()
	{
		btnAdvanced.click();
	}
	
	public void setTxtDirectiveTitle(String value)
	{
		txtDirectiveTitle.clear();
		txtDirectiveTitle.sendKeys(value);
	}
	public void clickBtnSave()
	{
		btnSave.click();
	}
	public void setTxtSaveComment(String value)
	{
		txtSaveComment.clear();
		txtSaveComment.sendKeys(value);
	}
	
	public void clickBtnSaveContinue()
	{
		btnSaveContinue.click();
	}
	
	
	public void clickBtnBack()
	{
		btnBack.click();
	}
	
	
	public void clickBtnRevoke()
	{
		btnRevoke.click();
	}
	
	public void clickActiveDirective()
	{
		ActiveDirective.click();
	}
	public void clickActiveSD()
	{
		clickActiveSD.click();
	}
	
	public void clickBtnRevokeContinue()
	{
		btnRevokeContinue.click();
	}

	public void ClickExecuteFirstYes()
	{
		
		executeFirstYes.click();
	}
	
	public void ClickExecuteFirstNo()
	{
		
		executeFirstNo.click();
	}
	
	
	
	public void clickBtnRopen()
	{
		btnRopen.click();
	}
	
	
}
