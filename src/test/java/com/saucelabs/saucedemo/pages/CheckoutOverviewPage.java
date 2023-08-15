package com.saucelabs.saucedemo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

public class CheckoutOverviewPage extends BaseSetup {

	private static final double EPSILON = 0.01;

	private CommonUtility util;
	private List<Double> checkoutItemPrices = new ArrayList<>();
	private Double checkoutItemTotal = 0.0;

	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	private WebElement checkoutOverviewTitle;

	@FindBy(className = "summary_subtotal_label")
	private WebElement itemTotal;

	@FindBy(className = "inventory_item_price")
	private List<WebElement> itemPrices;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	@FindBy(className = "complete-header")
	private WebElement thankYouForYourOrderMsg;

	public CheckoutOverviewPage() {
		PageFactory.initElements(getDriver(), this);
		this.util = new CommonUtility();
	}

	/**
	 * Check if the Checkout Overview title is present.
	 * 
	 * @return true if present, false otherwise.
	 */
	public boolean isCheckoutOverviewTitlePresent() {
		return util.isElementDisplayed(checkoutOverviewTitle);
	}

	private double extractItemPrice(String priceText) {
		String sanitizedPrice = priceText.replaceAll("[^\\d. ]", "").replace(" ", "");
		return Double.parseDouble(sanitizedPrice);
	}

	private void initializeItemPrices() {
		checkoutItemPrices = itemPrices.stream().map(element -> extractItemPrice(util.getElementText(element)))
				.collect(Collectors.toList());
	}

	private void initializeCheckoutItemTotal() {
		checkoutItemTotal = extractItemPrice(util.getElementText(itemTotal));
	}

	private boolean checkItemTotalIsCorrect() {
		double sumOfPrices = checkoutItemPrices.stream().mapToDouble(Double::doubleValue).sum();
		return Math.abs(checkoutItemTotal - sumOfPrices) < EPSILON;
	}

	/**
	 * Verifies if the displayed item total is correct by comparing it with the sum
	 * of individual product prices.
	 * 
	 * @return true if correct, false otherwise.
	 */
	public boolean verifyItemTotalIsCorrect() {
		initializeItemPrices();
		initializeCheckoutItemTotal();
		return checkItemTotalIsCorrect();
	}

	public void clickFinisButton() {
		util.clickElement(finishBtn);
	}

	public boolean isThankYouForYourOrderMsgPresent() {
		return util.isElementDisplayed(thankYouForYourOrderMsg);
	}
}
