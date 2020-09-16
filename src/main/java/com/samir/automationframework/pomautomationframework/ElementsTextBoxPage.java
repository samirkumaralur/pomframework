package com.samir.automationframework.pomautomationframework;


import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import DOMEvents.AbstractPageEvents;

public class ElementsTextBoxPage extends AbstractPageEvents
{	
	HashMap<String, String> returnValues= new HashMap<>();
	
	ElementsTextBoxPage(WebDriver driver, Logger log)
	{
		super(driver, log);
	}
	
	public ElementsTextBoxPage ClickTextBox() 
	{
		Click(By.xpath("//span[text()='Text Box']"), 10);
		return this;
	}
	
	public ElementsTextBoxPage ClickSubmit() 
	{
		MouseClick(By.xpath("//button[@id='submit']"), 10);
		return this;
	}
	
	public ElementsTextBoxPage SetName(String name) 
	{
		SetText(By.xpath("//input[@id='userName']"), 10, name);
		return this;
	}
	
	public ElementsTextBoxPage SetEmail(String email) 
	{
		SetText(By.xpath("//input[@id='userEmail']"), 10, email);
		return this;
	}
	
	public ElementsTextBoxPage SetCurrentAddress(String address) 
	{
		SetText(By.xpath("//textarea[@id='currentAddress']"), 10, address);
		return this;
	}
	
	public ElementsTextBoxPage ScrollToViewSubmitButton(int number) 
	{
		ScrollToView(number);
		return this;
	}
	
	public ElementsTextBoxPage SetPermanentAddress(String address) 
	{
		SetText(By.xpath("//textarea[@id='permanentAddress']"), 10, address);
		return this;
	}
	
	public ElementsTextBoxPage GetName() 
	{
		returnValues.put("Name", GetText(By.xpath("//p[@id='name']"), 10));
		return this;
	}
	
	public ElementsTextBoxPage GetEmail() 
	{
		returnValues.put("Email", GetText(By.xpath("//p[@id='email']"), 10));
		return this;
	}
	
	public ElementsTextBoxPage GetCurrentAddress() 
	{
		returnValues.put("CurrentAddress", GetText(By.xpath("//p[@id='currentAddress']"), 10));
		return this;
	}
	
	public ElementsTextBoxPage GetpermanentAddress() 
	{
		returnValues.put("PermanentAddress", GetText(By.xpath("//p[@id='permanentAddress']"), 10));
		return this;
	}
	
}
