package org.example.page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static org.example.steps.selenide_steps.SelenideMethods.clickSelenideElement;
import static org.example.steps.selenide_steps.SelenideMethods.getSelenideElementText;
import static org.example.steps.selenide_steps.SelenideMethods.webElementIsDisplayed;

import com.codeborne.selenide.SelenideElement;

public class PickupPointInfoPage {

    public static final SelenideElement pickupPointInfo = $x(
        "//div[@class='j-balloon-info geo-block__slide open']");
    public static final SelenideElement pickupPointAddress = $x(
        "//span[@class='details-self__name-text']");
    public static final SelenideElement selectButton = $x(
        "//button[@class='details-self__btn btn-main']");

    public boolean pickupPointInfoWindowIsDisplayed() {
        return webElementIsDisplayed(pickupPointInfo);
    }

    public String getPickupPointAddress() {
        return getSelenideElementText(pickupPointAddress);
    }

    public MainPage selectDeliveryPickupPoint() {
        clickSelenideElement(selectButton);

        return new MainPage();
    }
}
