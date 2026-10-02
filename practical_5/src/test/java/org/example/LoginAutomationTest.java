package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAutomationTest {

    @Test
    void loginTest() {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(
                java.time.Duration.ofSeconds(10)
        );

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();

        assertEquals(
                "https://www.saucedemo.com/inventory.html",
                actualUrl
        );

        System.out.println("URL validation passed");

        WebElement title = driver.findElement(By.className("title"));
        String pageText = title.getText();
        assertEquals("Products", pageText);
        System.out.println("products validation passed!");

        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));

        assertTrue(logout.isDisplayed());

        System.out.println("logout validation passed");
        logout.click();

    }
}

