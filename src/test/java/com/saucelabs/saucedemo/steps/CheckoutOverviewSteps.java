package com.saucelabs.saucedemo.steps;

import org.junit.Assert;
import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps extends CommonUtility {

	private POMFactory pom = new POMFactory();
	private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-two.html";

	@Given("User is on Checkout Overview Page of Swag Labs Application")
	public void userIsOnCheckoutOverviewPageOfSwagLabsApplication() {
		Assert.assertTrue("Expected Checkout Overview Page title is not presented",
				pom.getCheckoutOverviewPage().isCheckoutOverviewTitlePresent());
		Assert.assertEquals("Unexpected URL", CHECKOUT_URL, getUrl());
		logger.info("User is on Checkout Overview Page of Swag Labs Application");
	}

	@Then("The displayed Item Total amount is correct for the selected products")
	public void theDisplayedItemTotalAmountIsCorrectForTheSelectedProducts() {
		Assert.assertTrue("Displayed item total amount does not match the sum of individual products",
				pom.getCheckoutOverviewPage().verifyItemTotalIsCorrect());
		logger.info("The displayed Item Total amount is correct for the selected products");
	}

	@When("User clicks on the Finish button")
	public void userClicksOnTheFinishButton() {
		pom.getCheckoutOverviewPage().clickFinisButton();
		logger.info("User clicked on the Finish button");
	}

	@Then("User should see a confirmation message that order has been placed")
	public void userShouldSeeAConfirmationMessageThatOrderHasBeenPlaced() {
		Assert.assertTrue("The confirmation message is not presented",
				pom.getCheckoutOverviewPage().isThankYouForYourOrderMsgPresent());
		logger.info("The Order Confirmation message is displayed");
	}

	@Then("User should be on the Order Completion page")
	public void userShouldBeOnTheOrderCompletionPage() {
		Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", getUrl());
		logger.info("User is on the Order Completion page");
	}

}