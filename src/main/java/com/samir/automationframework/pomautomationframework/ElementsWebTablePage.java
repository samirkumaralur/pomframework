package com.samir.automationframework.pomautomationframework;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DOMEvents.AbstractPageEvents;

public class ElementsWebTablePage extends AbstractPageEvents {
	
	ArrayList<String> rowContent= new ArrayList<>();
	
	ElementsWebTablePage(WebDriver driver, Logger log){
		super(driver, log);
	}
	
	public ElementsWebTablePage AddRecord(String firstName, String lastName, String email, String Age, String Salary, String Department) {
		SetText(By.xpath("//input[@id='firstName']"), 10, firstName);
		SetText(By.xpath("//input[@id='lastName']"), 10, lastName);
		SetText(By.xpath("//input[@id='userEmail']"), 10, email);
		SetText(By.xpath("//input[@id='age']"), 10, Age);
		SetText(By.xpath("//input[@id='salary']"), 10, Salary);
		SetText(By.xpath("//input[@id='department']"), 10, Department);
		Click(By.xpath("//button[@id='submit']"), 10);
		return this;
	}
	
	public ElementsWebTablePage ClickAdd() {
		Click(By.xpath("//button[@id='addNewRecordButton']"), 10);
		return this;
	}
	
	public ElementsWebTablePage ClickWebTable() {
		Click(By.xpath("//span[text()='Web Tables']"), 10);
		return this;
	}
	//
	public ElementsWebTablePage EnterSearchText(String searchText) {
		SetText(By.xpath("//input[@id='searchBox']"), 10, searchText);
		return this;
	}
	
	public ElementsWebTablePage GetRowContents(int rowNumber) {
		rowContent=GetTextFromList(By.xpath("(//*[contains(@class,'ReactTable')]//*[contains(@class,'rt-tbody')]//*[@role='rowgroup'])["+rowNumber+"]//*[@role='gridcell']"), 10);
		return this;
	}
	
	public ElementsWebTablePage ClickSubmit() {
		Click(By.xpath("//button[@id='submit']"), 10);
		return this;
	}
}
 