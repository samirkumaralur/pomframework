package com.samir.automationframework.pomautomationframework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DOMEvents.AbstractPageEvents;

public class AlertsBrowserWindowsPage extends AbstractPageEvents{
	String newTabMessage;
	String newWindowMessage;
	String newWindowMessage2;
	AlertsBrowserWindowsPage(WebDriver driver, Logger log){
		super(driver, log);
	}
	
	public AlertsBrowserWindowsPage ClickNewTab() {
		Click(By.xpath("//*[text()='New Tab']"), 10);
		return new AlertsBrowserWindowsPage(driver, log);
	}
	
	public AlertsBrowserWindowsPage ClickNewWindow() {
		Click(By.xpath("//*[text()='New Window']"), 10);
		return this;
	}
	
	public AlertsBrowserWindowsPage ClickNewWindowMessage() {
		Click(By.xpath("//*[text()='New Window Message']"), 10);
		return this;
	}
	
	public AlertsBrowserWindowsPage SwitchToNewTabAndGetMessage() {
		SwitchToLastWindow();
		newTabMessage = GetText(By.id("sampleHeading"), 10);
		SwitchToMainWindow();
		return this;
	}
	
	public AlertsBrowserWindowsPage SwitchToNewWindowAndGetMessage() {
		SwitchToLastWindow();
		newWindowMessage = GetText(By.id("sampleHeading"), 10);
		newWindowMessage=newWindowMessage+"Testing";
		SwitchToMainWindow();
		return this;
	}
	
	public AlertsBrowserWindowsPage SwitchToNewWindowAndGetMessage2() {
		SwitchToLastWindow();
		newWindowMessage = GetText(By.tagName("body"), 10);
		newWindowMessage=newWindowMessage+"Testing";
		SwitchToMainWindow();
		return this;
	}
}
