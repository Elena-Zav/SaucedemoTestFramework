package com.saucelabs.saucedemo.pages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

public class ProductsPage extends BaseSetup {

	private CommonUtility util;
	private List<Double> prices;

	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuButton;

	@FindBy(xpath = "//div[text()='Swag Labs']")
	private WebElement appLogo;

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingIcon;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logOutLink;

	@FindBy(xpath = "//span[text()='Products']")
	private WebElement productsTitle;

	@FindBy(className = "inventory_list")
	private WebElement productList;

	@FindBy(className = "inventory_item")
	private List<WebElement> products;

	@FindBy(className = "inventory_item_name")
	private List<WebElement> productTitles;

	@FindBy(className = "inventory_item_price")
	private List<WebElement> productPrices;

	@FindBy(xpath = "//div[@class='inventory_item_img']")
	private List<WebElement> productImages;

	@FindBy(className = "shopping_cart_badge")
	private List<WebElement> cartBadge;

	@FindBy(className = "product_sort_container")
	private WebElement productSortList;

	@FindBy(id = "inventory_item_container")
	private WebElement productDetailDescription;

	@FindBy(id = "back-to-products")
	private WebElement backToProductsBtn;

	public ProductsPage() {
		PageFactory.initElements(getDriver(), this);
		this.util = new CommonUtility();
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public boolean isMenuButtonPresent() {
		return util.isElementDisplayed(menuButton);
	}

	public boolean isAppLogoPresent() {
		String expectedClass = "app_logo";
		return expectedClass.equals(util.getElementAttribute(appLogo, "class"));
	}

	public boolean isShoppingIconPresent() {
		return util.isElementDisplayed(shoppingIcon);
	}

	public boolean isProductsTitlePresent() {
		return util.isElementDisplayed(productsTitle);
	}

	public boolean isCartBadgePresent() {
		return !cartBadge.isEmpty();
	}

	public int getCartBadgeCount() {
		String num = util.getElementText(cartBadge.get(0));
		int badgeCount = Integer.parseInt(num);
		return badgeCount;
	}

	public void clickAddToCart(int numberProductOnThePage) {
		util.clickElement(products.get(numberProductOnThePage)
				.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")));
	}

	public void clickAddToCartAllPageProducts() {
		for (WebElement product : products) {
			util.clickElement(product.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")));
		}
	}

	public void clickRemoveFromCart(int numberProductOnThePage) {
		util.clickElement(
				products.get(numberProductOnThePage).findElement(By.xpath("//button[contains(text(), 'Remove')]")));
	}

	public void clickRemoveFromCartAllPageProducts() {
		for (WebElement product : products) {
			util.clickElement(product.findElement(By.xpath("//button[contains(text(), 'Remove')]")));
		}

	}

	public void clickShoppingIcon() {
		util.clickElement(shoppingIcon);
	}

	public void clickMenuButton() {
		util.clickElement(menuButton);
	}

	public void clickLogOutLink() {
		util.clickElement(logOutLink);
	}

	public void sortProducts(String option) {
		util.selectByVisibleText(productSortList, option);
	}

	public boolean isListAlphabeticallySorted() {
		List<String> productNames = productTitles.stream().map(WebElement::getText).collect(Collectors.toList());

		return IntStream.range(0, productNames.size() - 1)
				.allMatch(i -> productNames.get(i).compareTo(productNames.get(i + 1)) <= 0);
	}

	private double extractPrice(String priceText) {
		String sanitizedPrice = priceText.replaceAll("[^\\d. ]", "").replace(" ", "");
		return Double.parseDouble(sanitizedPrice);
	}

	// the method to initialize prices: extract the price from each product item and
	// store them in a List
	private void initializePrices() {
		prices = productPrices.stream().map(element -> extractPrice(element.getText())).collect(Collectors.toList());
	}

	public boolean isListSortedByPrice() {
		if (prices == null) {
			initializePrices();
		}

		return IntStream.range(0, prices.size() - 1).allMatch(i -> prices.get(i) <= prices.get(i + 1));
	}

	public void clickProductTitle(int index) {
		util.clickElement(productTitles.get(index));
	}

	public void clickProductImage(int index) {
		util.clickElement(productImages.get(index));
	}

	public boolean isProductDetailDescriptionPresent() {
		return util.isElementDisplayed(productDetailDescription);
	}

	public boolean isbackToProductsBtnPresent() {
		return util.isElementDisplayed(backToProductsBtn);
	}

}
