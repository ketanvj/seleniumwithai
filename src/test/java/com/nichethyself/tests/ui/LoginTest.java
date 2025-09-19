package com.nichethyself.tests.ui;

import com.nichethyself.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://nichethyself.com/tourism/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("stc123", "12345");
        // Add assertions for successful login here
        try {
            Thread.sleep(4000); // Wait for login to process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            fail("Thread was interrupted during sleep.");
        }
        //add assertions to check the page title
        String expectedTitle = "My account";    
        String actualTitle = driver.getTitle();
        //put an explicit wait for the title to have text "My account"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("My account"));
        assertEquals(actualTitle, expectedTitle, "Page title does not match after login.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
