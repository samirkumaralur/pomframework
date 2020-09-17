package com.samir.automationframework.pomautomationframework;


import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverGenerator.WebDriverCreator;

public class ElementWebTableTest {

	Logger log= LogManager.getLogger(ElementWebTableTest.class.getName());
	WebDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver= WebDriverCreator.getDriver("chromegrid");
    	driver.get("https://demoqa.com/elements");
	}
	
	@Test
	public void ElementWebTable() {
		ElementsWebTablePage pageObj=new ElementsWebTablePage(driver, log)
			.ClickWebTable()
			.ClickAdd()
			.AddRecord("Samir", "Kumar", "test@test.com", "12", "100000000", "Testing")
			.ClickSubmit()
			.EnterSearchText("Samir")
			.GetRowContents(1);
		Assert.assertEquals(pageObj.rowContent.get(0), "Samir");
		Assert.assertEquals(pageObj.rowContent.get(1), "Kumar");
		Assert.assertEquals(pageObj.rowContent.get(2), "12");
		Assert.assertEquals(pageObj.rowContent.get(3), "test@test.com");
		Assert.assertEquals(pageObj.rowContent.get(4), "100000000");
		Assert.assertEquals(pageObj.rowContent.get(5), "Testing");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
