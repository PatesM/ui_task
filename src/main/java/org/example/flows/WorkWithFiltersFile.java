package org.example.flows;

import org.openqa.selenium.By;

public class WorkWithFiltersFile {

    public static By electronicsXpath = By.xpath(
        "//ul[@class='menu-burger__main-list']//a[text()='Электроника']");
    public static By computersAndLaptopsXpath = By.xpath(
        "//div[@data-menu-id='4830']//span[text()='Ноутбуки и компьютеры']");
    public static By laptopsXpath = By.xpath("//div[@data-menu-id='4830']//a[text()='Ноутбуки']");
    public static By laptopsPageTitleXpath = By.xpath("//div[@class='catalog-title-wrap']/h1");
    public static String expectedLaptopsPageTitle = "Ноутбуки и ультрабуки";
    public static By allFiltersXpath = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    public static By priceFromXpath = By.xpath("//input[@class='j-price'][@name='startN']");
    public static By priceToXpath = By.xpath("//input[@class='j-price'][@name='endN']");
    public static String expectedDelivery = "до 3 дней";
    public static String expectedPrice = "от 100 000 до 140 000";
    public static String expectedBrand = "Apple";
    public static String expectedDiagonal = "13.3\"";
    public static By expectedDeliveryDurationXpath = By.xpath(
        "//div[@class='radio-with-text j-list-item']/span[text()='до 3 дней']");
    public static By expectedBrandXpath = By.xpath(
        "//li[@class='filter__item']/div[@class='checkbox-with-text j-list-item']/span[text()='Apple'][1]");
    public static By screenFilterXpath = By.xpath("//h3[text()='Разрешение экрана']");
    public static By expectedScreenDiagonalXpath = By.xpath(
        "//li[@class='filter__item']/div[@class='checkbox-with-text j-list-item']/span[text()='13.3\"']");
    public static By showButtonXpath = By.xpath(
        "//button[@class='filters-desktop__btn-main btn-main']");
    public static By filterCountProductsXpath = By.xpath("//span[text()='13.3\"']/span");
    public static By pageCountProductsXpath = By.xpath(
        "//span[@class='goods-count']/span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    public static By countProductsXpath = By.xpath(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    public static By productsListXpath = By.xpath("//div[@class='product-card-list']/article");
    public static By resetAllButtonXpath = By.className("your-choice__btn");
    public static By deliveryDurationXpath = By.xpath(
        "//li[@class='your-choice__item']/span[text()='до 3 дней']");
    public static By brandXpath = By.xpath("//li[@class='your-choice__item']/span[text()='Apple']");
    public static By priceXpath = By.xpath(
        "//li[@class='your-choice__item']/span[text()='от 100 000 до 140 000']");
    public static By screenDiagonalXpath = By.xpath("//li[@class='your-choice__item'][4]/span");
}
