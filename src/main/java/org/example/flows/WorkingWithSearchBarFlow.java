package org.example.flows;

import org.openqa.selenium.By;

public class WorkingWithSearchBarFlow {

    public static By searchInputXpath = By.xpath("//div[@class='header__bottom']//input");
    public static String searchValue = "Iphone 13";
    public static By searchResultXpath = By.xpath("//h1[@class='searching-results__title']");
    public static By firstFilterXpath = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']");
    public static By secondFilterXpath = By.xpath(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter'][1]");
    public static String expectedSecondFilter = "По популярности";
    public static By firstProductBrandXpath = By.xpath("//span[@class='product-card__brand'][1]");
    public static String expectedFirstProductBrand = "Apple";
    public static By clearSearchButton = By.xpath("//div[@class='search-catalog__block']/div[@class='search-catalog__btn-wrap']/button");
}
