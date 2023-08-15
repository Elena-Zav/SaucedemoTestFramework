package com.saucelabs.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

public class CartPage extends BaseSetup {

	private CommonUtility util;

	@FindBy(className = "cart_item")
	private List<WebElement> cartItems;

	@FindBy(className = "inventory_item_name")
	private List<WebElement> cartProductTitles;

	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	public CartPage() {
		PageFactory.initElements(getDriver(), this);
		this.util = new CommonUtility();
	}

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public List<WebElement> getCartProductTitles() {
		return cartProductTitles;
	}

	public void clickContinueShoppingBtn() {
		util.clickElement(continueShoppingBtn);
	}
	
	public void clickCheckoutBtn() {
		util.clickElement(checkoutBtn);
	}

	public String removeFirstItemAndGetItsName() {
		String productName = null;
		if (!cartItems.isEmpty()) {
			productName = util.getElementText(cartItems.get(0).findElement(By.className("inventory_item_name")));
			util.clickElement(cartItems.get(0).findElement(By.xpath(".//button[text()='Remove']")));
		} else {
			logger.warn("Cart is empty.");
		}
		return productName;
	}

	public boolean isProductNameInCart(String productName) {
		for (WebElement item : getCartProductTitles()) {
			if (item.getText().contains(productName)) {
				return true;
			}
		}
		return false;
	}

	public boolean isCartEmpty() {
		return cartItems.isEmpty();
	}

}
