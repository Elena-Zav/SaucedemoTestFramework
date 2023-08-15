package com.saucelabs.saucedemo.steps;

import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutSteps extends CommonUtility {

	private POMFactory pom = new POMFactory();

	@When("User clicks on the Logout link")
	public void userClicksOnTheLogoutLink() {
		pom.getProductsPage().clickMenuButton();
		pom.getProductsPage().clickLogOutLink();
		logger.info("User clicked on the Logout link");
	}

	@Then("User should be on Login Page of Swag Labs Application")
	public void userShouldBeOnLoginPageOfSwagLabsApplication() {
		Assert.assertTrue("The Login Form is not displayed", pom.getLoginPage().isLoginFormPrecent());
		Assert.assertEquals("Unexcpected URL", "https://www.saucedemo.com/", getUrl());
		logger.info("User is on Login Page of Swag Labs Application");
	}

}
