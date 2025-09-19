package com.nichethyself.tests.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

public class ContactUsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://nichethyself.com/tourism/");
    }

    @Test
    public void testContactUsSearchLondon() throws InterruptedException {
        // Click "Contact us!" button (last button in navbar)
        WebElement contactUsBtn = driver.findElement(By.xpath("//button[contains(text(),'Contact us!')]"));
        contactUsBtn.click();
        Thread.sleep(2000); // Wait for the new window to open

        // Wait for new window to open
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

        // Click the search icon (magnifying glass)
        WebElement searchIcon = driver.findElement(By.cssSelector(".glyphicon-search"));
        searchIcon.click();

        // Handle the prompt alert, enter "London", and accept
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("London");
        alert.accept();

        // Optionally, verify the result (locationd or locationrep divs)

        // Close the contact window and switch back to main
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
