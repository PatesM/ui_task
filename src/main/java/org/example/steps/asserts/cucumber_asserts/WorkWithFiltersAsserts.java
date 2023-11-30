package org.example.steps.asserts.cucumber_asserts;

import static org.example.flows.WorkWithFiltersFlow.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFlow.expectedPrice;
import static org.example.steps.wildberries_step_definitions.WorkWithFiltersSteps.actualProductCount;
import static org.example.steps.wildberries_step_definitions.WorkWithFiltersSteps.expectedProductCount;
import static org.example.steps.wildberries_step_definitions.WorkWithFiltersSteps.totalProductCount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.example.page_objects.ItemsResultPage;

public class WorkWithFiltersAsserts {

    public static final ItemsResultPage itemsResultPage = new ItemsResultPage();

    @Step("Проверка количества товаров на странице")
    @Then("Кол-во товаров на странице равно количеству товаров на странице")
    public void assertionProductCountCorrect() {
        assertEquals(expectedProductCount, actualProductCount);
        assertEquals(expectedProductCount, totalProductCount);
    }

    @Step("Проверка первого фильтра")
    @And("Первый фильтр на странице {string}")
    public void assertionFirstFilterCorrect(String expectedDeliveryTime) {
        assertEquals(expectedDeliveryTime, itemsResultPage.getDeliveryTime());
    }

    @Step("Проверка второго фильтра")
    @And("Второй фильтр на странице {string}")
    public void assertionSecondFilterCorrect(String expectedBrand) {
        assertEquals(expectedBrand, itemsResultPage.getBrand());
        assertEquals(expectedPrice, itemsResultPage.getPrice());
        assertEquals(expectedDiagonal, itemsResultPage.getScreenDiagonal());
    }

    @Step("Проверка третьего фильтра")
    @And("Третий фильтр на странице {string}")
    public void assertionThirdFilterCorrect(String expectedPrice) {
        assertEquals(expectedPrice, itemsResultPage.getPrice());
        assertEquals(expectedDiagonal, itemsResultPage.getScreenDiagonal());
    }

    @Step("Проверка четвертого фильтра")
    @And("Четвертый фильтр на странице {string}")
    public void assertionFourthFilterCorrect(String expectedDiagonal) {
        assertEquals(expectedDiagonal, itemsResultPage.getScreenDiagonal());
    }

    @Step("Проверка активности кнопки сброса фильтров")
    @And("Кнопка 'Сбросить все' доступна для нажатия")
    public void assertionResetAllButtonIsEnabled() {
        assertTrue(itemsResultPage.resetAllButtonIsEnabled());
    }
}
