package unit;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddingProductInBagFlow.hoversCategory;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.flows.WorkWithFiltersFlow.laptopsCategory;
import static org.example.flows.WorkWithFiltersFlow.priceFromValue;
import static org.example.flows.WorkWithFiltersFlow.priceToValue;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.example.steps.asserts.AssertAddProductInBag.assertionBagNotificationCorrect;
import static org.example.steps.asserts.AssertAddProductInBag.assertionOrderButtonIsEnabled;
import static org.example.steps.asserts.AssertAddProductInBag.assertionProductToBagCorrect;
import static org.example.steps.asserts.AssertAddProductInBag.assertionTitleAndFilterCorrect;
import static org.example.steps.asserts.AssertChangeDeliveryCity.assertionChangeDeliveryCityCorrect;
import static org.example.steps.asserts.AssertChangeDeliveryCity.assertionPointInfoWindowIsDisplayed;
import static org.example.steps.asserts.AssertWorkWithFilters.assertionAddProductToBagCorrect;
import static org.example.steps.asserts.AssertWorkWithFilters.assertionResetAllButtonIsEnabled;
import static org.example.steps.asserts.AssertWorkWithFilters.assertionSearchResultTitleCorrect;
import static org.example.steps.asserts.AssertWorkingWithSearchBar.assertionSearchResultCorrect;
import static org.example.steps.selenide_steps.SelenideMethods.closeBrowser;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.example.page_objects.BagPage;
import org.example.page_objects.ChangeDeliveryCityPage;
import org.example.page_objects.ItemsResultPage;
import org.example.page_objects.MainPage;
import org.example.page_objects.PickupPointInfoPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WildberriesUiTests {

    public MainPage mainPage = new MainPage();

    @BeforeAll
    @Step("Конфигурирование WebDriver")
    static void beforeAll() {
        configureWebDriver();
    }

    @BeforeEach
    @Step("Запуск браузера на главной странице")
    void setUp() {
        mainPage.openMainPage(WB_MAIN_PAGE_URL);
    }

    @AfterEach
    @Step("Закрытие браузера")
    void closeUp() {
        closeBrowser();
    }

    @AfterAll
    @Step("Закрытие WebDriver")
    static void afterAll() {
        quitDriver();
    }

    @Test
    @Owner("PatesM")
    @Feature("Поиск товара")
    @Story("Поиск товара через поле поиска")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск товара по названию через поле поиска")
    @Description("Должен найти товар по названию и очистить поле поиска")
    public void workingWithSearchBar() {
        ItemsResultPage itemsResultPage = mainPage.findProduct(searchValue).clearSearchInput();

        assertionSearchResultCorrect(itemsResultPage);
    }

    @Test
    @Owner("PatesM")
    @Feature("Изменение города доставки")
    @Story("Поиск и изменение города достаки")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Изменение города доставки по названию")
    @Description("Должен найти город доставки по названию и выбрать первый адрес из списка")
    public void changeDeliveryCity() {
        ChangeDeliveryCityPage changeDeliveryCityPage = mainPage.openChangeDeliveryCityPage()
            .selectDeliveryCity(deliveryCity);

        String firstDeliveryAddress = changeDeliveryCityPage.getDeliveryAddress();
        PickupPointInfoPage pickupPointInfoPage = changeDeliveryCityPage.selectFirstDeliveryAddress();

        assertionPointInfoWindowIsDisplayed(pickupPointInfoPage);

        String pickupPointAddress = pickupPointInfoPage.getPickupPointAddress();
        MainPage newMainPage = pickupPointInfoPage.selectDeliveryPickupPoint();

        assertionChangeDeliveryCityCorrect(firstDeliveryAddress, pickupPointAddress, newMainPage);
    }

    @Test
    @Owner("PatesM")
    @Feature("Добавление товара в корзиру")
    @Story("Поиск и добавление товара в корзиру")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск и добавление товара в корзиру через меню 'Категории'")
    @Description("Должен найти товары через меню 'Категории' и добавить первый товар в корзину")
    public void addProductInBag() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(hoversCategory);

        assertionTitleAndFilterCorrect(itemsResultPage);

        String productBrand = itemsResultPage.getProductBrand();
        String productName = itemsResultPage.getProductName();
        String productPrice = itemsResultPage.getProductPrice();

        itemsResultPage.addProductToBag();

        assertionBagNotificationCorrect(itemsResultPage);

        BagPage bagPage = itemsResultPage.openBag();
        String productPriceInBag = bagPage.getProductPriceInBag();

        assertionOrderButtonIsEnabled(bagPage);
        assertionProductToBagCorrect(bagPage, productBrand, productName, productPrice,
            productPriceInBag);
    }

    @Test
    @Owner("PatesM")
    @Feature("Фильтр результатов поиска")
    @Story("Применение фильтров после поиска товаров")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Применение фильтров на странице поиска товаров")
    @Description("Должен применить фильтры на странице поиска товаров и проверить их количество")
    public void workWithFilters() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(laptopsCategory);

        assertionSearchResultTitleCorrect(itemsResultPage);

        itemsResultPage
            .openFilters()
            .insertPriceFilter(priceFromValue, priceToValue)
            .selectDeliveryTimeFilter()
            .selectBrandFilter()
            .selectScreenDiagonalFilter();

        String expectedProductCount = itemsResultPage.getExpectedProductCount();

        itemsResultPage.applyFilters();

        ItemsResultPage newItemsResultPage = new ItemsResultPage();

        assertionResetAllButtonIsEnabled(newItemsResultPage);
        assertionAddProductToBagCorrect(newItemsResultPage, expectedProductCount);
    }

    @Test
    @Owner("PatesM")
    @Feature("Падающий тест")
    @Story("Падающий тест")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Падающий тест")
    @Description("Тест должен упасть")
    public void fallingTest() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(hoversCategory);

        assertionBagNotificationCorrect(itemsResultPage);
    }

    @Test
    @Disabled
    @Owner("PatesM")
    @Feature("Пропущенный тест")
    @Story("Пропущенный тест")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Пропущенный тест")
    @Description("Тест должен быть пропущен")
    public void fallingst() {
        mainPage.openCategories().selectCategory(hoversCategory);
    }
}
