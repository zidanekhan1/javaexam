package com.stqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void loginTest() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        assertTrue(driver.getCurrentUrl()
                .contains("inventory.html"));

        assertTrue(driver.getPageSource()
                .contains("Products"));

        assertTrue(driver.findElement(By.id("react-burger-menu-btn"))
                .isDisplayed());

        driver.quit();
    }
}