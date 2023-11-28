package org.example.steps.asserts;

import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Step;
import org.example.page_objects.MainPage;
import org.example.page_objects.PickupPointInfoPage;

public class AssertChangeDeliveryCity {

    @Step("Проверка отображения окна с информацией о пункте доставки")
    public static void assertionPointInfoWindowIsDisplayed(PickupPointInfoPage pickupPointInfoPage) {
        assertTrue(pickupPointInfoPage.pickupPointInfoWindowIsDisplayed());
    }

    @Step("Проверка выбора города и адреса доставки")
    public static void assertionChangeDeliveryCityCorrect(String expectedFirstDeliveryAddress,
            String actualPickupPointAddress, MainPage newMainPage) {
        assertEquals(expectedFirstDeliveryAddress, actualPickupPointAddress);
        assertEquals(expectedFirstDeliveryAddress, newMainPage.getPickupPointAddressMainPage());
        assertEquals(WB_MAIN_PAGE_URL, newMainPage.getMainPageUrl());
    }
}
