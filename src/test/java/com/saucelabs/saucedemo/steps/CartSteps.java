package com.saucelabs.saucedemo.steps;

import org.junit.Assert;
import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends CommonUtility {

	private POMFactory pom = new POMFactory();

	@Given("User has {int} items in the cart")
	public void userHasItemsInTheCart(int initial_count) {
		int badgeCount = pom.getProductsPage().getCartBadgeCount();
		int actualCartItemsCount = pom.getCartPage().getCartItems().size();
		Assert.assertEquals("Expected " + initial_count + " items in the cart, but found " + actualCartItemsCount,
				initial_count, actualCartItemsCount);
		Assert.assertEquals(
				"Badge count of " + badgeCount + " does not match expected " + initial_count + " items in the cart",
				initial_count, badgeCount);
		logger.info("User has " + initial_count + " items in the cart");
	}

	@When("User removes all items from the cart one by one")
	public void userRemovesAllItemsFromTheCartOneByOne() {
		while (!pom.getCartPage().isCartEmpty()) {
			String removedProductName = pom.getCartPage().removeFirstItemAndGetItsName();
			Assert.assertFalse(removedProductName + " is still in the cart.",
					pom.getCartPage().isProductNameInCart(removedProductName));
		}
		logger.info("User removed all items from the cart one by one");
	}

	@Then("The cart should be empty and the badge count should disappear")
	public void the_cart_should_be_empty_and_the_badge_count_should_disappear() {
		Assert.assertEquals("The cart is not empty", 0, pom.getCartPage().getCartItems().size());
		Assert.assertFalse("The cart badge is presented", pom.getProductsPage().isCartBadgePresent());
		logger.info("The cart is empty and the badge disappeared");
	}

}