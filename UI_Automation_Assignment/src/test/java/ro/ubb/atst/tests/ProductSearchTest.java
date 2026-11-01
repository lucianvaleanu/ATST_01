package ro.ubb.atst.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ro.ubb.atst.base.BaseTest;
import ro.ubb.atst.pages.HomePage;
import ro.ubb.atst.pages.SearchResultsPage;

public class ProductSearchTest extends BaseTest {
    @ParameterizedTest(name = "search returns products for {0}")
    @CsvFileSource(resources = "/search-products.csv", numLinesToSkip = 1)
    void searchReturnsMatchingProducts(String productName) {
        SearchResultsPage results = new HomePage(driver)
                .open(baseUrl)
                .searchFor(productName)
                .waitUntilLoaded();

        assertTrue(results.heading().toLowerCase().contains(productName));
        assertFalse(results.productNames().isEmpty());
        assertTrue(results.productNames().stream()
                .anyMatch(name -> name.toLowerCase().contains(productName)));
    }
}