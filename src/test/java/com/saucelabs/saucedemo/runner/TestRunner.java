package com.saucelabs.saucedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@Regression", 
		features = ("classpath:features"), 
		glue = "com.saucelabs.saucedemo", 
		dryRun = false, 
		plugin = {
		"pretty", "html:target/htmlReports/cucumber-pretty.html",
		"json:target/jsonReports/cucumber.json" }, 
		snippets = CAMELCASE, 
		monochrome = true)
public class TestRunner {

}
