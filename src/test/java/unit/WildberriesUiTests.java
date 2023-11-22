package unit;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddingProductInBagFlow.addToBagButtonXpath;
import static org.example.flows.AddingProductInBagFlow.bagButtonXpath;
import static org.example.flows.AddingProductInBagFlow.bagNotificationXpath;
import static org.example.flows.AddingProductInBagFlow.expectedBagNotification;
import static org.example.flows.AddingProductInBagFlow.expectedFullFilter;
import static org.example.flows.AddingProductInBagFlow.expectedPageTitle;
import static org.example.flows.AddingProductInBagFlow.filtersXpath;
import static org.example.flows.AddingProductInBagFlow.firstProductBrandNameXpath;
import static org.example.flows.AddingProductInBagFlow.firstProductNameXpath;
import static org.example.flows.AddingProductInBagFlow.firstProductPriceInBagXpath;
import static org.example.flows.AddingProductInBagFlow.firstProductPriceXpath;
import static org.example.flows.AddingProductInBagFlow.firstProductXpath;
import static org.example.flows.AddingProductInBagFlow.fullFilterXpath;
import static org.example.flows.AddingProductInBagFlow.homeAppliancesXpath;
import static org.example.flows.AddingProductInBagFlow.hooversPageTitleXpath;
import static org.example.flows.AddingProductInBagFlow.hooversXpath;
import static org.example.flows.AddingProductInBagFlow.householdAppliancesXpath;
import static org.example.flows.AddingProductInBagFlow.orderButtonXpath;
import static org.example.flows.AddingProductInBagFlow.productNameInBagXpath;
import static org.example.flows.AddingProductInBagFlow.sumPriceXpath;
import static org.example.flows.ChangingDeliveryCityFlow.changeCityXpath;
import static org.example.flows.ChangingDeliveryCityFlow.firstDeliveryAddressXpath;
import static org.example.flows.ChangingDeliveryCityFlow.pickupPointAddressMainPageXpath;
import static org.example.flows.ChangingDeliveryCityFlow.pickupPointAddressXpath;
import static org.example.flows.ChangingDeliveryCityFlow.pickupPointInfoXpath;
import static org.example.flows.ChangingDeliveryCityFlow.searchAddressInputXpath;
import static org.example.flows.ChangingDeliveryCityFlow.searchCityValue;
import static org.example.flows.ChangingDeliveryCityFlow.selectButtonXpath;
import static org.example.flows.WorkWithFiltersFlow.allFiltersXpath;
import static org.example.flows.WorkWithFiltersFlow.brandXpath;
import static org.example.flows.WorkWithFiltersFlow.computersAndLaptopsXpath;
import static org.example.flows.WorkWithFiltersFlow.countProductsXpath;
import static org.example.flows.WorkWithFiltersFlow.deliveryDurationXpath;
import static org.example.flows.WorkWithFiltersFlow.electronicsXpath;
import static org.example.flows.WorkWithFiltersFlow.expectedBrand;
import static org.example.flows.WorkWithFiltersFlow.expectedBrandXpath;
import static org.example.flows.WorkWithFiltersFlow.expectedDelivery;
import static org.example.flows.WorkWithFiltersFlow.expectedDeliveryDurationXpath;
import static org.example.flows.WorkWithFiltersFlow.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFlow.expectedLaptopsPageTitle;
import static org.example.flows.WorkWithFiltersFlow.expectedPrice;
import static org.example.flows.WorkWithFiltersFlow.expectedScreenDiagonalXpath;
import static org.example.flows.WorkWithFiltersFlow.filterCountProductsXpath;
import static org.example.flows.WorkWithFiltersFlow.laptopsPageTitleXpath;
import static org.example.flows.WorkWithFiltersFlow.laptopsXpath;
import static org.example.flows.WorkWithFiltersFlow.pageCountProductsXpath;
import static org.example.flows.WorkWithFiltersFlow.priceFromXpath;
import static org.example.flows.WorkWithFiltersFlow.priceToXpath;
import static org.example.flows.WorkWithFiltersFlow.priceXpath;
import static org.example.flows.WorkWithFiltersFlow.productsListXpath;
import static org.example.flows.WorkWithFiltersFlow.resetAllButtonXpath;
import static org.example.flows.WorkWithFiltersFlow.screenDiagonalXpath;
import static org.example.flows.WorkWithFiltersFlow.screenFilterXpath;
import static org.example.flows.WorkWithFiltersFlow.showButtonXpath;
import static org.example.flows.WorkingWithSearchBarFlow.clearSearchButton;
import static org.example.flows.WorkingWithSearchBarFlow.expectedFirstProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSecondFilter;
import static org.example.flows.WorkingWithSearchBarFlow.firstFilterXpath;
import static org.example.flows.WorkingWithSearchBarFlow.firstProductBrandXpath;
import static org.example.flows.WorkingWithSearchBarFlow.searchInputXpath;
import static org.example.flows.WorkingWithSearchBarFlow.searchResultXpath;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.example.flows.WorkingWithSearchBarFlow.secondFilterXpath;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertWildberriesUiTests;
import org.example.steps.selenide_steps.SelenideMethods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WildberriesUiTests {

    private final SelenideMethods selenideMethods = new SelenideMethods();
    private final AssertWildberriesUiTests assertion = new AssertWildberriesUiTests();

    @BeforeEach
    void setUp() {
        configureWebDriver();
        selenideMethods.openBrowser(WB_MAIN_PAGE_URL);
    }

    @AfterEach
    void closeUp() {
        selenideMethods.closeBrowser();
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }

    @Test
    @DisplayName("Searching for a product using the search bar")
    @Description("Should find the desired product with filtering")
    public void workingWithSearchBar() {

        selenideMethods.clickElement(searchInputXpath);

        selenideMethods.searchItem(searchInputXpath, searchValue);

        String searchResultText = selenideMethods.getElementText(searchResultXpath);

        String firstFilterText = selenideMethods.getElementText(firstFilterXpath);

        String secondFilterText = selenideMethods.getElementText(secondFilterXpath);

        String firstProductBrandText = selenideMethods.getElementText(firstProductBrandXpath);

        assertion.assertionTextCorrect(searchValue, searchResultText);
        assertion.assertionTextCorrect(searchValue, firstFilterText);
        assertion.assertionTextCorrect(expectedSecondFilter, secondFilterText);
        assertion.assertionTextCorrect(expectedFirstProductBrand, firstProductBrandText);

        selenideMethods.clickElement(clearSearchButton);
        String emptyInput = selenideMethods.getElementText(searchInputXpath);
//        SelenideElement searchInput = selenideMethods.searchWebElement(searchInputXpath);

        assertion.assertionTextCorrect("", emptyInput);
    }

    @Test
    @DisplayName("Changing of city and delivery address")
    @Description("Should change the city and delivery address")
    public void changeDeliveryCity() {
        selenideMethods.clickElement(changeCityXpath);

        selenideMethods.clickElement(searchAddressInputXpath);
        selenideMethods.searchItem(searchAddressInputXpath, searchCityValue);

        selenideMethods.selectFirstDeliveryAddress(firstDeliveryAddressXpath, searchCityValue);
        String firstAddressText = selenideMethods.getElementText(firstDeliveryAddressXpath);

        boolean pickupPointInfoWindowIsDisplayed = selenideMethods.webElementIsDisplayed(
            pickupPointInfoXpath);

        String pickupPointAddressText = selenideMethods.getElementText(pickupPointAddressXpath);

        selenideMethods.clickElement(selectButtonXpath);

        String pickupPointAddressMainPageText = selenideMethods.getElementText(
            pickupPointAddressMainPageXpath);

        String pageUrl = selenideMethods.getWebPageUrl();

        assertion.assertionElementIsActive(pickupPointInfoWindowIsDisplayed);
        assertion.assertionTextCorrect(firstAddressText, pickupPointAddressText);
        assertion.assertionTextCorrect(firstAddressText, pickupPointAddressMainPageText);
        assertion.assertionTextCorrect(WB_MAIN_PAGE_URL, pageUrl);
    }

    @Test
    @DisplayName("Adding the product on the bag")
    @Description("Should add the product in the bag")
    public void addProductInBag() {
        selenideMethods.clickElement(filtersXpath);

        selenideMethods.moveToElement(householdAppliancesXpath);
        selenideMethods.clickElement(homeAppliancesXpath);
        selenideMethods.clickElement(hooversXpath);

        String pageTitleText = selenideMethods.getElementText(hooversPageTitleXpath);
        String fullFilterPathText = selenideMethods.getElementText(fullFilterXpath);

        assertion.assertionTextCorrect(expectedPageTitle, pageTitleText);
        assertion.assertionTextCorrect(expectedFullFilter, fullFilterPathText);

        String productBrandText = selenideMethods.getElementText(firstProductBrandNameXpath);
        String productNameText = selenideMethods.getElementText(firstProductNameXpath).substring(2);
        String productPriceText = selenideMethods.getElementText(firstProductPriceXpath);

        selenideMethods.moveToElement(firstProductXpath);
        selenideMethods.clickElement(addToBagButtonXpath);

        String bagNotification = selenideMethods.getElementText(bagNotificationXpath);

        assertion.assertionTextCorrect(expectedBagNotification, bagNotification);

        selenideMethods.clickElement(bagButtonXpath);

        String productInBagText = selenideMethods.getElementText(productNameInBagXpath);
        String productPriceInBagText = selenideMethods.getPriceIntoBag(firstProductPriceInBagXpath,
            productPriceText);
        String sumPriceText = selenideMethods.getElementText(sumPriceXpath);

        boolean orderButtonIsEnabled = selenideMethods.buttonIsEnabled(orderButtonXpath);

        assertion.assertionTextCorrect(productInBagText, productNameText + ", " + productBrandText);
        assertion.assertionTextCorrect(productPriceText, productPriceInBagText);
        assertion.assertionTextCorrect(productPriceInBagText, sumPriceText);
        assertion.assertionElementIsActive(orderButtonIsEnabled);
    }

    @Test
    @DisplayName("Working with the filters")
    @Description("Should add the product in the bag")
    public void workWithFilters() {
        selenideMethods.clickElement(filtersXpath);

        selenideMethods.moveToElement(electronicsXpath);
        selenideMethods.clickElement(computersAndLaptopsXpath);
        selenideMethods.clickElement(laptopsXpath);

        String pageTitleText = selenideMethods.getElementText(laptopsPageTitleXpath);

        assertion.assertionTextCorrect(expectedLaptopsPageTitle, pageTitleText);

        selenideMethods.clickElement(allFiltersXpath);
        selenideMethods.insertIntoInput(priceFromXpath, "100000");
        selenideMethods.insertIntoInput(priceToXpath, "140000");

        selenideMethods.clickElement(expectedDeliveryDurationXpath);
        selenideMethods.clickElement(expectedBrandXpath);
        selenideMethods.scrollPage(screenFilterXpath);
        selenideMethods.clickElement(expectedScreenDiagonalXpath);

        String filterCountProductsText = selenideMethods.getElementText(filterCountProductsXpath);

        selenideMethods.clickElement(showButtonXpath);

        String deliveryDurationText = selenideMethods.getElementText(deliveryDurationXpath);
        String brandText = selenideMethods.getElementText(brandXpath);
        String price = selenideMethods.getElementText(priceXpath);
        String screenDiagonalText = selenideMethods.getElementText(screenDiagonalXpath);

        boolean resetAllButtonIsEnabled = selenideMethods.buttonIsEnabled(resetAllButtonXpath);

        String pageCountProductsText = selenideMethods.getElementText(pageCountProductsXpath);
        String expectedCountProducts = selenideMethods.getElementText(countProductsXpath);
        String countProducts = String.valueOf(selenideMethods.countProducts(productsListXpath));

        assertion.assertionTextCorrect(filterCountProductsText, pageCountProductsText);
        assertion.assertionTextCorrect(expectedCountProducts, countProducts);
        assertion.assertionElementIsActive(resetAllButtonIsEnabled);
        assertion.assertionTextCorrect(expectedDelivery, deliveryDurationText);
        assertion.assertionTextCorrect(expectedBrand, brandText);
        assertion.assertionTextCorrect(expectedPrice, price);
        assertion.assertionTextCorrect(expectedDiagonal, screenDiagonalText);
    }
}
