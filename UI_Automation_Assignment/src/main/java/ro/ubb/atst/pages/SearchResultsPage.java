package ro.ubb.atst.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By resultHeading = By.cssSelector("h1");
    private final By productCards = By.cssSelector("ul.products-grid li.item");
    private final By productNames = By.cssSelector("ul.products-grid li.item h2.product-name a");
    private final By resultLimit = By.cssSelector(".toolbar select[title='Results per page']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public SearchResultsPage waitUntilLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultHeading));
        return this;
    }

    public String heading() {
        return waitUntilLoaded().driver.findElement(resultHeading).getText();
    }

    public int productCount() {
        waitUntilLoaded();
        return driver.findElements(productCards).size();
    }

    public List<String> productNames() {
        waitUntilLoaded();
        return driver.findElements(productNames).stream().map(WebElement::getText).toList();
    }

    public ProductPage openProduct(int oneBasedIndex) {
        waitUntilLoaded();
        List<WebElement> products = driver.findElements(productNames);
        if (oneBasedIndex < 1 || oneBasedIndex > products.size()) {
            throw new IllegalArgumentException("Product index is outside the results: " + oneBasedIndex);
        }
        WebElement product = products.get(oneBasedIndex - 1);
        String expectedName = product.getText();
        String productUrl = product.getAttribute("href");
        product.click();
        wait.until(ExpectedConditions.urlToBe(productUrl));
        return new ProductPage(driver, expectedName);
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean isResultLimitControlPresent() {
        return !driver.findElements(resultLimit).isEmpty();
    }
}