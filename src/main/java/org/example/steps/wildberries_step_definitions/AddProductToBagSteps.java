package org.example.steps.wildberries_step_definitions;

import static org.example.page_objects.CategoriesPage.homeAppliances;
import static org.example.page_objects.CategoriesPage.householdAppliances;
import static org.example.page_objects.CategoriesPage.hovers;
import static org.example.page_objects.ItemsResultPage.addToBagButton;
import static org.example.page_objects.ItemsResultPage.bagButton;
import static org.example.page_objects.ItemsResultPage.firstProductBrand;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.moveToElement;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.example.page_elements.HeaderBar;

public class AddProductToBagSteps {

    private final HeaderBar headerBar = new HeaderBar();

    @Step("Открытие меню 'Категории'")
    @When("Пользователь нажимает на кнопку 'Категории'")
    public void openCategories() {
        headerBar.clickOpenCategoriesButton();
    }

    @Step("Наведение курсора на категорию 'Бытовая техника'")
    @And("Наводит курсор мыши на категорию 'Бытовая техника'")
    public void hoverToHouseholdAppliances() {
        moveToElement(householdAppliances);
    }

    @Step("Наведение курсора на категорию 'Бытовая техника'")
    @And("Нажимает на категорию 'Техника для дома'")
    public void clickHomeAppliances() {
        clickSelenideElement(homeAppliances);
    }

    @Step("Наведение курсора на категорию 'Бытовая техника'")
    @And("Нажимает на категорию 'Пылесосы и пароочистители'")
    public void clickHovers() {
        clickSelenideElement(hovers);
    }

    @Step("Добавление товара в корзиру")
    @When("Пользователь добавляет первый товар нажатием на кнопку 'В корзину'")
    public void addProductToBag() {
        moveToElement(firstProductBrand);
        clickSelenideElement(addToBagButton);
    }

    @Step("Открытие корзины")
    @When("Пользователь нажимает на кнопку 'Корзина'")
    public void openBag() {
        clickSelenideElement(bagButton);
        Selenide.sleep(1000);
    }
}
