package com.pages;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseSlot extends BasePage {
	@FindBy(xpath = "//div[normalize-space()='Evening']/parent::div/following-sibling::div[@class='cursor-pointer']")
	WebElement evening_icon;
//	@FindBy(xpath = "//div[contains(text(),'6PM-7PM')]")
//	WebElement slot;
	@FindBy(xpath = "//div[text()='Confirm']")
	WebElement proceed;

	public ChooseSlot(WebDriver driver) {
		super(driver);
	}

	public void pickDate() {

		String expectedDay = "19";
		String expectedMonth = "May";

		// XPath for NoBroker date card
		String dateXpath = "//div[contains(@class,'cursor-pointer')" + " and .//text()[normalize-space()='"
				+ expectedDay + "']" + " and .//text()[normalize-space()='" + expectedMonth + "']]";

		WebElement dateCard = driver.findElement(By.xpath(dateXpath));

		waitUntilElementClickable(dateCard);
		dateCard.click();

	}

	public void pickTime() throws InterruptedException {
	    waitUntilElementClickable(evening_icon);
	    evening_icon.click();
	    
	    By slotLocator = By.xpath("//div[contains(translate(text(),' ',''),'PM-')]");

	    WebElement slotElement = getWait().until(driver -> {

	        try {

	            WebElement el = driver.findElement(slotLocator);

	            return (el.isDisplayed() && el.isEnabled()) ? el : null;

	        } catch (Exception e) {
	            return null;
	        }
	    });

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click()", slotElement);
//	    waitUntilElementClickable(proceed);
//	    ((JavascriptExecutor) driver)
//	            .executeScript("arguments[0].click()", proceed);
	    
	    By confirmLocator = By.xpath("//div[text()='Confirm']");
	    WebElement confirmButton = getWait().until(ExpectedConditions.visibilityOfElementLocated(confirmLocator));
	    Thread.sleep(1000);
	    
	    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click()", confirmButton);
	    
	}
}
