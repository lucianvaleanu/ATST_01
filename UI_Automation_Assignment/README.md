# Magento GUI Automation Assignment

This project tests three Magneto functionalities with Selenium WebDriver and JUnit 5:

1. Data-driven product search for shirt, bag, and watch.
2. Opening the second product from search results.
3. Scrolling through search results and checking the product list and results-per-page control.

The tests use the Page Object Pattern. Failed tests save screenshots under `target/screenshots`.

## Prerequisites

- Java 17 or newer
- Maven 3.9 or newer
- Firefox
- The Magento Docker application running
- `/etc/hosts` containing:

```text
127.0.0.1 qa1.dev.evozon.com qa2.dev.evozon.com qa3.dev.evozon.com
```

The current local database serves the populated application on `qa3.dev.evozon.com`. The base URL is configurable for another environment.

## Run

From the project directory:

```bash
mvn test -Dheadless=true
```

To run visibly in Firefox:

```bash
mvn test
```

To use another Magento host:

```bash
mvn test -DbaseUrl=http://qa1.dev.evozon.com -Dheadless=true
```

For a Selenium Firefox container, start a Selenium standalone Firefox container on port 4444 and run:

```bash
mvn test -DremoteUrl=http://127.0.0.1:4444/wd/hub -Dheadless=true
```

Reports are generated in `target/surefire-reports`.