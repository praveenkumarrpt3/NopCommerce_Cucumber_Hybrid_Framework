package com.nopcommerce.qa.StepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.nopcommerce.libglobal.BaseClass;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.RegisterCompletePage;
import com.nopcommerce.qa.pages.RegisterPage;
import com.nopcommerce.qa.utilities.Utilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterDef extends BaseClass{


	@Given("Navigate to Register page")
	public void navigate_to_register_page() {
		HeaderPage.getHeaderPage().clickOnAndNavigateToRegisterPage();
	}
	@When("User should clicks on male radio button")
	public void user_should_clicks_on_male_radio_button() {
		RegisterPage.getRegisterPage().clickOnMaleRadioButton();
	}

	@And("^enters all the fields mentioned below  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enters_all_the_fields_mentioned_below(String firstname, String lastname, String email, String companyname, String password, String confirm_password) {
		RegisterPage.getRegisterPage().entersOnFirstName(firstname);
		RegisterPage.getRegisterPage().entersOnLastName(lastname);
		RegisterPage.getRegisterPage().entersEmail(Utilities.generateMaildByGetTimeStamp());
		RegisterPage.getRegisterPage().entersCompanyName(companyname);
		RegisterPage.getRegisterPage().entersPassword(password);
		RegisterPage.getRegisterPage().entersConfirmPassword(confirm_password);
	}


	@And("^select the day, month and year in date of birth dropdown  \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"$")
	public void select_the_day_month_and_year_in_date_of_birth_dropdown(String day, String month, String year) {
		RegisterPage.getRegisterPage().selectDate(day);
		RegisterPage.getRegisterPage().selectMonth(month);
		RegisterPage.getRegisterPage().selectYear(year);
	}
	@When("clicks on Newsletter")
	public void clicks_on_newsletter() {
		//		RegisterPage.getRegisterPage().clicksOnNewsLetter();
	}
	@When("User clicks on REGISTER button")
	public void user_clicks_on_register_button() {
		RegisterPage.getRegisterPage().clickOnRegisterButton();
	}
	@Then("User should navigate to Register complete page")
	public void user_should_navigate_to_register_complete_page() {
		assertEquals(RegisterCompletePage.getRegisterCompletePage().getRegisterComplectedText(), dataProp.getProperty("register_complete"));	
		assertTrue(RegisterCompletePage.getRegisterCompletePage().displayedRegisterComplectedText());

	}

	@When("^User should enters Manatory fields mentioned below  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void userShouldEntersManatoryFieldsMentionedBelow(String firstname, String lastname, String email, String password,
			String confrim_password) throws Throwable {
		RegisterPage.getRegisterPage().entersOnFirstName(firstname);
		RegisterPage.getRegisterPage().entersOnLastName(lastname);
		RegisterPage.getRegisterPage().entersEmail(Utilities.generateMaildByGetTimeStamp());
		RegisterPage.getRegisterPage().entersPassword(password);
		RegisterPage.getRegisterPage().entersConfirmPassword(confrim_password);
	}

	@Then("^User should got the proper warning message$")
	public void userShouldGotTheProperWarningMessage() throws Throwable {

		assertEquals(RegisterPage.getRegisterPage().getLastNameWariningMessage(), dataProp.getProperty("last_name_warning_message"));
		assertEquals((RegisterPage.getRegisterPage().getFirstNameWariningMessage()), dataProp.getProperty("first_name_warning_message"));
		assertEquals(RegisterPage.getRegisterPage().getLastNameWariningMessage(), dataProp.getProperty("last_name_warning_message"));
		assertEquals(RegisterPage.getRegisterPage().getEmailWarningMessage(), dataProp.getProperty("email_warning_message"));
		assertEquals(RegisterPage.getRegisterPage().getPasswordWarningMessage(), dataProp.getProperty("password_warning_message"));
		assertEquals(RegisterPage.getRegisterPage().getConfirmPasswordWarningMessage(), dataProp.getProperty("confirm_password_warning_message"));

	}


	@When("^User should enters Manatory fields with duplicate mail mentioned below  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void userShouldEntersManatoryFieldsWithDuplicateMailMentionedBelow(String firstname, String lastname, String email,
			String password, String confrim_password) throws Throwable {
		RegisterPage.getRegisterPage().entersOnFirstName(firstname);
		RegisterPage.getRegisterPage().entersOnLastName(lastname);
		RegisterPage.getRegisterPage().entersEmail(email);
		RegisterPage.getRegisterPage().entersPassword(password);
		RegisterPage.getRegisterPage().entersConfirmPassword(confrim_password);		
	}

	@Then("^User should validate the duplicate email warning messgae$")
	public void userShouldValidateTheDuplicateEmailWarningMessgae() throws Throwable {
		String emailAlreadyExistsWarningMessage = RegisterPage.getRegisterPage().getEmailAlreadyExistsWarningMessage();

		assertEquals(emailAlreadyExistsWarningMessage, dataProp.getProperty("email_already_exists"));

	}
}
