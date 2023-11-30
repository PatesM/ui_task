package org.example.steps.wildberries_step_definitions;

import static com.codeborne.selenide.Condition.text;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.page_objects.ChangeDeliveryCityPage.firstDeliveryAddress;
import static org.example.page_objects.ChangeDeliveryCityPage.searchAddressInput;
import static org.example.page_objects.PickupPointInfoPage.selectButton;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.sendKeysToInput;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.example.page_elements.HeaderBar;

public class ChangeDeliveryCitySteps {

    private final HeaderBar headerBar = new HeaderBar();

    @Step("Открытие страницы смены города доставки")
    @When("Пользователь нажимает на кнопку 'Смена города'")
    public void openChangeDeliveryCityPage() {
        headerBar.clickChangeCityButton();
    }

    @Step("Ввод и поиск города доставки")
    @And("Вводит в поисковую строку {string}")
    public void selectDeliveryCity(String deliveryCityValue) {
        sendKeysToInput(searchAddressInput, deliveryCityValue);
    }

    @Step("Выбор первого пункта доставки")
    @And("Выбирает первый адрес из списка адресов")
    public void selectFirstDeliveryAddress() {
        firstDeliveryAddress.shouldHave(text(deliveryCity)).click();
    }

    @Step("Выбор пункта доставки")
    @When("Пользователь нажимает на кнопку 'Выбрать'")
    public void selectDeliveryPickupPoint() {
        clickSelenideElement(selectButton);
    }
}
