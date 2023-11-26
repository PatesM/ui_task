package org.example.steps.selenide_steps;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;

public class SelenideMethods {

    public static void openBrowser(String url, SelenideElement selenideElement) {
        open(url);
        selenideElement.shouldBe(visible);
    }

    public static void clickSelenideElement(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, interactable).click();
    }

    public static void sendKeysToInput(SelenideElement selenideElement, String itemName) {
        selenideElement.shouldBe(visible, interactable).sendKeys(itemName + Keys.ENTER);
    }

    public static String getSelenideElementText(SelenideElement selenideElement) {
        return selenideElement.shouldBe(visible).text();
    }

    public static int countProducts(ElementsCollection elementsCollection) {
        return elementsCollection.size();
    }

    public static boolean webElementIsDisplayed(SelenideElement selenideElement) {
        return selenideElement.isDisplayed();
    }

    public static String getWebPageUrl() {
        return WebDriverRunner.url();
    }

    public static void moveToElement(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, interactable).hover();
    }

    public static boolean buttonIsEnabled(SelenideElement selenideElement) {
        return selenideElement.isEnabled();
    }

    public static void clearInput(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, enabled).clear();
    }

    public static void insertIntoInput(SelenideElement selenideElement, String value) {
        clearInput(selenideElement);
        clearInput(selenideElement);
        selenideElement.sendKeys(value);
    }

    public static void scrollPage(SelenideElement selenideElement) {
        selenideElement.scrollIntoView(true);
    }

    public static void closeBrowser() {
        Selenide.closeWindow();
    }
}
