package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	@FindBy(xpath ="//div[contains(@class,'m-auto')]/div[normalize-space()='Log in']") WebElement login;
	@FindBy(id="main-menu") WebElement menu;
	@FindBy(xpath="//div[@id='main-menu']//a[normalize-space()='Packers and Movers']") WebElement packersMovers;
	@FindBy(css="signUp-phoneNumber") WebElement credentials;
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public void navigate() {
		waitUntilElementClickable(menu);
		menu.click();
		waitUntilElementClickable(packersMovers);	
		packersMovers.click();
	}
}
