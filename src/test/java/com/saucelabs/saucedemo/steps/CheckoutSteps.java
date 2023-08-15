package com.saucelabs.saucedemo.steps;

import org.junit.Assert;

import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CommonUtility {

	private POMFactory pom = new POMFactory();

	@Then("User clicks on the Checkout button")
	public void userClicksOnTheCheckoutButton() {
		pom.getCartPage().clickCheckoutBtn();
		logger.info("User clicked on the Checkout button");
	}

	@Given("User is on Checkout Information Page of Swag Labs Application")
	public void userIsOnCheckoutInformationPageOfSwagLabsApplication() {
		Assert.assertTrue(pom.getCheckoutPage().isCheckoutYourInformationTitlePresent());
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", getUrl());
		logger.info("User is on Checkout Information Page of Swag Labs Application");
	}

	@When("User enters First Name as {string}")
	public void userEntersFirstNameAs(String firstName) {
		pom.getCheckoutPage().enterFirstName(firstName);
		logger.info("User entered First Name as " + firstName);
	}

	@When("User enters Last Name as {string}")
	public void userEntersLastNameAs(String lastName) {
		pom.getCheckoutPage().enterLastName(lastName);
		logger.info("User entered Last Name as " + lastName);
	}

	@When("User enters postal code as {string}")
	public void userEntersPostalCodeAs(String postalCode) {
		pom.getCheckoutPage().enterPostalCode(postalCode);
		logger.info("User entered postal code as " + postalCode);
	}

	@When("User clicks on the Continue button")
	public void userClicksOnTheContinueButton() {
		pom.getCheckoutPage().clickContinueButton();
		logger.info("User clicked on the Continue button");
	}

	@Then("User should see an error message {string}")
	public void userShouldSeeAnErrorMessage(String errorMessage) {
		Assert.assertTrue(pom.getCheckoutPage().checkErrorMessage(errorMessage));
		logger.info("User sees an error message: " + errorMessage);
	}
	
	@Then("User should be on the Checkout Overview Page of Swag Labs Application")
	public void userShouldBeOnTheCheckoutOverviewPageOfSwagLabsApplication() {
		Assert.assertTrue(pom.getCheckoutOverviewPage().isCheckoutOverviewTitlePresent());
		Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", getUrl());
		logger.info("User is on Checkout Information Page of Swag Labs Application");
	}

}
