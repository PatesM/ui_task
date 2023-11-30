package org.example.steps.asserts.cucumber_asserts;

import static org.example.flows.WorkingWithSearchBarFlow.expectedProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSearchInputValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.example.page_objects.ItemsResultPage;

public class WorkingWithSearchBarAsserts {

    private final ItemsResultPage itemsResultPage = new ItemsResultPage();

    @Step("Проверка открытия страницы с результатами поиска")
    @Then("Открывается страница с заголовком ⎼ {string}")
    public void assertionSearchResultTitleCorrect(String searchValue) {
        assertEquals(searchValue, itemsResultPage.getSearchResultTitle());
    }

    @Step("Проверка поля для поиска на пустоту")
    @Then("Поле для поиска пустое")
    public void assertionSearchInputEmpty() {
        assertEquals(expectedSearchInputValue, itemsResultPage.getSearchInputValue());
    }

    @Step("Проверка первого фильтра на странице")
    @And("Первый фильтр на странице - {string}")
    public void assertionFirstFilterCorrect(String searchValue) {
        assertEquals(searchValue, itemsResultPage.getFirstFilter());
    }

    @Step("Проверка второго фильтра на странице")
    @And("Второй фильтр на странице - {string}")
    public void assertionSecondFilterCorrect(String expectedSecondFilter) {
        assertEquals(expectedSecondFilter, itemsResultPage.getSecondFilter());
    }

    @Step("Проверка бренда первого товара")
    @And("Первый товар имеет бренд - {string}")
    public void assertionProductBrandCorrect(String expectedProductBrand) {
        assertEquals(expectedProductBrand, itemsResultPage.getProductBrand());
    }
}
