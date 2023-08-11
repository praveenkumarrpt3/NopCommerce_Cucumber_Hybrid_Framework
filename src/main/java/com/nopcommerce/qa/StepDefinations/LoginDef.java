package com.nopcommerce.qa.StepDefinations;

import org.junit.Assert;

import com.nopcommerce.libglobal.BaseClass;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.LoginPage;
import com.nopcommerce.qa.pages.MyAccountPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDef extends BaseClass{


	@When("User should be logged in with valid {string} and valid {string}")
	public void user_should_be_logged_in_with_valid_and_valid(String emailText, String password) {
		LoginPage.getLoginPage().entersEmailText(emailText);
		LoginPage.getLoginPage().entersPasswordText(password);

	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		LoginPage.getLoginPage().clicksOnLoginButton();	
	}
	@Then("User should navigate to My account page")
	public void user_should_navigate_to_my_account_page() {
	Assert.assertTrue(HeaderPage.getHeaderPage().displayedMyaccount());
	}
	
	
	@When("^User should be logged in with  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userShouldBeLoggedInWithAnd(String invalid_email, String invalid_password) throws Throwable {
		LoginPage.getLoginPage().entersEmailText(invalid_email);
		LoginPage.getLoginPage().entersPasswordText(invalid_password);
	}
	
	@Then("^User validate the proper warning message for both invalid credentials$")
	public void userValidateTheProperWarningMessageForBothInvalidCredentials() throws Throwable {
		Assert.assertEquals(LoginPage.getLoginPage().getNocustomerAccountWarningMessage(), dataProp.getProperty("no_account_found_warning"));
	}
	
	
	@When("^User should be logged in with valid username and invalid password \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userShouldBeLoggedInWithValidUsernameAndInvalidPasswordAnd(String valid_email, String invalid_password) throws Throwable {
		LoginPage.getLoginPage().entersEmailText(valid_email);
		LoginPage.getLoginPage().entersPasswordText(invalid_password);
	}
	
	@Then("^User validate the proper warning message for valid username and invalid password$")
	public void userValidateTheProperWarningMessageForValidUsernameAndInvalidPassword() throws Throwable {
		Assert.assertEquals(LoginPage.getLoginPage().getInvalidCredentialsWarningMessage(), dataProp.getProperty("valid_account_invalid_password_warning"));
	}
	
	@When("^User should be logged in with invalid username and valid password \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userShouldBeLoggedInWithInvalidUsernameAndValidPasswordAnd(String invalid_email, String valid_password) throws Throwable {
		LoginPage.getLoginPage().entersEmailText(invalid_email);
		LoginPage.getLoginPage().entersPasswordText(valid_password);
	}
	
	
	@Then("^User validate the proper warning message for invalid username and valid password$")
	public void userValidateTheProperWarningMessageForInvalidUsernameAndValidPassword() throws Throwable {
		Assert.assertEquals(LoginPage.getLoginPage().getNocustomerAccountWarningMessage(), dataProp.getProperty("no_account_found_warning"));
		}

	@When("User should not be enter any credentials in text fields")
	public void user_should_not_be_enter_any_credentials_in_text_fields() {
		LoginPage.getLoginPage().entersEmailText("");
		LoginPage.getLoginPage().entersPasswordText("");
		
	}
	@Then("User validate the proper warning message for without enters any credentials")
	public void user_validate_the_proper_warning_message_for_without_enters_any_credentials() {
	  Assert.assertEquals(LoginPage.getLoginPage().getEmptyEmailTextErrorMessage(), dataProp.getProperty("empty_email_warning"));
	}


}
