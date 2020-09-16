package DriverGenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverCreator {
	
	public static WebDriver getDriver(String drivertype) {
		WebDriver driver= null;
		if(drivertype.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		return driver;
	}

}
