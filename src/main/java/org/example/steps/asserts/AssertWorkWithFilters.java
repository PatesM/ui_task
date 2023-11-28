package org.example.steps.asserts;

import static org.example.flows.WorkWithFiltersFlow.expectedBrand;
import static org.example.flows.WorkWithFiltersFlow.expectedDeliveryTime;
import static org.example.flows.WorkWithFiltersFlow.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFlow.expectedLaptopsPageTitle;
import static org.example.flows.WorkWithFiltersFlow.expectedPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Step;
import org.example.page_objects.ItemsResultPage;

public class AssertWorkWithFilters {

    @Step("Проверка активности кнопки сброса фильтров")
    public static void assertionResetAllButtonIsEnabled(ItemsResultPage newItemsResultPage) {
        assertTrue(newItemsResultPage.resetAllButtonIsEnabled());
    }

    @Step("Проверка заголовка результатов поиска")
    public static void assertionSearchResultTitleCorrect(ItemsResultPage itemsResultPage) {
        assertEquals(expectedLaptopsPageTitle, itemsResultPage.getCatalogResultTitle());
    }

    @Step("Проверка добавленного товара в корзине")
    public static void assertionAddProductToBagCorrect(ItemsResultPage newItemsResultPage,
            String expectedProductCount) {
        assertEquals(expectedDeliveryTime, newItemsResultPage.getDeliveryTime());
        assertEquals(expectedBrand, newItemsResultPage.getBrand());
        assertEquals(expectedPrice, newItemsResultPage.getPrice());
        assertEquals(expectedDiagonal, newItemsResultPage.getScreenDiagonal());
        assertEquals(expectedProductCount, newItemsResultPage.getProductCount());
        assertEquals(expectedProductCount, newItemsResultPage.getTotalProductsOnPage());
    }
}
