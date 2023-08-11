package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class SearchPage extends BaseClass{

	private SearchPage() {

	}

	public static SearchPage searchPage;
	public  static SearchPage getSearchPage() {
		return (searchPage==null) ? searchPage= new SearchPage():searchPage;
	}


	@FindBy(xpath="//div[contains(@class,'search-result')]")
	private WebElement found_search_result;

	@FindBy(xpath="//div[contains(@class,'no-result')]")
	private WebElement no_search_result;


	@FindBy(xpath="//a[contains(@href,'apple')]")
	private WebElement AppleManufactures;


	public boolean displayedSearchResult() {
		return elementIsDisplayed(found_search_result);
	}

	public boolean displayedNoSearchResult() {
		return elementIsDisplayed(no_search_result);
	}

	public void clicksOnAppleOnManufactures() {
	
		clicksOnWebElement(AppleManufactures);
	}



}
