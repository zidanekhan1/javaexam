package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import java.net.MalformedURLException;
import java.net.URI;

public class CrossBrowserTesting {
    public static void main(String[] args) throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();

        long start = System.currentTimeMillis();

        WebDriver chromeDriver = new RemoteWebDriver(
                URI.create("http://localhost:4444").toURL(),
                chromeOptions
        );

        chromeDriver.get("https://www.google.com");

        System.out.println("Chrome:-");
        System.out.println("Title: " + chromeDriver.getTitle());
        System.out.println("Url: " + chromeDriver.getCurrentUrl());

        long end = System.currentTimeMillis();
        System.out.println("Exec time: " + (end-start) + " ms");

        chromeDriver.quit();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        start = System.currentTimeMillis();
        WebDriver firefoxDriver = new RemoteWebDriver(
                URI.create("http://localhost:4444").toURL(),
                firefoxOptions
        );

        firefoxDriver.get("http://www.google.com");
        System.out.println("FireFox:-");
        System.out.println("URL: "+firefoxDriver.getCurrentUrl());

        end = System.currentTimeMillis();
        System.out.println("Exec time: " + (end-start) + " ms");
        firefoxDriver.quit();
    }
}
