package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithinCityPage extends BasePage {
	@FindBy(xpath = "//input[@placeholder=\"Select your city\"]")
	WebElement selectCity;
	@FindBy(xpath = "//img[@alt='Bangalore']")
	WebElement location;
	@FindBy(xpath = "//input[@placeholder='Shifting From']")
	WebElement fromInput;
	@FindBy(xpath = "//input[@placeholder='Shifting To']")
	WebElement toInput;
	@FindBy(id = "getRealPriceButtonMobile")
	WebElement checkPrice;
	WebDriverWait wait;

	public WithinCityPage(WebDriver driver) {
		super(driver);
	}

	public void enterLocation(String fromCity, String toCity) throws InterruptedException, AWTException {
		waitUntilElementClickable(selectCity);
		selectCity.click();
		waitUntilElementClickable(location);
		location.click();
		enterAddressAndConfirm(fromInput, fromCity);
//		waitForOverlayToDisappear();
		enterAddressAndConfirm(toInput, toCity);
		waitUntilElementClickable(checkPrice);
		checkPrice.click();

	}

}
