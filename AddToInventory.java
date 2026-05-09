package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToInventory extends BasePage{
	@FindBy(xpath="//a[normalize-space()='Bedrooms']")WebElement bedroom;
	@FindBy(xpath="//div[contains(@class,'font-normal text-14')][normalize-space()='Bed']")WebElement beds;
	@FindBy(xpath="//div[text()='King Size Bed - With Storage']/../../div[2]/div")WebElement bedWithoutStorage;
	@FindBy(xpath="//div[text()='Air Conditioner']")WebElement ac;
	@FindBy(xpath="//div[text()='Split Air Conditioner (AC)']/../../div[2]/div")WebElement splitAc;
	@FindBy(xpath="//button/div/div[text()='Continue']")WebElement proceed;
	public AddToInventory(WebDriver driver) {
		super(driver);
	}
	public void addingItems() throws InterruptedException {
		waitUntilElementClickable(bedroom);
		bedroom.click();
		waitUntilElementClickable(beds);
		beds.click();
		waitUntilElementClickable(bedWithoutStorage);
		bedWithoutStorage.click();
		Thread.sleep(100);
		waitUntilElementClickable(ac);
		ac.click();
		waitUntilElementClickable(splitAc);
		splitAc.click();
		Thread.sleep(100);
		waitUntilElementClickable(proceed);
		proceed.click();
	}
}
