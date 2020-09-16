package com.samir.automationframework.pomautomationframework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DOMEvents.AbstractPageEvents;

public class ElementsButtonsPage extends  AbstractPageEvents{

	ElementsButtonsPage(WebDriver driver, Logger log){
		super(driver,log);
	}
	
	public ElementsButtonsPage Click_DoubleClickMe_Button() {
		DoubleClick(By.xpath("//*[@id='doubleClickBtn']"), 10);
		return this;
	}
	
	public ElementsButtonsPage Click_RightClickMe_Button() {
		RightClick(By.xpath("//*[@id='rightClickBtn']"), 10);
		return this;
	}
	
	public ElementsButtonsPage Click_ClickMe_Button() {
		MouseClick(By.xpath("//*[text()='Click Me']"), 10);
		return this;
	}
}
