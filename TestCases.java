package com.test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.pages.AddToInventory;
import com.pages.BasePage;
import com.pages.BookingPage;
import com.pages.ChooseSlot;
import com.pages.HomePage;
import com.pages.NegativePage;
import com.pages.WithinCityPage;
import com.parameters.BaseSteps;


public class TestCases extends BaseSteps {
	HomePage home;
	BasePage base;
	
	
  @Test(priority=0, description="login validation and navigating to packers and movers page")
  public void testCase1() throws InterruptedException {
	  home = new HomePage(driver);
	  base =new BasePage(driver);
	  base.BaseLogin(reader.getProperty("phonenumber"));
	  home.navigate();  
  }
  
  @Test(priority=1, description="Entering location for city in within City ")
  public void testcase2() throws InterruptedException, AWTException {
	  WithinCityPage withinCity = new WithinCityPage(driver);
	  withinCity.enterLocation("Whitefield, Bengaluru, Karnataka, India", "Jalahalli Cross Road, Vivekananda Nagar, Peenya, Bengaluru, Karnataka, India");
  }
  
  @Test(priority=2, description = "adding items to inventory")
  public void testcase3() throws InterruptedException {
	  AddToInventory addInvent = new AddToInventory(driver);
	  addInvent.addingItems();
  }
  
  @Test(priority=3, description = "choosing date and time and landing on booking page")
  public void testcase4() {
	  ChooseSlot slot = new ChooseSlot(driver);
	  slot.pickDate();
	  slot.pickTime();
  }
  
  @Test(priority = 4, description = "invalid/null locations")
  public void testcase5() throws InterruptedException {
	  driver.navigate().back();
	  Thread.sleep(5000);
	  driver.navigate().back();
	  Thread.sleep(5000);
	  NegativePage negative = new NegativePage(driver);
	  negative.enterNullLocations();
  }
}
