package com.samir.automationframework.pomautomationframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TabsWindowsTest 
{
	WebDriver driver;
	Logger log= LogManager.getLogger(TabsWindowsTest.class.getName());
	
	@BeforeTest
	public void SetUp() {
		driver= DriverGenerator.WebDriverCreator.getDriver("chrome");
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void TabsWindows() {
		AlertsBrowserWindowsPage pageObj = new AlertsBrowserWindowsPage(driver,log)
			.ClickNewTab()
			.SwitchToNewTabAndGetMessage()
			.ClickNewWindow()
			.SwitchToNewWindowAndGetMessage();
		log.info(pageObj.newTabMessage);
		log.info(pageObj.newWindowMessage);
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
