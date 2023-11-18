package org.example.flows;

import org.openqa.selenium.By;

public class AddingProductInBagFlow {

    public static By filtersXpath = By.xpath(
        "//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item hide-mobile']");
    public static By householdAppliancesXpath = By.xpath(
        "//ul[@class='menu-burger__main-list']//a[text()='Бытовая техника']");
    public static By homeAppliancesXpath = By.xpath(
        "//div[@data-menu-id='16107']//span[text()='Техника для дома']");
    public static By hooversXpath = By.xpath(
        "//div[@data-menu-id='16107']//a[text()='Пылесосы и пароочистители']");
    public static String expectedPageTitle = "Пылесосы и пароочистители";
    public static By hooversPageTitleXpath = By.xpath("//div[@class='catalog-title-wrap']/h1");
    public static By fullFilterXpath = By.xpath("//div[@class='breadcrumbs__container']");
    public static String expectedFullFilter = """
        Главная
        Бытовая техника
        Техника для дома
        Пылесосы и пароочистители""";
    public static By firstProductBrandNameXpath = By.xpath(
        "//span[@class='product-card__brand'][1]");
    public static By firstProductNameXpath = By.xpath(
        "//span[@class='product-card__name'][1]");
    public static By firstProductPriceXpath = By.xpath("//ins[@class='price__lower-price'][1]");

    public static By firstProductXpath = By.xpath(
        "//a[@class='product-card__link j-card-link j-open-full-product-card'][1]");
    public static By addToBagButtonXpath = By.xpath(
        "//p[@class='product-card__order-wrap'][1]/a[@class='product-card__add-basket j-add-to-basket btn-main-sm'][1]");
    public static By bagNotificationXpath = By.xpath("//span[@class='navbar-pc__notify']");
    public static String expectedBagNotification = "1";
    public static By bagButtonXpath = By.xpath(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static By productNameInBagXpath = By.xpath(
        "//a[@class='good-info__title j-product-popup']");
    public static By firstProductPriceInBagXpath = By.xpath("//div[@class='list-item__price-new']");
    public static By sumPriceXpath = By.xpath(
        "//div[@class='b-top__count line']/span[@class='b-right']");
    public static By orderButtonXpath = By.xpath("//div[@class='basket-order__b-btn b-btn']");
}
