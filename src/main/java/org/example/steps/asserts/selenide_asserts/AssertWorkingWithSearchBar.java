package org.example.steps.asserts.selenide_asserts;

import static org.example.flows.WorkingWithSearchBarFlow.expectedProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSearchInputValue;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSecondFilter;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.Step;
import org.example.page_objects.ItemsResultPage;

public class AssertWorkingWithSearchBar {

    @Step("Проверка результата поиска товара")
    public static void assertionSearchResultCorrect(ItemsResultPage itemsResultPage) {
        assertEquals(searchValue, itemsResultPage.getSearchResultTitle());
        assertEquals(searchValue, itemsResultPage.getFirstFilter());
        assertEquals(expectedSecondFilter, itemsResultPage.getSecondFilter());
        assertEquals(expectedProductBrand, itemsResultPage.getProductBrand());
        assertEquals(expectedSearchInputValue, itemsResultPage.getSearchInputValue());
    }
}
