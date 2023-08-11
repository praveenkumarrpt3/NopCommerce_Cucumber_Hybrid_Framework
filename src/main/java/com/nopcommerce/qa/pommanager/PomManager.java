package com.nopcommerce.qa.pommanager;

import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.qa.pages.CartPage;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.HomePage;
import com.nopcommerce.qa.pages.LoginPage;
import com.nopcommerce.qa.pages.Manufactures_Apple_Page;
import com.nopcommerce.qa.pages.MyAccountPage;
import com.nopcommerce.qa.pages.RegisterCompletePage;
import com.nopcommerce.qa.pages.RegisterPage;
import com.nopcommerce.qa.pages.SearchPage;
import com.nopcommerce.qa.webdriver_manager.DriverManager;

public class PomManager {

	public static void initWebElement() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getLoginPage());
		PageFactory.initElements(DriverManager.getDriver(), MyAccountPage.getMyAccountPage());
		PageFactory.initElements(DriverManager.getDriver(), HeaderPage.getHeaderPage());
		PageFactory.initElements(DriverManager.getDriver(), CartPage.getCartPage());
		PageFactory.initElements(DriverManager.getDriver(), RegisterPage.getRegisterPage());
		PageFactory.initElements(DriverManager.getDriver(), RegisterCompletePage.getRegisterCompletePage());
		PageFactory.initElements(DriverManager.getDriver(), SearchPage.getSearchPage());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomePage());
		PageFactory.initElements(DriverManager.getDriver(), Manufactures_Apple_Page.getManufactures_Apple_Page());
	}

}
