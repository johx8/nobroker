package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage{
	@FindBy(xpath="//div[contains(text(),'Edit')]") WebElement edit;
	@FindBy(id="fromLift") WebElement fromlift;
	@FindBy(xpath="//input[@placeholder='Enter Floor No.']")WebElement floorNo;
	@FindBy(xpath="//div[contains(text(),'Save & Continue')]/parent::div[@id='pnmGetRealPriceButtonDesktop']")WebElement save;
	@FindBy(xpath="//div[contains(text(),'Your Added Inventory')]")WebElement addInventory;
	@FindBy(xpath="//div[contains(text(),'Edit Items')]")WebElement editItem;
	@FindBy(xpath="//div[text()='King Size Bed - Without Storage']/../../div[2]/div") WebElement bedWithoutStorage;
	@FindBy(xpath="//div[text()='King Size Bed - With Storage']/../../div[2]//div[@id='decreament']") WebElement decrement;
	@FindBy(xpath="//button/div/div[text()='Continue']") WebElement cont;
	@FindBy(xpath="//div[text()='Confirm']")WebElement confirm;
	@FindBy(xpath="//div[@data-index='2']//div[contains(text(),'Add')]")WebElement add;
	@FindBy(xpath="//input[@id='SMART_PACKING' and @type='checkbox']")WebElement toggle;
	@FindBy(xpath="(//button[normalize-space()='Confirm Booking'])[last()]") WebElement confirmBooking;
	public BookingPage(WebDriver driver) {
		super(driver);
	}
	public void editOption() {
		waitUntilFrameAvailableAndSwitchToIt(edit);
		edit.click();
		waitUntilElementClickable(fromlift);
		fromlift.click();
		waitUntilElementClickable(floorNo);
		floorNo.click();
		waitUntilElementClickable(save);
		save.click();
	}
	
	public void modifyInventory() {
		
		waitUntilElementClickable(addInventory);
		addInventory.click();
		waitUntilElementClickable(editItem);
		editItem.click();
		waitUntilElementClickable(bedWithoutStorage);
		bedWithoutStorage.click();
		waitUntilElementClickable(decrement);
		decrement.click();
		waitUntilElementClickable(cont);
		cont.click();
		waitUntilElementClickable(confirm);
		confirm.click();
	}
	
	public void addOns() {
		waitUntilElementClickable(add);
		add.click();
		waitUntilElementClickable(toggle);
		toggle.click();
	}
	
	public void bookingItems() {
		waitUntilElementClickable(confirmBooking);
		confirmBooking.click();
	}

}
