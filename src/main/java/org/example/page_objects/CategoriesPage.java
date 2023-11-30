package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.moveToElement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CategoriesPage {

    public static final SelenideElement householdAppliances = $x(
        "//ul[@class='menu-burger__main-list']//a[text()='Бытовая техника']");
    public static final SelenideElement homeAppliances = $x(
        "//div[@data-menu-id='16107']//span[text()='Техника для дома']");
    public static final SelenideElement hovers = $x(
        "//div[@data-menu-id='16107']//a[text()='Пылесосы и пароочистители']");
    public static final SelenideElement electronics = $x(
        "//ul[@class='menu-burger__main-list']//a[text()='Электроника']");
    public static final SelenideElement computersAndLaptops = $x(
        "//div[@data-menu-id='4830']//span[text()='Ноутбуки и компьютеры']");
    public static final SelenideElement laptops = $x("//div[@data-menu-id='4830']//a[text()='Ноутбуки']");

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
