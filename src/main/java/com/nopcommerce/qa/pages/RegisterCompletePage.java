package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class RegisterCompletePage extends BaseClass{
	private RegisterCompletePage() {
		
	}

	public static RegisterCompletePage registerCompletePage;
	public static RegisterCompletePage getRegisterCompletePage() {
		return (registerCompletePage==null) ? registerCompletePage= new RegisterCompletePage(): registerCompletePage;
	}

	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='result']")
	private WebElement registerCompleteMessage;
	
	public void clicksOnContinueButton() {
		clicksOnWebElement(continueButton);
	}
	
	public String getRegisterComplectedText() {
		return getTextFromTheElement(registerCompleteMessage);
	}
	
	public Boolean displayedRegisterComplectedText() {
		return elementIsDisplayed(registerCompleteMessage);
	}
}
