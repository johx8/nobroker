package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "signUp-phoneNumber")
	WebElement credentials;
	@FindBy(xpath = "//div[contains(@class,'m-auto')]/div[normalize-space()='Log in']")
	WebElement login;
	@FindBy(id = "signUpSubmit")
	WebElement signin;
	private static final int DEFAULT_TIMEOUT = 20;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void BaseLogin(String phonenumber) throws InterruptedException {
		login.click();
		waitUntilElementVisible(credentials);
		credentials.sendKeys(phonenumber);
		Thread.sleep(20000);
		waitUntilElementClickable(signin);
		signin.click();
		waitForOverlayToDisappear();
	}

	protected WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	public void waitUntilElementClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementVisible(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilFrameAvailableAndSwitchToIt(WebElement element) {
		getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void sendKeysWhenReady(WebElement element, String test) {
		element = getWait().until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(test);
	}
	public void switchToParentFrame() {
		driver.switchTo().defaultContent();
	}
	public void waitForOverlayToDisappear() {
		By overlay = By.cssSelector("div.busy-holder.backdrop");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(overlay));
	}
	public void enterAddressAndConfirm(WebElement element, String fullAddress) throws InterruptedException{

	    waitUntilElementClickable(element);
	    element.click();
	    element.sendKeys(Keys.CONTROL, "a");
	    element.sendKeys(Keys.DELETE);
	    element.sendKeys(fullAddress);
	    Thread.sleep(5000);
//	    getWait().until(driver -> !element.equals(driver.switchTo().activeElement()));
	}
	public void invalidLocation(WebElement element) throws InterruptedException{

	    waitUntilElementClickable(element);
	    element.click();
	    element.sendKeys(Keys.CONTROL, "a");
	    element.sendKeys(Keys.DELETE);
	    element.sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
//	    getWait().until(driver -> !element.equals(driver.switchTo().activeElement()));
	}
}
