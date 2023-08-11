package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class HomePage extends BaseClass {
	public static HomePage homePage;
	private HomePage() {

	}	
	public static HomePage getHomePage() {
		return ((homePage==null)? homePage=new HomePage():homePage);

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
		clicksOnWebElement(loginOption);
	}

	public void clickOnAndNavigateToRegisterPage() {
		clicksOnWebElement(registerOption);
	}

	public void clickOnAndNavigateToWishlistPage() {
		clicksOnWebElement(wishListOption);
	}

	public void clickOnAndNavigateToShoppingCartPage() {
		clicksOnWebElement(shopCartOption);
		shopCartOption.click();
	}

	public void enterSearchStore(String productName) {
		sendByTextValue(searchBox, productName);
	}

	public void clicksOnSearchButton() {
		clicksOnWebElement(searchButton);
	}
}
