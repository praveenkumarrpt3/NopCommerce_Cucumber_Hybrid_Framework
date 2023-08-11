package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class LoginPage extends BaseClass{
	public static LoginPage loginPage;

	private LoginPage() {
	}

	public static LoginPage getLoginPage() {
		return (loginPage ==null) ? loginPage= new LoginPage():loginPage;
	}

	@FindBy(id="Email")
	private WebElement email;


	@FindBy(id="Password")
	private WebElement Password;

	@FindBy(xpath="//button[text()='Log in']")
	private WebElement login_button;


	@FindBy(id="RememberMe")
	private WebElement remember_me_check_box;

	@FindBy(linkText="Forgot password?")
	private WebElement forgot_password;

	@FindBy(linkText="Register")
	private WebElement new_customer_register;

	@FindBy(xpath="//form[@method='post']//div[contains(text(),'unsuccessful')]")
	private WebElement login_unsuccessful;

	@FindBy(xpath="//form[@method='post']//div[contains(text(),'unsuccessful')]//li")
	private WebElement invalid_credentials;


	@FindBy(xpath="//form[@method='post']//div[contains(text(),'unsuccessful')]//li")
	private WebElement no_customer_account;

	@FindBy(id="Email-error")
	private WebElement wrong_email;

	@FindBy(id="Email-error")
	private WebElement empty_email;

	public void entersEmailText(String emailText) {
		sendByTextValue(email, emailText);
	}

	public void entersPasswordText(String passwordText) {
		sendByTextValue(Password, passwordText);
	}

	public void clicksOnRememberMe() {
		clicksOnWebElement(remember_me_check_box);
	}

	public void clicksOnLoginButton() {
		clicksOnWebElement(login_button);
	}

	public void clicksOnForgotPasswordAndNavigatePage() {
		clicksOnWebElement(forgot_password);
	}

	public void clicksOnRegisterForNewCustomer() {
		clicksOnWebElement(new_customer_register);
	}

	public String getLoginUnsucessfullWarningMessage() {
		return getTextFromTheElement(login_unsuccessful);
	}

	public String getWrongEmailErrorMessage() {
		return getTextFromTheElement(wrong_email);
	}
	public String getEmptyEmailTextErrorMessage() {
		return getTextFromTheElement(empty_email);
	}

	public String getNocustomerAccountWarningMessage() {
		return	getTextFromTheElement(no_customer_account);
	}
	public String getInvalidCredentialsWarningMessage() {
		return getTextFromTheElement(invalid_credentials);
	}

}
