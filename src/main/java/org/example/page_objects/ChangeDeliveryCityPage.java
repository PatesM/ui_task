package org.example.page_objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.steps.selenide_steps.SelenideMethods.sendKeysToInput;

import com.codeborne.selenide.SelenideElement;

public class ChangeDeliveryCityPage {

    public static final SelenideElement searchAddressInputXpath = $x(
        "//input[@class='ymaps-2-1-79-searchbox-input__input'][1]");
    public static final SelenideElement firstDeliveryAddress = $x(
        "//span[@class='address-item__name-text'][1]/span");

    public ChangeDeliveryCityPage selectDeliveryCity(String deliveryCityValue) {
        sendKeysToInput(searchAddressInputXpath, deliveryCityValue);

        return this;
    }

    public PickupPointInfoPage selectFirstDeliveryAddress() {
        firstDeliveryAddress.shouldHave(text(deliveryCity)).click();

        return new PickupPointInfoPage();
    }

    public String getDeliveryAddress() {
        return firstDeliveryAddress.shouldHave(text(deliveryCity)).text();
    }
}
