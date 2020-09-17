package com.samir.automationframework.pomautomationframework;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementsButtonsTest {
	Logger log= LogManager.getLogger(ElementsButtonsTest.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver=DriverGenerator.WebDriverCreator.getDriver("chromegrid");
		driver.get("https://demoqa.com/buttons");
	}
	
	@Test
	public void ElementsButtons() throws InterruptedException {
		new ElementsButtonsPage(driver, log)
			.Click_DoubleClickMe_Button()
			.Click_RightClickMe_Button()
			.Click_ClickMe_Button();
	}
	
	@AfterSuite
	public void TearDown() {
		driver.quit();
	}
}
