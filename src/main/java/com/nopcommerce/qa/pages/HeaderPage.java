package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class HeaderPage extends BaseClass{

	private HeaderPage() {

	}
	public static HeaderPage headerPage;

	public static HeaderPage getHeaderPage() {

		return (headerPage==null)? headerPage= new HeaderPage():headerPage;
	}

	@FindBy(linkText="My account")
	private WebElement my_Account;

	public Boolean displayedMyaccount() {
		return elementIsDisplayed(my_Account);
	}

	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(xpath="//a[text()='Log in']")
	private WebElement loginOption;

	@FindBy(xpath="//span[text()='Wishlist']")
	private WebElement wishListOption;

	@FindBy(id="small-searchterms")
	private WebElement searchBox;

	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;

	@FindBy(partialLinkText="cart")
	private WebElement shopCartOption;


	public void clickOnAndNagivateToLoginPage() {
		//		clicksOnWebElement(loginOption);
		loginOption.click();
	}

	public void clickOnAndNavigateToRegisterPage() {
		clicksOnWebElement(registerOption);
	}

	public void clickOnAndNavigateToWishlistPage() {
		clicksOnWebElement(wishListOption);
	}

	public void clickOnAndNavigateToShoppingCartPage() {
		clicksOnWebElement(shopCartOption);
	}

	public void enterSearchStore(String productName) {
		sendByTextValue(searchBox, productName);
	}

	public void clicksOnSearchButton() {
		clicksOnWebElement(searchButton);
	}
}


