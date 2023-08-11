package com.nopcommerce.qa.pages;

public class CartPage {
	public static CartPage cartPage;
	private CartPage() {
	}
	public static CartPage getCartPage() {
		return (cartPage==null) ? cartPage = new CartPage() :cartPage;
	}

}
