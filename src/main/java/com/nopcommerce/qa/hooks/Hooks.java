package com.nopcommerce.qa.hooks;

import com.nopcommerce.libglobal.BaseClass;
import com.nopcommerce.qa.pommanager.PomManager;
import com.nopcommerce.qa.webdriver_manager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{

	@Before
	public void beforeScenario() {
		try {
				DriverManager.initializeBrowserAndLandApplication(prop.getProperty("browser"));
				PomManager.initWebElement();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public void afterScenario() {

		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().quit();
		
	}

}
