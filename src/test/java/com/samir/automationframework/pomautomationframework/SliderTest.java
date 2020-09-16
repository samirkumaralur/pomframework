package com.samir.automationframework.pomautomationframework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void Slider() throws InterruptedException, IOException {
		new SliderPage(driver,log)
		.MoveSliderInPage();
		Thread.sleep(3000);
		TakesScreenshot ts;
		ts=((TakesScreenshot)driver);
		File fs=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(new File("C:\\file\\test.png"), fs);
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
