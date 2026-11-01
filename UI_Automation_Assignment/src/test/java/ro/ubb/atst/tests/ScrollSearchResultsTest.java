package ro.ubb.atst.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ro.ubb.atst.base.BaseTest;
import ro.ubb.atst.pages.HomePage;
import ro.ubb.atst.pages.SearchResultsPage;

public class ScrollSearchResultsTest extends BaseTest {
    @Test
    void scrollsThroughSearchResultsAndKeepsProductsVisible() {
        SearchResultsPage results = new HomePage(driver)
                .open(baseUrl)
                .searchFor("shirt")
                .waitUntilLoaded();
        int productsBeforeScroll = results.productCount();

        results.scrollToBottom();

        assertTrue(productsBeforeScroll >= 3);
        assertTrue(results.productCount() >= productsBeforeScroll);
        assertTrue(results.isResultLimitControlPresent());
    }
}