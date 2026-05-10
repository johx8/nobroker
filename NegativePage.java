package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NegativePage extends BasePage{
	@FindBy(xpath = "//input[@placeholder='Shifting From']")
	WebElement fromInput;
	@FindBy(xpath = "//input[@placeholder='Shifting To']")
	WebElement toInput;
	@FindBy(id = "getRealPriceButtonMobile")
	WebElement checkPrice;
	public NegativePage(WebDriver driver) {
		super(driver);
	}
	public void enterNullLocations() throws InterruptedException {
		invalidLocation(fromInput);
		invalidLocation(toInput);
		waitUntilElementClickable(checkPrice);
		checkPrice.click();
	}

}
