package org.example.steps.asserts;

import static org.example.flows.AddingProductInBagFlow.expectedBagNotification;
import static org.example.flows.AddingProductInBagFlow.expectedFullFilter;
import static org.example.flows.AddingProductInBagFlow.expectedPageTitle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Step;
import org.example.page_objects.BagPage;
import org.example.page_objects.ItemsResultPage;

public class AssertAddProductInBag {

    @Step("Проверка заголовка и категорий товара")
    public static void assertionTitleAndFilterCorrect(ItemsResultPage itemsResultPage) {
        assertEquals(expectedPageTitle, itemsResultPage.getCatalogResultTitle());
        assertEquals(expectedFullFilter, itemsResultPage.getFullFilterPath());
    }

    @Step("Проверка уведомления корзины")
    public static void assertionBagNotificationCorrect(ItemsResultPage itemsResultPage) {
        assertEquals(expectedBagNotification, itemsResultPage.getBagNotification());
    }

    @Step("Проверка активности кнопки заказа товара")
    public static void assertionOrderButtonIsEnabled(BagPage bagPage) {
        assertTrue(bagPage.orderButtonIsEnabled());
    }

    @Step("Проверка товара в корзине")
    public static void assertionProductToBagCorrect(BagPage bagPage, String actualProductBrand,
            String actualProductName, String actualProductPrice, String productPriceInBag) {
        assertEquals(bagPage.getProductInBag(), actualProductName + ", " + actualProductBrand);
        assertEquals(actualProductPrice, productPriceInBag);
        assertEquals(productPriceInBag, bagPage.getTotalPrice());
    }
}
