package com.saucelabs.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

public class LoginPage extends BaseSetup {

	private CommonUtility util;
	
	@FindBy(xpath ="//div[text()='Swag Labs']") 
	private WebElement loginLogo;
	
	@FindBy(className = "login-box") 
	private WebElement loginForm;
	
	@FindBy(id ="user-name") 
	private WebElement userNameField;
	
	@FindBy(id ="password") 
	private WebElement passwordField;
	
	@FindBy(id ="login-button") 
	private WebElement loginButton;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username is required']")
	private WebElement usernameIsRequiredMsg;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Password is required']")
	private WebElement passwordIsRequiredMsg;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	private WebElement usernameAndPasswordDoNotMatchMsg;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		this.util = new CommonUtility();
	}
	
	public boolean isLoginLogoPrecent() {
		String expectedClass = "login_logo";
		return expectedClass.equals(util.getElementAttribute(loginLogo, "class"));
    }
	
	public void enterUserName(String username) {
        util.sendText(userNameField, username);
    }

    public void enterPassword(String password) {
        util.sendText(passwordField, password);
    }
    
    public void clickLoginButton() {
        util.clickElement(loginButton);
    }
    
    public boolean isUsernameIsRequiredMsgPrecent() {
    	String expectedMsg = "Epic sadface: Username is required";
		util.waitTillPresence(usernameIsRequiredMsg);
		return expectedMsg.equals(util.getElementText(usernameIsRequiredMsg));
    }
    
    public boolean isPasswordIsRequiredMsgPrecent() {
    	String expectedMsg = "Epic sadface: Password is required";
		util.waitTillPresence(passwordIsRequiredMsg);
		return expectedMsg.equals(util.getElementText(passwordIsRequiredMsg));
    }
    
    public boolean isUsernameAndPasswordDoNotMatchMsgPrecent() {
    	String expectedMsg = "Epic sadface: Username and password do not match any user in this service";
		util.waitTillPresence(usernameAndPasswordDoNotMatchMsg);
		return expectedMsg.equals(util.getElementText(usernameAndPasswordDoNotMatchMsg));
    }
    
    public boolean isLoginFormPrecent() {
		return util.isElementDisplayed(loginForm);
    }

}
