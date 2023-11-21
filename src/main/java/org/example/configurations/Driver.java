package org.example.configurations;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static WebDriver configureWebDriver() {
        driver = new ChromeDriver();
        System.setProperty(CHROME_WEB_DRIVER_KEY, CHROME_WEB_DRIVER_VALUE);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
