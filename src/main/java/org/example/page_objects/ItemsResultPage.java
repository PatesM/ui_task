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
    private final SelenideElement firstProductBrand = $x("//span[@class='product-card__brand'][1]");
    private final SelenideElement hooversPageTitle = $x("//div[@class='catalog-title-wrap']/h1");
    private final SelenideElement fullFilter = $x("//div[@class='breadcrumbs__container']");
    private final SelenideElement firstProductName = $x("//span[@class='product-card__name'][1]");
    private final SelenideElement firstProductPrice = $x(
        "//p[@class='product-card__price price']//ins[@class='price__lower-price'][1]");
    private final SelenideElement addToBagButton = $x(
        "//p[@class='product-card__order-wrap'][1]/a[@class='product-card__add-basket j-add-to-basket btn-main-sm'][1]");
    private final SelenideElement bagNotification = $x("//span[@class='navbar-pc__notify']");
    private final SelenideElement bagButton = $x(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    private final SelenideElement allFiltersXpath = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    private final SelenideElement deliveryTime = $x(
        "//li[@class='your-choice__item']/span[text()='до 3 дней']");
    private final SelenideElement brand = $x(
        "//li[@class='your-choice__item']/span[text()='Apple']");
    private final SelenideElement price = $x(
        "//li[@class='your-choice__item']/span[text()='от 100 000 до 140 000']");
    private final SelenideElement screenDiagonal = $x("//li[@class='your-choice__item'][4]/span");
    private final SelenideElement resetAllButtonXpath = $x("//button[@class='your-choice__btn']");
    private final SelenideElement countProductsXpath = $x(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    private final ElementsCollection productsListXpath = $$x(
        "//div[@class='product-card-list']/article");

    public ItemsResultPage clearSearchInput() {
        headerBar.clickClearSearchInput();

        return this;
    }

    public String getCatalogResultTitle() {
        return getSelenideElementText(hooversPageTitle);
    }

    public String getSearchResultTitle() {
        return getSelenideElementText(searchResult);
    }

    public String getFirstFilter() {
        return getSelenideElementText(firstFilter);
    }

    public String getSecondFilter() {
        return getSelenideElementText(secondFilter);
    }

    public String getProductBrand() {
        return getSelenideElementText(firstProductBrand);
    }

    public String getProductName() {
        return getSelenideElementText(firstProductName).substring(2);
    }

    public String getProductPrice() {
        return getSelenideElementText(firstProductPrice);
    }

    public String getSearchInputValue() {
        return headerBar.getSearchInputValue();
    }

    public String getFullFilterPath() {
        return getSelenideElementText(fullFilter);
    }

    public ItemsResultPage addProductToBag() {
        moveToElement(firstProductBrand);
        clickSelenideElement(addToBagButton);

        return this;
    }

    public String getBagNotification() {
        return getSelenideElementText(bagNotification);
    }

    public BagPage openBag() {
        clickSelenideElement(bagButton);
        Selenide.sleep(1000);

        return new BagPage();
    }

    public ItemsResultPage openFilters() {
        clickSelenideElement(allFiltersXpath);

        return this;
    }

    public ItemsResultPage selectPriceFilter() {
        filters.insertPriceFromTo();

        return this;
    }

    public ItemsResultPage selectDeliveryTimeFilter() {
        filters.selectDeliveryTime();

        return this;
    }

    public ItemsResultPage selectBrandFilter() {
        filters.selectBrand();

        return this;
    }

    public ItemsResultPage selectScreenDiagonalFilter() {
        filters.selectScreenDiagonal();

        return this;
    }

    public ItemsResultPage applyFilters() {
        filters.clickShowButton();

        return new ItemsResultPage();
    }

    public String getExpectedProductCount() {
        return filters.getProductsCount();
    }

    public String getDeliveryTime() {
        return getSelenideElementText(deliveryTime);
    }

    public String getBrand() {
        return getSelenideElementText(brand);
    }

    public String getPrice() {
        return getSelenideElementText(price);
    }

    public String getScreenDiagonal() {
        return getSelenideElementText(screenDiagonal);
    }

    public boolean resetAllButtonIsEnabled() {
        return buttonIsEnabled(resetAllButtonXpath);
    }

    public String getProductCount() {
        return getSelenideElementText(countProductsXpath);
    }

    public String getTotalProductsOnPage() {
        return String.valueOf(countProducts(productsListXpath));
    }
}
