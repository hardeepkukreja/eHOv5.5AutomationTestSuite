package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurposeOfUsePage {
	public static WebDriver driver;
	 @FindBy(xpath=".//*[@id='listResult']/tbody/tr[1]/td[1]")
	 WebElement codeTextBox;
	
	 @FindBy(xpath="//input[@maxlength='255']")
	 WebElement description;

	 @FindBy(xpath="//input[@alt='edit-save']")
	 WebElement btnSave;
	
	
	 
	 
	 public PurposeOfUsePage(WebDriver d)
		{
			driver=d;
			PageFactory.initElements(d, this);
		}
		
	 
	 public void setCode(String value)
		{
		 codeTextBox.sendKeys(value);
		}
	 public void setDescription(String value)
	 {
		 description.sendKeys(value);
	 }
	 public void clickSave()
	 {
		 btnSave.click(); 
	 }


	
	 
	 
}



