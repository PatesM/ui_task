package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.buttonIsEnabled;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.countProducts;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;
import static org.example.steps.selenide_steps.SelenideMethods.moveToElement;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.page_elements.Filters;
import org.example.page_elements.HeaderBar;

public class ItemsResultPage {

    private final HeaderBar headerBar = new HeaderBar();
    private final Filters filters = new Filters();
    private final SelenideElement searchResult = $x("//h1[@class='searching-results__title']");
    private final SelenideElement firstFilter = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']");
    private final SelenideElement secondFilter = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter'][1]");
    public static final SelenideElement firstProductBrand = $x(
        "//span[@class='product-card__brand'][1]");
    public static final SelenideElement categoryPageTitle = $x(
        "//div[@class='catalog-title-wrap']/h1");
    private final SelenideElement fullFilter = $x("//div[@class='breadcrumbs__container']");
    private final SelenideElement firstProductName = $x("//span[@class='product-card__name'][1]");
    private final SelenideElement firstProductPrice = $x(
        "//p[@class='product-card__price price']//ins[@class='price__lower-price'][1]");
    public static final SelenideElement addToBagButton = $x(
        "//p[@class='product-card__order-wrap'][1]/a[@class='product-card__add-basket j-add-to-basket btn-main-sm'][1]");
    private final SelenideElement bagNotification = $x("//span[@class='navbar-pc__notify']");
    public static final SelenideElement bagButton = $x(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static final SelenideElement allFiltersXpath = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    private final SelenideElement deliveryTime = $x(
        "//li[@class='your-choice__item']/span[text()='до 5 дней']");
    private final SelenideElement brand = $x(
        "//li[@class='your-choice__item']/span[text()='Apple']");
    private final SelenideElement price = $x(
        "//li[@class='your-choice__item']/span[text()='от 100 000 до 140 000']");
    private final SelenideElement screenDiagonal = $x("//li[@class='your-choice__item'][4]/span");
    private final SelenideElement resetAllButton = $x("//button[@class='your-choice__btn']");
    private final SelenideElement countProducts = $x(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    private final ElementsCollection productsList = $$x(
        "//div[@class='product-card-list']/article");

    @Step("Очистка поля поиска")
    public ItemsResultPage clearSearchInput() {
        headerBar.clickClearSearchInput();

        return this;
    }

    @Step("Получение названия категории результата поиска")
    public String getCatalogResultTitle() {
        return getSelenideElementText(categoryPageTitle);
    }

    @Step("Получение заголовка результата поиска")
    public String getSearchResultTitle() {
        return getSelenideElementText(searchResult);
    }

    @Step("Получение названия первого фильтра")
    public String getFirstFilter() {
        return getSelenideElementText(firstFilter);
    }

    @Step("Получение названия второго фильтра")
    public String getSecondFilter() {
        return getSelenideElementText(secondFilter);
    }

    @Step("Получение названия бренда товара")
    public String getProductBrand() {
        return getSelenideElementText(firstProductBrand);
    }

    @Step("Получение имени товара")
    public String getProductName() {
        return getSelenideElementText(firstProductName).substring(2);
    }

    @Step("Получение стоимости товара")
    public String getProductPrice() {
        return getSelenideElementText(firstProductPrice);
    }

    @Step("Получение текущего значения поля поиска")
    public String getSearchInputValue() {
        return headerBar.getSearchInputValue();
    }

    @Step("Получение полного пути категорий поиска")
    public String getFullFilterPath() {
        return getSelenideElementText(fullFilter);
    }

    @Step("Добавление товара в корзиру")
    public ItemsResultPage addProductToBag() {
        moveToElement(firstProductBrand);
        clickSelenideElement(addToBagButton);

        return this;
    }

    @Step("Получение уведомления корзины")
    public String getBagNotification() {
        return getSelenideElementText(bagNotification);
    }

    @Step("Открытие корзины")
    public BagPage openBag() {
        clickSelenideElement(bagButton);
        Selenide.sleep(1000);

        return new BagPage();
    }

    @Step("Открытие фильтров")
    public ItemsResultPage openFilters() {
        clickSelenideElement(allFiltersXpath);

        return this;
    }

    @Step("Выбор диапазона цены товара")
    public ItemsResultPage insertPriceFilter(String priceFromValue, String priceToValue) {
        filters.insertPriceFromTo(priceFromValue, priceToValue);

        return this;
    }

    @Step("Выбор срока достаки")
    public ItemsResultPage selectDeliveryTimeFilter() {
        filters.selectDeliveryTime();

        return this;
    }

    @Step("Выбор бренда товара")
    public ItemsResultPage selectBrandFilter() {
        filters.selectBrand();

        return this;
    }

    @Step("Выбор диагонали экрана товара")
    public ItemsResultPage selectScreenDiagonalFilter() {
        filters.selectScreenDiagonal();

        return this;
    }

    @Step("Применение фильтров")
    public ItemsResultPage applyFilters() {
        filters.clickShowButton();

        return new ItemsResultPage();
    }

    @Step("Получение ожидаемого количества товаров на странице")
    public String getExpectedProductCount() {
        return filters.getProductsCount();
    }

    @Step("Получение значение срока достаки товара")
    public String getDeliveryTime() {
        return getSelenideElementText(deliveryTime);
    }

    @Step("Получение значения имени бренда товара")
    public String getBrand() {
        return getSelenideElementText(brand);
    }

    @Step("Получение цены товара на странице поиска")
    public String getPrice() {
        return getSelenideElementText(price);
    }

    @Step("Получение значения диагонали экрана товара")
    public String getScreenDiagonal() {
        return getSelenideElementText(screenDiagonal);
    }

    @Step("Сброс фильтров на странице поиска")
    public boolean resetAllButtonIsEnabled() {
        return buttonIsEnabled(resetAllButton);
    }

    @Step("Получение значения количества товаров на странице")
    public String getProductCount() {
        return getSelenideElementText(countProducts);
    }

    @Step("Получение количества товаров на странице")
    public String getTotalProductsOnPage() {
        return String.valueOf(countProducts(productsList));
    }
}
