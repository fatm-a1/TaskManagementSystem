package com.taskmanager.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void validLoginTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    // ------------------ NEW TESTS ------------------

    @Test
    void cssLocatorTest() {

        WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));

        assertTrue(loginBtn.isDisplayed());
    }

    @Test
    void xpathTest() {

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));

        username.sendKeys("test_user");

        assertEquals("test_user", username.getAttribute("value"));
    }

    @Test
    void emptyLoginTest() {

        driver.findElement(By.id("login-button")).click();

        WebElement error = driver.findElement(By.cssSelector("h3"));

        assertTrue(error.getText().contains("Username is required"));
    }

    @Test
    void validLoginAndNavigationTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    // ------------------ END TESTS ------------------

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}