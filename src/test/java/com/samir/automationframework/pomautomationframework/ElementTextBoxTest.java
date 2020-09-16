package com.samir.automationframework.pomautomationframework;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverGenerator.WebDriverCreator;

/**
 * Unit test for simple App.
 */
public class ElementTextBoxTest 
{
	WebDriver driver;
	Logger log= LogManager.getLogger(ElementTextBoxTest.class.getName());
	
	@BeforeTest
    public void setUp(){
    	driver= WebDriverCreator.getDriver("chrome");
    	driver.get("https://demoqa.com/elements");
    }
	
	@Test
    public void ElementTextBox()
    {
		ElementsTextBoxPage pageObj= new ElementsTextBoxPage(driver, log)
        	.ClickTextBox()
        	.SetName("Samir")
        	.SetEmail("Test@Test.com")
        	.SetCurrentAddress("Sample address")
        	.SetPermanentAddress("Sample Permanent address")
        	.ScrollToViewSubmitButton(500)
        	.ClickSubmit()
        	.GetName()
        	.GetEmail()
        	.GetCurrentAddress()
        	.GetpermanentAddress();
       Assert.assertEquals(pageObj.returnValues.get("Name"), "Name:Samir");
       Assert.assertEquals(pageObj.returnValues.get("Email"), "Email:Test@Test.com");
       Assert.assertEquals(pageObj.returnValues.get("CurrentAddress"), "Current Address :Sample address");
       Assert.assertEquals(pageObj.returnValues.get("PermanentAddress"), "Permananet Address :Sample Permanent address");
    }
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
