package com.saucelabs.saucedemo.utilities;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucelabs.saucedemo.base.BaseSetup;

public class CommonUtility extends BaseSetup {

	private WebDriverWait wait;

	private WebDriverWait getWait() {
		if (wait == null) {
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
		}
		return wait;
	}

	public WebElement waitTillClickable(WebElement element) {
		return getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitTillPresence(WebElement element) {
		return getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public Boolean waitTillInvisibile(WebElement element) {
		return getWait().until(ExpectedConditions.invisibilityOf(element));
	}

	public Boolean waitTillUrlToBe(String url) {
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public String getUrl() {
		return getDriver().getCurrentUrl();
	}

	public void clickElement(WebElement element) {
		this.waitTillClickable(element).click();
	}

	public void sendText(WebElement element, String value) {
		this.waitTillPresence(element).sendKeys(value);
	}

	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}

	public String getElementAttribute(WebElement element, String value) {
		return this.waitTillPresence(element).getAttribute(value);
	}

	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public String getPageTitle() {
		return getDriver().getTitle();
	}

	public void clearField(WebElement element) {
		waitTillPresence(element).clear();
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to check if element is displayed: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementSelected(WebElement element) {
		try {
			return element.isSelected();
		} catch (Exception e) {
			logger.error("Failed to check if element is selected: " + e.getMessage());
			return false;
		}
	}

}