package com.saucelabs.saucedemo.steps;

import org.junit.Assert;

import com.saucelabs.saucedemo.pages.POMFactory;
import com.saucelabs.saucedemo.utilities.CommonUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonUtility {
	
	private POMFactory pom = new POMFactory();
	private String loginPageUrl = getUrl();
	
	@Given("User is on Login Page of Swag Labs Application")
	public void userIsOnLoginPageOfSwagLabsApplication() {
		String actualTitle = getPageTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertTrue(pom.getLoginPage().isLoginLogoPrecent());
		logger.info("User is on Swag Labs Application");
	}
	@When("User enters username as {string} and password as {string}")
	public void userEntersUsernameAsAndPasswordAs(String username, String password) {
		pom.getLoginPage().enterUserName(username);
		pom.getLoginPage().enterPassword(password);
		logger.info("user entered username and password");
	}
	@When("User clicks on the Login button")
	public void userClicksOnTheLoginButton() {
		pom.getLoginPage().clickLoginButton();
		logger.info("user clicked on the Login button");
	}
	@Then("User should be logged into the Application")
	public void userShouldBeLoggedIntoTheApplication() {
		Assert.assertFalse("User is on Login Page", loginPageUrl.equals(getUrl()));
		Assert.assertTrue(pom.getProductsPage().isAppLogoPresent());
		Assert.assertTrue(pom.getProductsPage().isMenuButtonPresent());
		Assert.assertTrue(pom.getProductsPage().isShoppingIconPresent());
		logger.info("user is logged into Application");
	}
	
	@Then("User should see an error message for missing username")
	public void userShouldSeeAnErrorMessageForMissingUsername() {
	    Assert.assertTrue(pom.getLoginPage().isUsernameIsRequiredMsgPrecent());
	    logger.info("The error message for missing usernam is displaed");
	}
	
	@Then("User should see an error message for missing password")
	public void userShouldSeeAnErrorMessageForMissingPassword() {
		Assert.assertTrue(pom.getLoginPage().isPasswordIsRequiredMsgPrecent());
	    logger.info("The error message for missing password is displaed");
	}
	
	@Then("User should see an error message for username and password mismatch")
	public void userShouldSeeAnErrorMessageForUsernameAndPasswordMismatch() {
		Assert.assertTrue(pom.getLoginPage().isUsernameAndPasswordDoNotMatchMsgPrecent());
	    logger.info("The error message for username and password mismatch is displaed");
	}



}
