package com.samir.automationframework.pomautomationframework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DOMEvents.AbstractPageEvents;

public class SliderPage extends AbstractPageEvents{

	public SliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public SliderPage MoveSliderInPage() {
		MoveSlider(By.xpath("//input[@type='range']"), 10);
		return this;
	}
}
