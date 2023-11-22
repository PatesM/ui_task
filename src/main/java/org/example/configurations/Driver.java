package org.example.configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    public static void configureWebDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 8000;
    }

    public static void quitDriver() {
        Selenide.closeWebDriver();
    }
}
