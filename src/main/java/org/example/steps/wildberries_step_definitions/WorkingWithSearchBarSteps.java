package org.example.steps.wildberries_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.example.page_elements.HeaderBar;

public class WorkingWithSearchBarSteps {

    private final HeaderBar headerBar = new HeaderBar();

    @Step("Ввод названия товара и поиск через поле поиска")
    @When("Пользователь вводит в поисковую строку {string}")
    public void findProduct(String itemName) {
        headerBar.searchItem(itemName);
    }

    @Step("Очистка поля поиска")
    @And("Нажимает крестик в поле для поиска")
    public void clearSearchInput() {
        headerBar.clickClearSearchInput();
    }
}
