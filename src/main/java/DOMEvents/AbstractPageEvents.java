package DOMEvents;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.IndexedReadOnlyStringMap;
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
	protected static Logger log;
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
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementIdentifier));
			message=driver.findElement(elementIdentifier).getText();
		}
		catch(Exception e) {
			log.error("Element not found", e.getMessage());
		}
		return message;
	}
	
	protected ArrayList<String> GetTextFromList(By elementIdentifer, int timeOut) {
	    ArrayList<String> list= new ArrayList<>();
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementIdentifer));
		driver.findElements(elementIdentifer).stream().forEach(data->list.add(data.getText()));
		return list;
	}
	
	protected void DoubleClick(By elementIdentifier, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
		Actions ac= new Actions(driver);
		ac.moveToElement(driver.findElement(elementIdentifier)).doubleClick().build().perform();
	}
	
	protected void RightClick(By elementIdentifier, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
		Actions ac= new Actions(driver);
		ac.moveToElement(driver.findElement(elementIdentifier)).contextClick().build().perform();
	}
	
	protected void SwitchToLastWindow() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			log.info("On the windown whose title is"+ driver.getTitle());
		}
	}
	
	protected void SwitchToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	protected void MoveSlider(By elementIdentifier, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
		Actions ac= new Actions(driver);
		ac.moveToElement(driver.findElement(elementIdentifier)).clickAndHold().moveByOffset(100, 200).build().perform();
	}
	
}
