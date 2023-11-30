package org.example.page_elements;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;
import static org.example.steps.selenide_steps.SelenideMethods.sendKeysToInput;

import com.codeborne.selenide.SelenideElement;

public class HeaderBar {

    private final SelenideElement searchInput = $x("//div[@class='header__bottom']//input");
    private final SelenideElement changeCityButton = $x(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    private final SelenideElement clearSearchButton = $x(
        "//div[@class='search-catalog__btn-wrap']/button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");
    private final SelenideElement pickupPointAddressMainPage = $x(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    public static final SelenideElement categoriesButton = $x(
        "//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item']");

    public void searchItem(String itemName) {
        sendKeysToInput(searchInput, itemName);
    }

    public void clickChangeCityButton() {
        clickSelenideElement(changeCityButton);
    }

    public void clickClearSearchInput() {
        clickSelenideElement(clearSearchButton);
    }

    public String getPickupPointAddress() {
        return getSelenideElementText(pickupPointAddressMainPage);
    }

    public String getSearchInputValue() {
        return getSelenideElementText(searchInput);
    }

    public void clickOpenCategoriesButton() {
        clickSelenideElement(categoriesButton);
    }
}
