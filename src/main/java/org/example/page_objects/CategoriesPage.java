package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.moveToElement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CategoriesPage {

    private final SelenideElement householdAppliances = $x(
        "//ul[@class='menu-burger__main-list']//a[text()='Бытовая техника']");
    private final SelenideElement homeAppliances = $x(
        "//div[@data-menu-id='16107']//span[text()='Техника для дома']");
    private final SelenideElement hovers = $x(
        "//div[@data-menu-id='16107']//a[text()='Пылесосы и пароочистители']");
    private final SelenideElement electronics = $x(
        "//ul[@class='menu-burger__main-list']//a[text()='Электроника']");
    private final SelenideElement computersAndLaptops = $x(
        "//div[@data-menu-id='4830']//span[text()='Ноутбуки и компьютеры']");
    private final SelenideElement laptops = $x("//div[@data-menu-id='4830']//a[text()='Ноутбуки']");

    @Step("Выбор категории товара")
    public ItemsResultPage selectCategory(String category) {
        switch (category) {
            case ("hovers") -> {
                moveToElement(householdAppliances);
                clickSelenideElement(homeAppliances);
                clickSelenideElement(hovers);
            }
            case ("laptops") -> {
                moveToElement(electronics);
                clickSelenideElement(computersAndLaptops);
                clickSelenideElement(laptops);
            }
        }

        return new ItemsResultPage();
    }
}
