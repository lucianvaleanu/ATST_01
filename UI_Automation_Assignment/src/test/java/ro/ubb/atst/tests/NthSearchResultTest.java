package ro.ubb.atst.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ro.ubb.atst.base.BaseTest;
import ro.ubb.atst.pages.HomePage;
import ro.ubb.atst.pages.ProductPage;
import ro.ubb.atst.pages.SearchResultsPage;

public class NthSearchResultTest extends BaseTest {
    @Test
    void opensTheSecondSearchResult() {
        SearchResultsPage results = new HomePage(driver)
                .open(baseUrl)
                .searchFor("shirt")
                .waitUntilLoaded();

        ProductPage product = results.openProduct(2);

        assertTrue(product.containsExpectedProductName());
    }
}