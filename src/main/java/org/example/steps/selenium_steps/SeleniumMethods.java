package org.example.steps.selenium_steps;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Driver.wait;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumMethods {

    private final WebDriver driver = configureWebDriver();
    private final Actions action = new Actions(driver);

    public void openBrowser() {
        driver.manage().window().maximize();
        driver.get(WB_MAIN_PAGE_URL);
        wait.until(
            ExpectedConditions.presenceOfElementLocated(By.className("product-card__wrapper")));
    }

    public WebElement searchWebElement(By element) {
        return driver.findElement(element);
    }

    public int countProducts(By element) {
        return driver.findElements(element).size();
    }

    public void clickElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        searchWebElement(element).click();
    }

    public void until(By element, String searchCityValue) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, searchCityValue));
        searchWebElement(element).click();
    }

    public void moveToElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement webElement = searchWebElement(element);
        action.moveToElement(webElement).perform();
    }

    public void searchItem(By element, String itemName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        searchWebElement(element).sendKeys(itemName + Keys.ENTER);
    }

    public boolean webElementIsDisplayed(By element) {
        return searchWebElement(element).isDisplayed();
    }

    public String getElementText(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return searchWebElement(element).getText();
    }

    public String getWebPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean buttonIsEnabled(By element) {
        return searchWebElement(element).isEnabled();
    }

    public void clearInput(By element) {
        searchWebElement(element).clear();
    }

    public void insertIntoInput(By element, String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        clearInput(element);
        searchWebElement(element).sendKeys(value);
    }

    public void scrollPage(By element) {
        action.scrollToElement(driver.findElement(element)).perform();
    }
}
