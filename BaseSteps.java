package com.parameters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.utils.ExtentManager;
import com.utils.ScreenshotUtil;

public class BaseSteps {
	protected WebDriver driver;
	public PropertyReader reader;
	public ChromeOptions cops;
	public EdgeOptions eops;
	protected ExtentTest test;

	@BeforeTest
	public void init() {
		initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void initializeDriver() {
		reader = new PropertyReader();
		String browser = reader.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			cops = new ChromeOptions();
			cops.addArguments("--icognito--");
			cops.addArguments("--start-maximized");
			cops.addArguments("disable-notification");
			cops.addArguments("disable-infobar");
			cops.addArguments("diable-popup-blocking");
			cops.addArguments("deny-permission-prompts");
			driver = new ChromeDriver(cops);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

			eops = new EdgeOptions();
			eops.addArguments("icognito");
			eops.addArguments("--start-maximized");
			eops.addArguments("disable-notification");
			eops.addArguments("disable-infobar");
			driver = new EdgeDriver(eops);

		}

		driver.get(reader.getProperty("url"));
		driver.manage().window().maximize();
	}

	@BeforeSuite
	public void setupReport() {
		ExtentManager.initializeExtentReports();
	}

	@BeforeMethod
	public void reportTestCreation(Method method) {
		ExtentManager.createTest("Test name: " + method.getName());
	}

	@AfterMethod
	public void reportTestCompletion(ITestResult result) throws IOException {
		String screenShotPath = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentManager.getTest().addScreenCaptureFromPath(screenShotPath);
			ExtentManager.getTest().pass("Test passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentManager.getTest().addScreenCaptureFromPath(screenShotPath);
			ExtentManager.getTest().fail("Test failed" + result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentManager.getTest().addScreenCaptureFromPath(screenShotPath);
			ExtentManager.getTest().skip("Test skipped" + result.getThrowable().getMessage());
		}
	}

	@AfterSuite
	public void reportCompletion() {
		ExtentManager.flushReports();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
