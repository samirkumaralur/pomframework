package DriverGenerator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverCreator {
	
	public static WebDriver getDriver(String drivertype) throws MalformedURLException {
		WebDriver driver= null;
		if(drivertype.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(drivertype.equals("chromegrid")) {
			String host="3.135.195.124";
			DesiredCapabilities dc= new DesiredCapabilities().chrome();
			String url= "http://"+host+":4444/wd/hub";
			driver= new RemoteWebDriver(new URL(url), dc);
		}
		return driver;
	}

}
