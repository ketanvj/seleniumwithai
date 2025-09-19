package com.nichethyself.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	@FindBy(id = "searchBox")
	private WebElement searchBox;

	@FindBy(id = "searchButton")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void search(String query) {
		searchBox.sendKeys(query);
		searchButton.click();
	}
}
