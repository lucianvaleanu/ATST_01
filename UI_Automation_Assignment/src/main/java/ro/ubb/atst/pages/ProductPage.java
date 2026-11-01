package ro.ubb.atst.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String expectedName;

    public ProductPage(WebDriver driver, String expectedName) {
        this.driver = driver;
        this.expectedName = expectedName;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String title() {
        wait.until(currentDriver -> currentDriver.getTitle().equalsIgnoreCase(expectedName));
        return driver.getTitle();
    }

    public boolean containsExpectedProductName() {
        return title().equalsIgnoreCase(expectedName);
    }
}