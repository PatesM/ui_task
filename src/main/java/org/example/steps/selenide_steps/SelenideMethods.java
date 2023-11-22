package org.example.steps.selenide_steps;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SelenideMethods {

    public void openBrowser(String url) {
        open(url);
        searchWebElement(By.xpath("//div[@class='product-card__top-wrap']")).shouldBe(visible);
    }

    public SelenideElement searchWebElement(By element) {
        return $(element);
    }

    public int countProducts(By element) {
        return $$(element).size();
    }

    public void clickElement(By selenideElement) {
        searchWebElement(selenideElement).shouldBe(visible, interactable).click();
    }

    public void selectFirstDeliveryAddress(By element, String searchCityValue) {
        searchWebElement(element).shouldHave(text(searchCityValue)).click();
    }

    public void moveToElement(By element) {
        SelenideElement selenideElement = searchWebElement(element).shouldBe(visible);
        actions().moveToElement(selenideElement).build().perform();
    }

    public String getPriceIntoBag(By element, String price) {
        return searchWebElement(element).shouldBe(visible).shouldHave(text(price)).text();
    }

    public void searchItem(By element, String itemName) {
        searchWebElement(element).shouldBe(visible, interactable).sendKeys(itemName + Keys.ENTER);
    }

    public boolean webElementIsDisplayed(By element) {
        return searchWebElement(element).isDisplayed();
    }

    public String getElementText(By element) {
        return searchWebElement(element).shouldBe(visible).text();
    }

    public String getWebPageUrl() {
        return WebDriverRunner.url();
    }

    public boolean buttonIsEnabled(By element) {
        return searchWebElement(element).isEnabled();
    }

    public void clearInput(By element) {
        searchWebElement(element).shouldBe(visible, enabled).clear();
    }

    public void insertIntoInput(By element, String value) {
        clearInput(element);
        clearInput(element);
        searchWebElement(element).sendKeys(value);
    }

    public void scrollPage(By element) {
        SelenideElement selenideElement = searchWebElement(element);
        actions().scrollToElement(selenideElement).perform();
    }

    public void closeBrowser() {
        Selenide.closeWindow();
    }
}
