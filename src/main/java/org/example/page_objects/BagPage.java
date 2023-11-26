package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.buttonIsEnabled;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;

import com.codeborne.selenide.SelenideElement;

public class BagPage {

    private final SelenideElement productInBag = $x(
        "//a[@class='good-info__title j-product-popup']");
    private final SelenideElement firstProductPriceInBag = $x(
        "//div[@class='list-item__price']/div[@class='list-item__price-new']");
    private final SelenideElement totalPrice = $x(
        "//div[@class='b-top__count line']/span[@class='b-right']");
    private final SelenideElement orderButton = $x("//div[@class='basket-order__b-btn b-btn']");

    public String getProductInBag() {
        return getSelenideElementText(productInBag);
    }

    public boolean orderButtonIsEnabled() {
        return buttonIsEnabled(orderButton);
    }

    public String getProductPriceInBag() {
        return getSelenideElementText(firstProductPriceInBag);
    }

    public String getTotalPrice() {
        return getSelenideElementText(totalPrice);
    }
}
