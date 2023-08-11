package com.nopcommerce.qa.StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.libglobal.BaseClass;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.LoginPage;
import com.nopcommerce.qa.pages.Manufactures_Apple_Page;
import com.nopcommerce.qa.pages.SearchPage;
import com.nopcommerce.qa.utilities.Utilities;
import com.nopcommerce.qa.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class SearchDef extends BaseClass {
	WebDriver driver;

	@Given("User should be landing in the application url")
	public void user_should_be_landing_in_the_application_url() {
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().get(prop.getProperty("url"));
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Utilities.IMPLICITY_WAIT, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Utilities.PAGE_OUT_TIME_OUT, TimeUnit.SECONDS);
	}

	@Given("Navigate to login page")
	public void navigate_to_login_page() {
		HeaderPage.getHeaderPage().clickOnAndNagivateToLoginPage();
	}

	@When("User should be logged in with valid credential")
	public void user_should_be_logged_in_with_valid_credential() {

		LoginPage.getLoginPage().entersEmailText("praveenvlr3@gmail.com");
		LoginPage.getLoginPage().entersPasswordText("12345");
		LoginPage.getLoginPage().clicksOnLoginButton();
	}

	@When("Search with valid product")
	public void search_with_valid_product() {
		HeaderPage.getHeaderPage().enterSearchStore("phone");
		HeaderPage.getHeaderPage().clicksOnSearchButton();
	}

	@When("scroll down the page and select a manufacturer")
	public void scroll_down_the_page_and_select_a_manufacturer() {
	
		SearchPage.getSearchPage().clicksOnAppleOnManufactures();
	}

	@When("User should open a product in a new tab")
	public void user_should_open_a_product_in_a_new_tab() {
		Manufactures_Apple_Page.getManufactures_Apple_Page().open_New_Tab_A_Product_Apple_Icam();
	}

	@Then("User should validate the similar product list as searched")
	public void user_should_validate_the_similar_product_list_as_searched() {


		System.out.println(" similiar product validation");
	}

	@When("Search with invalid product")
	public void search_with_invalid_product() {
		HeaderPage.getHeaderPage().enterSearchStore("bike");
		HeaderPage.getHeaderPage().clicksOnSearchButton();
	}

	@Then("User should validate the error message")
	public void user_should_validate_the_error_message() {
		System.out.println("No product found");
	}

	@When("Search with empty search bar")
	public void search_with_empty_search_bar() {
		HeaderPage.getHeaderPage().clicksOnSearchButton();
		HeaderPage.getHeaderPage().isAlertIsPresent();
		HeaderPage.getHeaderPage().handle_Alert_Accept();

	}


}
