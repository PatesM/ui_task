package org.example.steps.wildberries_step_definitions;

import static org.example.page_objects.CategoriesPage.computersAndLaptops;
import static org.example.page_objects.CategoriesPage.electronics;
import static org.example.page_objects.CategoriesPage.laptops;
import static org.example.page_objects.ItemsResultPage.allFiltersXpath;
import static org.example.steps.asserts.cucumber_asserts.WorkWithFiltersAsserts.itemsResultPage;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.moveToElement;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.example.page_elements.Filters;

public class WorkWithFiltersSteps {

    private final Filters filters = new Filters();
    public static String expectedProductCount;
    public static String actualProductCount;
    public static String totalProductCount;

    @Step("Наведение курсора на категорию 'Электроника'")
    @And("Наводит курсор мыши на категорию 'Электроника'")
    public void hoverToHouseholdAppliances() {
        moveToElement(electronics);
    }

    @Step("Наведение курсора на категорию 'Ноутбуки и компьютеры'")
    @And("Нажимает на категорию 'Ноутбуки и компьютеры'")
    public void clickHomeAppliances() {
        clickSelenideElement(computersAndLaptops);
    }

    @Step("Наведение курсора на категорию 'Ноутбуки'")
    @And("Нажимает на категорию 'Ноутбуки'")
    public void clickHovers() {
        clickSelenideElement(laptops);
    }

    @Step("Открытие фильтров")
    @When("Пользователь нажимает на кнопку 'Все фильтры'")
    public void openFilters() {
        clickSelenideElement(allFiltersXpath);
    }

    @Step("Выбор диапазона цены товара")
    @And("Выбирает цену от {string} до {string}")
    public void insertPriceFilter(String priceFromValue, String priceToValue) {
        filters.insertPriceFromTo(priceFromValue, priceToValue);
    }

    @Step("Выбор срока достаки")
    @And("Выбирает срок доставки 'до 3 дней'")
    public void selectDeliveryTimeFilter() {
        filters.selectDeliveryTime();
    }

    @Step("Выбор бренда товара")
    @And("Выбирает бренд 'Apple'")
    public void selectBrandFilter() {
        filters.selectBrand();
    }

    @Step("Выбор диагонали экрана товара")
    @And("Выбирает диагональ экрана '13.3\"'")
    public void selectScreenDiagonalFilter() {
        filters.selectScreenDiagonal();
    }

    @Step("Применение фильтров")
    @And("Нажимает на кнопку 'Показать'")
    public void applyFilters() {
        Selenide.sleep(500);
        expectedProductCount = itemsResultPage.getExpectedProductCount();
        filters.clickShowButton();
        Selenide.sleep(500);
        actualProductCount = itemsResultPage.getProductCount();
        totalProductCount = itemsResultPage.getTotalProductsOnPage();
    }
}
