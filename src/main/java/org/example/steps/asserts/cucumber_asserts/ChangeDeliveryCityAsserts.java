package org.example.steps.asserts.cucumber_asserts;

import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.example.page_objects.ChangeDeliveryCityPage;
import org.example.page_objects.MainPage;
import org.example.page_objects.PickupPointInfoPage;

public class ChangeDeliveryCityAsserts {

    private final PickupPointInfoPage pickupPointInfoPage = new PickupPointInfoPage();
    private final ChangeDeliveryCityPage changeDeliveryCityPage = new ChangeDeliveryCityPage();
    private final String firstDeliveryAddress = changeDeliveryCityPage.getDeliveryAddress();
    private final MainPage mainPage = new MainPage();

    @Step("Проверка отображения окна с информацией о пункте доставки")
    @Then("Открывается информация о пункте выдачи")
    public void assertionPointInfoWindowIsDisplayed() {
        assertTrue(pickupPointInfoPage.pickupPointInfoWindowIsDisplayed());
    }

    @Step("Проверка корректности адреса первого пункта выдачи на странице информации")
    @And("Адрес пункта выдачи совпадает с первым адресом из списка адресов")
    public void assertionFirstDeliveryAddressCorrect() {
        assertEquals(firstDeliveryAddress, pickupPointInfoPage.getPickupPointAddress());
    }

    @Step("Проверка отображения окна с информацией о пункте доставки")
    @Then("Открывается главная страница Wildberries")
    public void assertionMainPageIsOpen() {
        assertEquals(WB_MAIN_PAGE_URL, mainPage.getMainPageUrl());
    }

    @Step("Проверка корректности адреса первого пункта выдачи на главной странице")
    @And("Адрес пункта выдачи на главной странице совпадает с первым адресом из списка адресов")
    public void assertionChangeDeliveryCityCorrect() {
        assertEquals(firstDeliveryAddress, mainPage.getPickupPointAddressMainPage());
    }
}
