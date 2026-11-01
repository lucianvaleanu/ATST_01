# Problem Statement

The purpose of this project is to validate important product-discovery behavior in the Magento Application Sample through browser automation. The tests simulate a customer searching for products, selecting a specific search result, and scrolling through the results list.

The solution uses Selenium WebDriver with Firefox, JUnit 5 assertions, the Page Object Pattern, and parameterized data-driven tests. The test suite verifies that:

- valid product keywords return matching products;
- the second product in the results can be opened and identified;
- scrolling through the results does not remove the products and the result-list controls remain available.

The expected outcome is a repeatable automated test suite with executable test reports and screenshots for failures.