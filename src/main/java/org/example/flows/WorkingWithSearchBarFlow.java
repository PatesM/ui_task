package org.example.flows;

import org.openqa.selenium.By;

public class WorkingWithSearchBarFlow {

    public static By searchInputId = By.id("searchInput");
    public static String searchValue = "Iphone 13";
    public static By searchResultXpath = By.xpath("//h1[@class='searching-results__title']");
    public static String searchResultExpectedText = "Iphone 13";
    public static By firstFilterXpath = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']");
    public static String expectedFirstFilter = "Iphone 13";
    public static By secondFilterXpath = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter'][1]");
    public static String expectedSecondFilter = "По популярности";
    public static By firstProductBrandXpath = By.xpath("//span[@class='product-card__brand'][1]");
    public static String expectedFirstProductBrand = "Apple";
}
