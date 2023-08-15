package com.saucelabs.saucedemo.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps extends CommonUtility {

	private POMFactory pom = new POMFactory();
	private int countItemsOnTheProductPage = pom.getProductsPage().getProducts().size();

	@Then("User is on Products Page of Swag Labs Application")
	public void userIsOnProductsPageOfSwagLabsApplication() {
		Assert.assertTrue(pom.getProductsPage().isProductsTitlePresent());
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getUrl());
		logger.info("User is on Products Page of Swag Labs Application");
	}

	@When("User adds all products to the cart")
	public void userAddsAllProductsToTheCart() {
		pom.getProductsPage().clickAddToCartAllPageProducts();
		logger.info("User added all products to the cart");
	}

	@Then("The cart displays the badge count of all page products")
	public void theCartDisplaysAnUpdatedBadgeCount() {
		int actualBageCount = 0;
		if (pom.getProductsPage().isCartBadgePresent()) {
			actualBageCount = pom.getProductsPage().getCartBadgeCount();
		}
		Assert.assertTrue("Bage Count do not mutch with the number of pruducts on Product Page",
				actualBageCount == pom.getProductsPage().getProducts().size());
		logger.info("The cart displayed the badge count of " + actualBageCount);
	}

	@Then("Cart Page shows all Product Page items")
	public void cartPageShowsAllProductPageItems() {
		pom.getProductsPage().clickShoppingIcon();
		Assert.assertTrue(
				"The Cart items are " + pom.getCartPage().getCartItems().size()
						+ " do not mutch with the number of pruducts on Product Page " + countItemsOnTheProductPage,
				countItemsOnTheProductPage == pom.getCartPage().getCartItems().size());
		logger.info("Cart Page showed " + pom.getCartPage().getCartItems().size() + " Product Page items");
	}

	@When("User clicks on the Continue Shopping button to go back to the Product Page")
	public void userClicksOnTheContinueShoppingButtonToGoBackToTheProductPage() {
		pom.getCartPage().clickContinueShoppingBtn();
		logger.info("User clicked on the Continue Shopping button to go back to the Product Page");
	}

	@When("User removes all products from the cart")
	public void userRemovesAllProductsFromTheCart() {
		pom.getProductsPage().clickRemoveFromCartAllPageProducts();
		logger.info("User removed all products from the cart");
	}

	@Then("The cart does not display the badge")
	public void theCartDoesNotDisplayTheBadge() {
		Assert.assertFalse(pom.getProductsPage().isCartBadgePresent());
		logger.info("The cart does not display the badge");
	}

	@Then("Cart Page shows {int} Product Page items")
	public void cartPageShowsProductPageItems(int num) {
		pom.getProductsPage().clickShoppingIcon();
		Assert.assertEquals(
				"The Cart items are " + pom.getCartPage().getCartItems().size()
						+ " do not mutch with the excpected number of pruducts in The Cart " + num,
				num, pom.getCartPage().getCartItems().size());
		logger.info("Cart Page shows " + pom.getCartPage().getCartItems().size() + " Product Page items");
	}

	@When("User selects {string} from the sorting options")
	public void userSelectsFromTheSortingOptions(String option) {
		pom.getProductsPage().sortProducts(option);
		logger.info("User selected " + option + " from the sorting options");
	}

	@Then("Products should be displayed in alphabetical order")
	public void productsShouldBeDisplayedInAlphabeticalOrder() {
		Assert.assertTrue("The products is not sorted alphabeticaly",
				pom.getProductsPage().isListAlphabeticallySorted());
		logger.info("Products are displayed in alphabetical order");
	}

	@Then("Products should be displayed in ascending order based on their prices")
	public void productsShouldBeDisplayedInAscendingOrderBasedOnTheirPrices() {
		Assert.assertTrue("The products is not sorted in ascending order based on their prices",
				pom.getProductsPage().isListSortedByPrice());
		logger.info("Products are displayed in ascending order based on their prices");
	}

	@When("User clicks on the {string} of Product {int}")
	public void userClicksOnTheElementOfProduct(String element, int productNumber) {
		if (element.equals("name")) {
			pom.getProductsPage().clickProductTitle(productNumber);
		} else {
			pom.getProductsPage().clickProductImage(productNumber);
		}
		logger.info("User clicked on the " + element + " of Product " + productNumber);
	}

	@Then("User should be redirected to Product Detail Page for Product {int}")
	public void userShouldBeRedirectedToProductDetailPageForProduct(int productNumber) {
		Assert.assertTrue("The elements of Product Detail Page do not present",
				pom.getProductsPage().isProductDetailDescriptionPresent());
		Assert.assertTrue("The elements of Product Detail Page do not present",
				pom.getProductsPage().isbackToProductsBtnPresent());
		logger.info("User should be redirected to Product Detail Page for Product " + productNumber);
	}

}
