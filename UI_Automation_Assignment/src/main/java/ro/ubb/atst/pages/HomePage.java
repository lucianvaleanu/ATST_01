package ro.ubb.atst.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final By searchInput = By.id("search");
    private final By searchButton = By.cssSelector("#search_mini_form button[type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open(String baseUrl) {
        driver.get(baseUrl + "/");
        return this;
    }

    public SearchResultsPage searchFor(String productName) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(productName);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}