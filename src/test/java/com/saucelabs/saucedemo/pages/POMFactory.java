package com.saucelabs.saucedemo.pages;

import com.saucelabs.saucedemo.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private LoginPage loginPage;
	private ProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private CheckoutOverviewPage checkoutOverviewPage;

	public POMFactory() {
		this.loginPage = new LoginPage();
		this.productsPage = new ProductsPage();
		this.cartPage = new CartPage();
		this.checkoutPage = new CheckoutPage();
		this.checkoutOverviewPage = new CheckoutOverviewPage();
		    }
	
	public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
    
    public CheckoutOverviewPage getCheckoutOverviewPage() {
        return checkoutOverviewPage;
    }
}





