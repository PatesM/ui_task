package org.example.flows;

import org.openqa.selenium.By;

public class ChangingDeliveryCityFlow {

    public static By changeCityXpath = By.xpath(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    public static By searchAddressInputXpath = By.xpath(
        "//input[@class='ymaps-2-1-79-searchbox-input__input'][1]");
    public static String searchCityValue = "Санкт-Петербург";
    public static By firstDeliveryAddressXpath = By.xpath(
        "//span[@class='address-item__name-text'][1]/span");
    public static By pickupPointInfoXpath = By.xpath(
        "//div[@class='j-balloon-info geo-block__slide open']");
    public static By pickupPointAddressXpath = By.xpath("//span[@class='details-self__name-text']");
    public static By selectButtonXpath = By.xpath("//button[@class='details-self__btn btn-main']");
    public static By pickupPointAddressMainPageXpath = By.xpath(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
}
