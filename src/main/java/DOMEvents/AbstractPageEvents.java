package DOMEvents;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageEvents 
{
	protected WebDriver driver;
	private static Logger log;
	public AbstractPageEvents(WebDriver driver, Logger log){
		this.driver=driver;
		this.log= log;
	}
	
	protected void Click(By elementIdentifier, long timeOut) {
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
			driver.findElement(elementIdentifier).click();
			log.info("Click is successful");
		}
		catch (Exception e) {
			log.error("Element not found"+ e.getMessage());
		}
	}
	
	protected void MouseClick(By elementIdentifier, long timeOut) 
	{
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
			Actions action= new Actions(driver);
			action.moveToElement(driver.findElement(elementIdentifier)).click().build().perform();
		}
		catch(Exception e) {
			log.error("Element not fount"+ e.getMessage());
		}
	}
	
	protected void ScrollToView(int number) {
		try {
			((JavascriptExecutor)driver).executeScript("window.scroll(0,"+number+");");
		}
		catch(Exception e) {
			log.error("Element Not found");
		}
	}
	
	protected void SetText(By elementIdentifier, long timeOut, String valueToBeEntered) 
	{
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
			driver.findElement(elementIdentifier).sendKeys(valueToBeEntered);
		}
		catch (Exception e) {
			log.error("Element not fount", e.getMessage());
		}
	}
	
	protected boolean GetPresenceOfElement(By elementIdentifier, long timeOut)
	{
		boolean flag=false;
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
			flag=true;
		}
		catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	
	protected String GetText(By elementIdentifier, int timeOut) {
		String message= null;
		try {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
			message=driver.findElement(elementIdentifier).getText();
		}
		catch(Exception e) {
			log.error("Element not found", e.getMessage());
		}
		return message;
		
	}
}
