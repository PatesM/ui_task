package unit;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddingProductInBagFlow.expectedBagNotification;
import static org.example.flows.AddingProductInBagFlow.expectedFullFilter;
import static org.example.flows.AddingProductInBagFlow.expectedPageTitle;
import static org.example.flows.AddingProductInBagFlow.hoversCategory;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.flows.WorkWithFiltersFlow.expectedBrand;
import static org.example.flows.WorkWithFiltersFlow.expectedDeliveryTime;
import static org.example.flows.WorkWithFiltersFlow.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFlow.expectedLaptopsPageTitle;
import static org.example.flows.WorkWithFiltersFlow.expectedPrice;
import static org.example.flows.WorkWithFiltersFlow.laptopsCategory;
import static org.example.flows.WorkingWithSearchBarFlow.expectedProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSearchInputValue;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSecondFilter;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.example.steps.asserts.AssertWildberriesUiTests.assertionElementIsActive;
import static org.example.steps.asserts.AssertWildberriesUiTests.assertionTextCorrect;
import static org.example.steps.selenide_steps.SelenideMethods.closeBrowser;

import io.qameta.allure.Description;
import org.example.page_objects.BagPage;
import org.example.page_objects.ChangeDeliveryCityPage;
import org.example.page_objects.ItemsResultPage;
import org.example.page_objects.MainPage;
import org.example.page_objects.PickupPointInfoPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WildberriesUiTests {

    public MainPage mainPage = new MainPage();

    @BeforeAll
    static void beforeAll() {
        configureWebDriver();
    }

    @BeforeEach
    void setUp() {
        mainPage.openMainPage(WB_MAIN_PAGE_URL);
    }

    @AfterEach
    void closeUp() {
        closeBrowser();
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }

    @Test
    @DisplayName("Searching for a product using the search bar")
    @Description("Should find the desired product with filtering")
    public void workingWithSearchBar() {
        ItemsResultPage itemsResultPage = mainPage.findProduct(searchValue).clearSearchInput();

        assertionTextCorrect(searchValue, itemsResultPage.getSearchResultTitle());
        assertionTextCorrect(searchValue, itemsResultPage.getFirstFilter());
        assertionTextCorrect(expectedSecondFilter, itemsResultPage.getSecondFilter());
        assertionTextCorrect(expectedProductBrand, itemsResultPage.getProductBrand());
        assertionTextCorrect(expectedSearchInputValue, itemsResultPage.getSearchInputValue());
    }

    @Test
    @DisplayName("Changing of city and delivery address")
    @Description("Should change the city and delivery address")
    public void changeDeliveryCity() {
        ChangeDeliveryCityPage changeDeliveryCityPage = mainPage.openChangeDeliveryCityPage()
            .selectDeliveryCity(deliveryCity);

        String firstDeliveryAddress = changeDeliveryCityPage.getDeliveryAddress();

        PickupPointInfoPage pickupPointInfoPage = changeDeliveryCityPage.selectFirstDeliveryAddress();

        assertionElementIsActive(pickupPointInfoPage.pickupPointInfoWindowIsDisplayed());

        String pickupPointAddress = pickupPointInfoPage.getPickupPointAddress();

        MainPage newMainPage = pickupPointInfoPage.selectDeliveryPickupPoint();

        assertionTextCorrect(firstDeliveryAddress, pickupPointAddress);
        assertionTextCorrect(firstDeliveryAddress, newMainPage.getPickupPointAddressMainPage());
        assertionTextCorrect(WB_MAIN_PAGE_URL, newMainPage.getMainPageUrl());
    }

    @Test
    @DisplayName("Adding the product on the bag")
    @Description("Should add the product in the bag")
    public void addProductInBag() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(hoversCategory);

        assertionTextCorrect(expectedPageTitle, itemsResultPage.getCatalogResultTitle());
        assertionTextCorrect(expectedFullFilter, itemsResultPage.getFullFilterPath());

        String productBrand = itemsResultPage.getProductBrand();
        String productName = itemsResultPage.getProductName();
        String productPrice = itemsResultPage.getProductPrice();

        itemsResultPage.addProductToBag();

        assertionTextCorrect(expectedBagNotification, itemsResultPage.getBagNotification());

        BagPage bagPage = itemsResultPage.openBag();

        String productPriceInBag = bagPage.getProductPriceInBag();

        assertionElementIsActive(bagPage.orderButtonIsEnabled());

        assertionTextCorrect(bagPage.getProductInBag(), productName + ", " + productBrand);
        assertionTextCorrect(productPrice, productPriceInBag);
        assertionTextCorrect(productPriceInBag, bagPage.getTotalPrice());
    }

    @Test
    @DisplayName("Working with the filters")
    @Description("Should add the product in the bag")
    public void workWithFilters() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(laptopsCategory);

        assertionTextCorrect(expectedLaptopsPageTitle, itemsResultPage.getCatalogResultTitle());

        itemsResultPage
            .openFilters()
            .selectPriceFilter()
            .selectDeliveryTimeFilter()
            .selectBrandFilter()
            .selectScreenDiagonalFilter();

        String expectedProductCount = itemsResultPage.getExpectedProductCount();

        itemsResultPage.applyFilters();

        ItemsResultPage newItemsResultPage = new ItemsResultPage();

        assertionTextCorrect(expectedDeliveryTime, newItemsResultPage.getDeliveryTime());
        assertionTextCorrect(expectedBrand, newItemsResultPage.getBrand());
        assertionTextCorrect(expectedPrice, newItemsResultPage.getPrice());
        assertionTextCorrect(expectedDiagonal, newItemsResultPage.getScreenDiagonal());

        assertionElementIsActive(newItemsResultPage.resetAllButtonIsEnabled());

        assertionTextCorrect(expectedProductCount, newItemsResultPage.getProductCount());
        assertionTextCorrect(expectedProductCount, newItemsResultPage.getTotalProductsOnPage());
    }
}
