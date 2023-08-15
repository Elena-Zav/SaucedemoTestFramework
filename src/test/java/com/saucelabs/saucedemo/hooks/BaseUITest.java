package com.saucelabs.saucedemo.hooks;

import com.saucelabs.saucedemo.base.BaseSetup;
import com.saucelabs.saucedemo.utilities.CommonUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseUITest extends BaseSetup {

    private final CommonUtility util = new CommonUtility();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    @Before
    public void setupTests() {
        logger.info("Setting up browser for tests.");
        util.setupBrowser();
    }

    @After
    public void closeTests(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenShot = util.takeScreenShotAsBytes();
            String timestamp = sdf.format(new Date());
            String screenshotName = scenario.getName() + "_" + timestamp + "_scenario_failed.png";
            scenario.attach(screenShot, "image/png", screenshotName);
            logger.warn("Test failed. Screenshot taken and saved as " + screenshotName);
        }
        logger.info("Closing browser after tests");
        util.quitBrowser();
    }
}