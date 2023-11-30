package org.example.configurations;

import static org.example.page_objects.MainPage.waitingElement;
import static org.example.steps.selenide_steps.SelenideMethods.openBrowser;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import java.time.LocalDate;

public class Driver {

    public static void configureWebDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide",
            new AllureSelenide().screenshots(true).savePageSource(true));
        runTestInfo();
    }

    public static void runTestInfo() {
        Allure.addAttachment("Браузер запуска тестов", "chrome");
        Allure.addAttachment("Дата и время запуска теста", String.valueOf(LocalDate.now()));
    }

    @Given("Открываем сайт {string}")
    public void openPage(String url) {
        configureWebDriver();
        openBrowser(url, waitingElement);
    }

    @And("Закрывает браузер")
    public static void quitDriver() {
        Selenide.closeWebDriver();
    }
}
