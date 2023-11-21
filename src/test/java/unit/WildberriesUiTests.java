package unit;

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
import static org.example.flows.WorkWithFiltersFile.allFiltersXpath;
import static org.example.flows.WorkWithFiltersFile.brandXpath;
import static org.example.flows.WorkWithFiltersFile.computersAndLaptopsXpath;
import static org.example.flows.WorkWithFiltersFile.countProductsXpath;
import static org.example.flows.WorkWithFiltersFile.deliveryDurationXpath;
import static org.example.flows.WorkWithFiltersFile.electronicsXpath;
import static org.example.flows.WorkWithFiltersFile.expectedBrand;
import static org.example.flows.WorkWithFiltersFile.expectedBrandXpath;
import static org.example.flows.WorkWithFiltersFile.expectedDelivery;
import static org.example.flows.WorkWithFiltersFile.expectedDeliveryDurationXpath;
import static org.example.flows.WorkWithFiltersFile.expectedDiagonal;
import static org.example.flows.WorkWithFiltersFile.expectedLaptopsPageTitle;
import static org.example.flows.WorkWithFiltersFile.expectedPrice;
import static org.example.flows.WorkWithFiltersFile.expectedScreenDiagonalXpath;
import static org.example.flows.WorkWithFiltersFile.filterCountProductsXpath;
import static org.example.flows.WorkWithFiltersFile.laptopsPageTitleXpath;
import static org.example.flows.WorkWithFiltersFile.laptopsXpath;
import static org.example.flows.WorkWithFiltersFile.pageCountProductsXpath;
import static org.example.flows.WorkWithFiltersFile.priceFromXpath;
import static org.example.flows.WorkWithFiltersFile.priceToXpath;
import static org.example.flows.WorkWithFiltersFile.priceXpath;
import static org.example.flows.WorkWithFiltersFile.productsListXpath;
import static org.example.flows.WorkWithFiltersFile.resetAllButtonXpath;
import static org.example.flows.WorkWithFiltersFile.screenDiagonalXpath;
import static org.example.flows.WorkWithFiltersFile.screenFilterXpath;
import static org.example.flows.WorkWithFiltersFile.showButtonXpath;
import static org.example.flows.WorkingWithSearchBarFlow.expectedFirstFilter;
import static org.example.flows.WorkingWithSearchBarFlow.expectedFirstProductBrand;
import static org.example.flows.WorkingWithSearchBarFlow.expectedSecondFilter;
import static org.example.flows.WorkingWithSearchBarFlow.firstFilterXpath;
import static org.example.flows.WorkingWithSearchBarFlow.firstProductBrandXpath;
import static org.example.flows.WorkingWithSearchBarFlow.searchInputId;
import static org.example.flows.WorkingWithSearchBarFlow.searchResultExpectedText;
import static org.example.flows.WorkingWithSearchBarFlow.searchResultXpath;
import static org.example.flows.WorkingWithSearchBarFlow.searchValue;
import static org.example.flows.WorkingWithSearchBarFlow.secondFilterXpath;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertWildberriesUiTests;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class WildberriesUiTests {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods();

    private final AssertWildberriesUiTests assertion = new AssertWildberriesUiTests();

    @BeforeEach
    void setUp() {
        seleniumMethods.openBrowser();
    }

    @AfterEach
    void closeUp() {
        seleniumMethods.closeBrowser();
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }

    @Test
    @DisplayName("Searching for a product using the search bar")
    @Description("Should find the desired product with filtering")
    public void workingWithSearchBar() {
        WebElement searchInput = seleniumMethods.searchWebElement(searchInputId);
        seleniumMethods.clickElement(searchInputId);

        seleniumMethods.searchItem(searchInputId, searchValue);

        String searchResultText = seleniumMethods.getElementText(searchResultXpath);

        String firstFilterText = seleniumMethods.getElementText(firstFilterXpath);

        String secondFilterText = seleniumMethods.getElementText(secondFilterXpath);

        String firstProductBrandText = seleniumMethods.getElementText(firstProductBrandXpath);

        assertion.assertionTextCorrect(searchResultExpectedText, searchResultText);
        assertion.assertionTextCorrect(expectedFirstFilter, firstFilterText);
        assertion.assertionTextCorrect(expectedSecondFilter, secondFilterText);
        assertion.assertionTextCorrect(expectedFirstProductBrand, firstProductBrandText);

        seleniumMethods.clickElement(searchInputId);
        assertion.assertionTextCorrect("", searchInput.getText());
    }

    @Test
    @DisplayName("Changing of city and delivery address")
    @Description("Should change the city and delivery address")
    public void changeDeliveryCity() {
        seleniumMethods.clickElement(changeCityXpath);

        seleniumMethods.clickElement(searchAddressInputXpath);
        seleniumMethods.searchItem(searchAddressInputXpath, searchCityValue);

        seleniumMethods.until(firstDeliveryAddressXpath, searchCityValue);
        String firstAddressText = seleniumMethods.getElementText(firstDeliveryAddressXpath);

        boolean pickupPointInfoWindowIsDisplayed = seleniumMethods.webElementIsDisplayed(
            pickupPointInfoXpath);

        String pickupPointAddressText = seleniumMethods.getElementText(pickupPointAddressXpath);

        seleniumMethods.clickElement(selectButtonXpath);

        String pickupPointAddressMainPageText = seleniumMethods.getElementText(
            pickupPointAddressMainPageXpath);

        String pageUrl = seleniumMethods.getWebPageUrl();

        assertion.assertionElementIsActive(pickupPointInfoWindowIsDisplayed);
        assertion.assertionTextCorrect(firstAddressText, pickupPointAddressText);
        assertion.assertionTextCorrect(firstAddressText, pickupPointAddressMainPageText);
        assertion.assertionTextCorrect(WB_MAIN_PAGE_URL, pageUrl);
    }

    @Test
    @DisplayName("Adding the product on the bag")
    @Description("Should add the product in the bag")
    public void addProductInBag() {
        seleniumMethods.clickElement(filtersXpath);

        seleniumMethods.moveToElement(householdAppliancesXpath);
        seleniumMethods.clickElement(homeAppliancesXpath);
        seleniumMethods.clickElement(hooversXpath);

        String pageTitleText = seleniumMethods.getElementText(hooversPageTitleXpath);
        String fullFilterPathText = seleniumMethods.getElementText(fullFilterXpath);

        assertion.assertionTextCorrect(expectedPageTitle, pageTitleText);
        assertion.assertionTextCorrect(expectedFullFilter, fullFilterPathText);

        String productBrandText = seleniumMethods.getElementText(firstProductBrandNameXpath);
        String productNameText = seleniumMethods.getElementText(firstProductNameXpath).substring(2);
        String productPriceText = seleniumMethods.getElementText(firstProductPriceXpath);

        seleniumMethods.moveToElement(firstProductXpath);
        seleniumMethods.clickElement(addToBagButtonXpath);

        String bagNotification = seleniumMethods.getElementText(bagNotificationXpath);

        assertion.assertionTextCorrect(expectedBagNotification, bagNotification);

        seleniumMethods.clickElement(bagButtonXpath);

        String productInBagText = seleniumMethods.getElementText(productNameInBagXpath);
        String productPriceInBagText = seleniumMethods.getElementText(firstProductPriceInBagXpath);
        String sumPriceText = seleniumMethods.getElementText(sumPriceXpath);

        boolean orderButtonIsEnabled = seleniumMethods.buttonIsEnabled(orderButtonXpath);

        assertion.assertionTextCorrect(productInBagText, productNameText + ", " + productBrandText);
        assertion.assertionTextCorrect(productPriceText, productPriceInBagText);
        assertion.assertionTextCorrect(productPriceInBagText, sumPriceText);
        assertion.assertionElementIsActive(orderButtonIsEnabled);
    }

    @Test
    @DisplayName("Working with the filters")
    @Description("Should add the product in the bag")
    public void workWithFilters() {
        seleniumMethods.clickElement(filtersXpath);

        seleniumMethods.moveToElement(electronicsXpath);
        seleniumMethods.clickElement(computersAndLaptopsXpath);
        seleniumMethods.clickElement(laptopsXpath);

        String pageTitleText = seleniumMethods.getElementText(laptopsPageTitleXpath);

        assertion.assertionTextCorrect(expectedLaptopsPageTitle, pageTitleText);

        seleniumMethods.clickElement(allFiltersXpath);
        seleniumMethods.insertIntoInput(priceFromXpath, "100000");
        seleniumMethods.insertIntoInput(priceToXpath, "140000");

        seleniumMethods.clickElement(expectedDeliveryDurationXpath);
        seleniumMethods.clickElement(expectedBrandXpath);
        seleniumMethods.scrollPage(screenFilterXpath);
        seleniumMethods.clickElement(expectedScreenDiagonalXpath);

        String filterCountProductsText = seleniumMethods.getElementText(filterCountProductsXpath);

        seleniumMethods.clickElement(showButtonXpath);

        String deliveryDurationText = seleniumMethods.getElementText(deliveryDurationXpath);
        String brandText = seleniumMethods.getElementText(brandXpath);
        String price = seleniumMethods.getElementText(priceXpath);
        String screenDiagonalText = seleniumMethods.getElementText(screenDiagonalXpath);
        boolean resetAllButtonIsEnabled = seleniumMethods.buttonIsEnabled(resetAllButtonXpath);

        String pageCountProductsText = seleniumMethods.getElementText(pageCountProductsXpath);
        String expectedCountProducts = seleniumMethods.getElementText(countProductsXpath);
        String countProducts = String.valueOf(seleniumMethods.countProducts(productsListXpath));

        assertion.assertionTextCorrect(filterCountProductsText, pageCountProductsText);
        assertion.assertionTextCorrect(expectedCountProducts, countProducts);
        assertion.assertionElementIsActive(resetAllButtonIsEnabled);
        assertion.assertionTextCorrect(expectedDelivery, deliveryDurationText);
        assertion.assertionTextCorrect(expectedBrand, brandText);
        assertion.assertionTextCorrect(expectedPrice, price);
        assertion.assertionTextCorrect(expectedDiagonal, screenDiagonalText);
    }
}
