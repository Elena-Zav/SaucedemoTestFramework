package com.saucelabs.saucedemo.base;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.saucelabs.saucedemo.utilities.ReadYamlFiles;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {

	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static final Logger logger = LogManager.getLogger(BaseSetup.class);
	private static final String CONFIG_PATH = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";

	public BaseSetup() {
		try {
			environmentVariables = ReadYamlFiles.getInstance(CONFIG_PATH);
		} catch (FileNotFoundException e) {
			logger.error("Failed to load environment context. Check possible file path errors.", e);
			throw new RuntimeException("Failed to load environment context: " + e.getMessage());
		}
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		Map<String, Object> uiProperties = environmentVariables.getYamlProperty("ui");
		logger.info("UI Properties: " + uiProperties);

		String url = (String) uiProperties.get("url");
		String browser = ((String) uiProperties.get("browser")).toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if ((boolean) uiProperties.get("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				webDriver = new ChromeDriver(options);
			} else {
				webDriver = new ChromeDriver();
			}
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			webDriver = new SafariDriver();
			break;
		default:
			throw new RuntimeException("Unknown browser specified in environment properties.");
		}

		webDriver.manage().window().maximize();
		webDriver.get(url);
	}

	public void quitBrowser() {
		if (webDriver != null) {
			webDriver.quit();;;
		}
	}
}
