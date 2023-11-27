package org.example.steps.asserts;

import static org.example.flows.WorkingWithSearchBarFlow.expectedProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSearchInputValue;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSecondFilter;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.page_objects.ItemsResultPage;

public class AssertWorkingWithSearchBar {

    public static void assertionSearchResultCorrect(ItemsResultPage itemsResultPage) {
        assertEquals(searchValue, itemsResultPage.getSearchResultTitle());
        assertEquals(searchValue, itemsResultPage.getFirstFilter());
        assertEquals(expectedSecondFilter, itemsResultPage.getSecondFilter());
        assertEquals(expectedProductBrand, itemsResultPage.getProductBrand());
        assertEquals(expectedSearchInputValue, itemsResultPage.getSearchInputValue());
    }
}
