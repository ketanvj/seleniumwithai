package com.nichethyself.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Selenium 4+ auto driver management
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
