package org.example.steps.asserts;

import static org.example.flows.WorkWithFiltersFlow.expectedBrand;
import static org.example.flows.WorkWithFiltersFlow.expectedDeliveryTime;
import static org.example.flows.WorkWithFiltersFlow.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFlow.expectedPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.page_objects.ItemsResultPage;

public class AssertWorkWithFilters {

    public static void assertionResetAllButtonIsEnabled(ItemsResultPage newItemsResultPage) {
        assertTrue(newItemsResultPage.resetAllButtonIsEnabled());
    }

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
