package unit;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddingProductInBagFlow.hoversCategory;
import static org.example.flows.ChangingDeliveryCityFlow.deliveryCity;
import static org.example.flows.WorkWithFiltersFlow.laptopsCategory;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.example.steps.asserts.AssertAddProductInBag.assertionBagNotificationCorrect;
import static org.example.steps.asserts.AssertAddProductInBag.assertionOrderButtonIsEnabled;
import static org.example.steps.asserts.AssertAddProductInBag.assertionProductToBagCorrect;
import static org.example.steps.asserts.AssertAddProductInBag.assertionTitleAndFilterCorrect;
import static org.example.steps.asserts.AssertChangeDeliveryCity.assertionChangeDeliveryCityCorrect;
import static org.example.steps.asserts.AssertChangeDeliveryCity.assertionPointInfoWindowIsDisplayed;
import static org.example.steps.asserts.AssertWorkWithFilters.assertionAddProductToBagCorrect;
import static org.example.steps.asserts.AssertWorkWithFilters.assertionResetAllButtonIsEnabled;
import static org.example.steps.asserts.AssertWorkingWithSearchBar.assertionSearchResultCorrect;
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

        assertionSearchResultCorrect(itemsResultPage);
    }

    @Test
    @DisplayName("Changing of city and delivery address")
    @Description("Should change the city and delivery address")
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
    @DisplayName("Adding the product on the bag")
    @Description("Should add the product in the bag")
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
    @DisplayName("Working with the filters")
    @Description("Should add the product in the bag")
    public void workWithFilters() {
        ItemsResultPage itemsResultPage = mainPage.openCategories().selectCategory(laptopsCategory);

        itemsResultPage
            .openFilters()
            .selectPriceFilter()
            .selectDeliveryTimeFilter()
            .selectBrandFilter()
            .selectScreenDiagonalFilter();

        String expectedProductCount = itemsResultPage.getExpectedProductCount();

        itemsResultPage.applyFilters();

        ItemsResultPage newItemsResultPage = new ItemsResultPage();

        assertionResetAllButtonIsEnabled(newItemsResultPage);
        assertionAddProductToBagCorrect(newItemsResultPage, expectedProductCount);
    }
}
