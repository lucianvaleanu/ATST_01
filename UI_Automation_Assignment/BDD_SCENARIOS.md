# BDD Scenarios

## Search for a product

**Given** the Magento store is open

**When** the visitor searches for a valid product keyword

**Then** the search heading contains the keyword and matching products are displayed

## Open the nth result

**Given** a search returns at least two products

**When** the visitor opens the second result

**Then** the product page title matches the selected result

## Scroll through results

**Given** a search returns several products

**When** the visitor scrolls to the bottom of the results page

**Then** the product cards remain available and the results-per-page control is present