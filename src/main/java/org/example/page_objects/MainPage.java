package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.getWebPageUrl;
import static org.example.steps.selenide_steps.SelenideMethods.openBrowser;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.page_elements.HeaderBar;

public class MainPage {

    private final HeaderBar headerBar = new HeaderBar();
    private final SelenideElement waitingElement = $x("//div[@class='product-card__top-wrap']");

    public void openMainPage(String url) {
        openBrowser(url, waitingElement);
    }

    @Step("Ввод названия товара и поиск через поле поиска")
    public ItemsResultPage findProduct(String itemName) {
        headerBar.searchItem(itemName);

        return new ItemsResultPage();
    }

    @Step("Открытие страницы смены города доставки")
    public ChangeDeliveryCityPage openChangeDeliveryCityPage() {
        headerBar.clickChangeCityButton();

        return new ChangeDeliveryCityPage();
    }

    @Step("Получение адреса пункта выдачи на главной странице")
    public String getPickupPointAddressMainPage() {
        return headerBar.getPickupPointAddress();
    }

    @Step("Получение URL главной страницы")
    public String getMainPageUrl() {
        return getWebPageUrl();
    }

    @Step("Открытие меню 'Категории'")
    public CategoriesPage openCategories() {
        headerBar.clickOpenCategoriesButton();

        return new CategoriesPage();
    }
}
