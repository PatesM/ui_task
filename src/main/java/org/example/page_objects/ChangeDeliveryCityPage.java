package org.example.page_objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.steps.selenide_steps.SelenideMethods.sendKeysToInput;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ChangeDeliveryCityPage {

    public static final SelenideElement searchAddressInput = $x(
        "//input[@class='ymaps-2-1-79-searchbox-input__input'][1]");
    public static final SelenideElement firstDeliveryAddress = $x(
        "//span[@class='address-item__name-text'][1]/span");

    @Step("Ввод и поиск города доставки")
    public ChangeDeliveryCityPage selectDeliveryCity(String deliveryCityValue) {
        sendKeysToInput(searchAddressInput, deliveryCityValue);

        return this;
    }

    @Step("Выбор первого пункта доставки")
    public PickupPointInfoPage selectFirstDeliveryAddress() {
        firstDeliveryAddress.shouldHave(text(deliveryCity)).click();

        return new PickupPointInfoPage();
    }

    @Step("Получение адреса первого пункта доставки")
    public String getDeliveryAddress() {
        return firstDeliveryAddress.shouldHave(text(deliveryCity)).text();
    }
}
