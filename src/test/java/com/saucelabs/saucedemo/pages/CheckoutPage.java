package com.saucelabs.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

public class CheckoutPage extends BaseSetup {

	private CommonUtility util;
	
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	private WebElement checkoutYourInformationTitle;
	
	@FindBy(id = "first-name")
	private WebElement firstNameField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeField;
	
	@FindBy(id = "continue")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
		this.util = new CommonUtility();
	}
	
	public boolean isCheckoutYourInformationTitlePresent() {
		return util.isElementDisplayed(checkoutYourInformationTitle);
	}
	
	public void enterFirstName(String firstName) {
        util.sendText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        util.sendText(lastNameField, lastName);
    }
    
    public void enterPostalCode(String postalCode) {
        util.sendText(postalCodeField, postalCode);
    }
    
    public void clickContinueButton() {
        util.clickElement(continueBtn);
    }
    
    public boolean checkErrorMessage(String message) {
        return message.equals(util.getElementText(errorMessage));
    }
}
