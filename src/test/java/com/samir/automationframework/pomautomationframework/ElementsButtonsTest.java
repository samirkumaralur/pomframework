package com.samir.automationframework.pomautomationframework;

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
	public void setUp() {
		driver=DriverGenerator.WebDriverCreator.getDriver("chrome");
		driver.get("https://demoqa.com/buttons");
	}
	
	@Test
	public void ElementsButtons() throws InterruptedException {
		new ElementsButtonsPage(driver, log)
			.Click_DoubleClickMe_Button()
			.Click_RightClickMe_Button()
			.Click_ClickMe_Button();
		Thread.sleep(5000);
	}
	
	@AfterSuite
	public void TearDown() {
		driver.quit();
	}
}
