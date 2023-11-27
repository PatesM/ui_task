package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.getWebPageUrl;
import static org.example.steps.selenide_steps.SelenideMethods.openBrowser;

import com.codeborne.selenide.SelenideElement;
import org.example.page_elements.Filters;
import org.example.page_elements.HeaderBar;

public class MainPage {

    private final HeaderBar headerBar = new HeaderBar();
    private final Filters filters = new Filters();
    private final SelenideElement waitingElement = $x("//div[@class='product-card__top-wrap']");

    public void openMainPage(String url) {
        openBrowser(url, waitingElement);
    }

    public ItemsResultPage findProduct(String itemName) {
        headerBar.searchItem(itemName);

        return new ItemsResultPage();
    }

    public ChangeDeliveryCityPage openChangeDeliveryCityPage() {
        headerBar.clickChangeCityButton();

        return new ChangeDeliveryCityPage();
    }

    public String getPickupPointAddressMainPage() {
        return headerBar.getPickupPointAddress();
    }

    public String getMainPageUrl() {
        return getWebPageUrl();
    }

    public CategoriesPage openCategories() {
        headerBar.clickOpenCategoriesButton();

        return new CategoriesPage();
    }
}
