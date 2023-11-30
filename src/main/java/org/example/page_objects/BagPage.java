package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.buttonIsEnabled;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class BagPage {

    public static final SelenideElement bagPageTitle = $x("//h1[@class='basket-section__header active']");
    private final SelenideElement productInBag = $x(
        "//a[@class='good-info__title j-product-popup']");
    private final SelenideElement firstProductPriceInBag = $x(
        "//div[@class='list-item__price']/div[@class='list-item__price-new']");
    private final SelenideElement totalPrice = $x(
        "//div[@class='b-top__count line']/span[@class='b-right']");
    private final SelenideElement orderButton = $x("//div[@class='basket-order__b-btn b-btn']");

    @Step("Получение заголовка страницы 'Корзина'")
    public String getBagPageTitle() {
        return getSelenideElementText(bagPageTitle);
    }

    @Step("Получение названия товара и бренда товара в корзире")
    public String getProductInBag() {
        return getSelenideElementText(productInBag);
    }

    @Step("Получение утрверждения, что кнопка заказа товара в корзине активна")
    public boolean orderButtonIsEnabled() {
        return buttonIsEnabled(orderButton);
    }

    @Step("Получение цены товара в корзине")
    public String getProductPriceInBag() {
        return getSelenideElementText(firstProductPriceInBag);
    }

    @Step("Получение стоимости товара в корзине")
    public String getTotalPrice() {
        return getSelenideElementText(totalPrice);
    }
}
