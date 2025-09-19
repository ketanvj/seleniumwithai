package com.nichethyself.tests.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class EndToEndScenariosTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://nichethyself.com/tourism/");
    }

    @Test
    public void testLoginWithValidCredentials() {
    WebElement username = driver.findElement(By.name("username"));
    WebElement password = driver.findElement(By.name("password"));
    WebElement submit = driver.findElement(By.xpath("//form[@name='loginform']//button[@type='submit']"));
    username.sendKeys("stc123");
    password.sendKeys("12345");
    submit.click();
    // Assert: Login section header should still be present (no redirect or message on this site)
    WebElement loginHeader = driver.findElement(By.xpath("//div[@id='loginsection']//h3"));
    Assert.assertEquals(loginHeader.getText().trim(), "Login to your account", "Login header should be present after login");
    }

    @Test
    public void testContactUsSearch() {
        WebElement contactUsBtn = driver.findElement(By.xpath("//button[contains(text(),'Contact us!')]"));
        contactUsBtn.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        String contactWindow = null;
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                contactWindow = win;
                break;
            }
        }
        driver.switchTo().window(contactWindow);
        WebElement searchIcon = driver.findElement(By.cssSelector(".glyphicon-search"));
        searchIcon.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("London");
        alert.accept();
        // Assert: After entering 'London', locationd should not be empty
        WebElement locationDiv = driver.findElement(By.id("locationd"));
        Assert.assertFalse(locationDiv.getText().isEmpty(), "Location info should be displayed after search");
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void testExplorePageNavigation() {
    WebElement exploreLink = driver.findElement(By.xpath("//a[contains(text(),'Explore')]"));
    exploreLink.click();
    // Assert: URL should contain 'explore.html' after navigation
    Assert.assertTrue(driver.getCurrentUrl().contains("explore.html"), "Should navigate to explore.html");
    }

    @Test
    public void testWriteToUsModal() {
    WebElement writeToUsBtn = driver.findElement(By.xpath("//button[contains(text(),'Write to us!')]"));
    writeToUsBtn.click();
    // Assert: New window should open for review
    String mainWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
    Assert.assertTrue(allWindows.size() > 1, "A new window should open for review");
    }

    @Test
    public void testIndianHeritageKnowMoreHideDetails() {
    WebElement knowGoa = driver.findElement(By.id("knowgoa"));
    knowGoa.click();
    WebElement goaInfo = driver.findElement(By.id("goainfo"));
    Assert.assertTrue(goaInfo.isDisplayed(), "Goa info should be displayed");
    Assert.assertFalse(goaInfo.getText().isEmpty(), "Goa info text should not be empty");
    WebElement hideGoa = driver.findElement(By.id("hidegoa"));
    hideGoa.click();
    // Wait briefly for hide animation (if any)
    try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    Assert.assertFalse(goaInfo.isDisplayed(), "Goa info should be hidden");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
