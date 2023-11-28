package org.example.page_elements;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;
import static org.example.steps.selenide_steps.SelenideMethods.insertIntoInput;
import static org.example.steps.selenide_steps.SelenideMethods.scrollPage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Filters {

    private final SelenideElement priceFrom = $x("//input[@class='j-price'][@name='startN']");
    private final SelenideElement priceTo = $x("//input[@class='j-price'][@name='endN']");
    private final SelenideElement expectedDeliveryDurationXpath = $x(
        "//div[@class='radio-with-text j-list-item']/span[text()='до 3 дней']");
    private final SelenideElement expectedBrand = $x(
        "//li[@class='filter__item']/div[@class='checkbox-with-text j-list-item']/span[text()='Apple'][1]");
    private final SelenideElement expectedScreenDiagonal = $x(
        "//li[@class='filter__item']/div[@class='checkbox-with-text j-list-item']/span[text()='13.3\"']");
    private final SelenideElement showButton = $x(
        "//button[@class='filters-desktop__btn-main btn-main']");
    private final SelenideElement filterCountProducts = $x("//p[@class='filters-desktop__count-goods']"); //span[text()='13.3"']/span
    private final SelenideElement screenFilter = $x("//h3[text()='Разрешение экрана']");

    @Step("")
    public void insertPriceFromTo(String priceFromValue, String priceToValue) {
        insertIntoInput(priceFrom, priceFromValue);
        insertIntoInput(priceTo, priceToValue);
    }

    public void selectDeliveryTime() {
        clickSelenideElement(expectedDeliveryDurationXpath);
    }

    public void selectBrand() {
        clickSelenideElement(expectedBrand);
    }

    public void selectScreenDiagonal() {
        scrollPage(screenFilter);
        clickSelenideElement(expectedScreenDiagonal);
    }

    public void clickShowButton() {
        clickSelenideElement(showButton);
    }

    public String getProductsCount() {
        Selenide.sleep(1000);
        return getSelenideElementText(filterCountProducts).replaceAll("\\D+", "");
    }
}
