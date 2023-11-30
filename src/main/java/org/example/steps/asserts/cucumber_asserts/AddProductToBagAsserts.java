package org.example.steps.asserts.cucumber_asserts;

import static org.example.flows.AddingProductInBagFlow.expectedFullFilter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.example.page_objects.BagPage;
import org.example.page_objects.ItemsResultPage;

public class AddProductToBagAsserts {

    private final ItemsResultPage itemsResultPage = new ItemsResultPage();
    private final BagPage bagPage = new BagPage();
    private final String productBrand = itemsResultPage.getProductBrand();
    private final String productName = itemsResultPage.getProductName();
    private final String productPrice = itemsResultPage.getProductPrice();

    @Step("Проверка заголовка страницы результатов поиска")
    @Then("Открывается страница с заголовком категории ⎼ {string}")
    public void assertionTitleCorrect(String expectedPageTitle) {
        assertEquals(expectedPageTitle, itemsResultPage.getCatalogResultTitle());
    }

    @Step("Проверка заголовка страницы результатов поиска")
    @And("Путь категорий ⎼ 'Главная - Бытовая техника - Техника для дома - Пылесосы и пароочистители'")
    public void assertionFilterCorrect() {
        assertEquals(expectedFullFilter, itemsResultPage.getFullFilterPath());
    }

    @Step("Проверка уведомления корзины")
    @Then("В правом верхнем углу над логотипом 'Корзина' отображается красный кружок с белой цифрой {string}")
    public void assertionBagNotificationCorrect(String expectedBagNotification) {
        assertEquals(expectedBagNotification, itemsResultPage.getBagNotification());
    }

    @Step("Проверка заголовка страницы корзины")
    @Then("Открывается страница корзины с заголовком - {string}")
    public void assertionBagPageTitleCorrect(String expectedPageTitle) {
        assertEquals(expectedPageTitle, bagPage.getBagPageTitle());
    }

    @Step("Проверка активности кнопки заказа товара")
    @And("Кнопка 'Заказать' активна для нажатия")
    public void assertionOrderButtonIsEnabled() {
        assertTrue(bagPage.orderButtonIsEnabled());
    }

    @Step("Проверка товара в корзине")
    @And("Название, бренд, цена товара равны названию, бренду, цене первого товара из результатов поиска")
    public void assertionProductInBagCorrect() {
        assertEquals(bagPage.getProductInBag(), productName + ", " + productBrand);
        assertEquals(bagPage.getProductPriceInBag(), productPrice);

    }

    @Step("Проверка стоимости товара в корзине")
    @And("Значение 'Итого' равно стоимости товара в корзине")
    public void assertionProductPriseCorrect() {
        assertEquals(bagPage.getProductPriceInBag(), bagPage.getTotalPrice());
    }
}
