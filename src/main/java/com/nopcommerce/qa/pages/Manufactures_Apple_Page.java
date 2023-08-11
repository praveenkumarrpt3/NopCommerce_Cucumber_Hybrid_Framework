package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nopcommerce.libglobal.BaseClass;

public class Manufactures_Apple_Page extends BaseClass{

	private Manufactures_Apple_Page() {

	}
	public static Manufactures_Apple_Page applePage;

	public static Manufactures_Apple_Page getManufactures_Apple_Page() {

		return (applePage==null)? applePage= new Manufactures_Apple_Page():applePage;
	}

	@FindBy(linkText="Apple iCam")
	private WebElement appleIcamProduct;


	public void open_New_Tab_A_Product_Apple_Icam() {
		open_New_Tab_for_any_elemnent(appleIcamProduct);
	}

}


