package com.nopcommerce.qa.pages;

import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

	private MyAccountPage() {
		
	}
	
	public static MyAccountPage myAccountPage;
	public static MyAccountPage getMyAccountPage() {
		return (myAccountPage ==null) ? myAccountPage= new MyAccountPage():myAccountPage;
	}
	
	
}
