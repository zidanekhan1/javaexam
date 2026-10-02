package com.stqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        System.out.println("Title :" + driver.getTitle());

        driver.quit();
    }
}
