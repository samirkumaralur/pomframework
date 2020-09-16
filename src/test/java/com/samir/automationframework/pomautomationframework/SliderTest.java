package com.samir.automationframework.pomautomationframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SliderTest {
	WebDriver driver;
	Logger log= LogManager.getLogger(TabsWindowsTest.class.getName());
	
	@BeforeTest
	public void SetUp() {
		driver= DriverGenerator.WebDriverCreator.getDriver("chrome");
		driver.get("https://demoqa.com/slider");
	}
	
	@Test
	public void Slider() throws InterruptedException {
		new SliderPage(driver,log)
		.MoveSliderInPage();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
