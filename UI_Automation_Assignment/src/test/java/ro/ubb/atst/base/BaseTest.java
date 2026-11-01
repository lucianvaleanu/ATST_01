package ro.ubb.atst.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @RegisterExtension
    final TestWatcher screenshots = new TestWatcher() {
        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            if (driver instanceof TakesScreenshot screenshotDriver) {
                try {
                    Path directory = Path.of("target", "screenshots");
                    Files.createDirectories(directory);
                    String fileName = context.getRequiredTestClass().getSimpleName() + "-"
                            + context.getRequiredTestMethod().getName() + ".png";
                    Files.write(directory.resolve(fileName), screenshotDriver.getScreenshotAs(OutputType.BYTES));
                } catch (IOException ignored) {
                }
            }
        }
    };

    @BeforeEach
    void startBrowser() {
        baseUrl = System.getProperty("baseUrl", "http://qa3.dev.evozon.com");
        FirefoxOptions options = new FirefoxOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("-headless");
        }
        String remoteUrl = System.getProperty("remoteUrl");
        if (remoteUrl == null || remoteUrl.isBlank()) {
            driver = new FirefoxDriver(options);
        } else {
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
            } catch (MalformedURLException exception) {
                throw new IllegalArgumentException("Invalid remoteUrl: " + remoteUrl, exception);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
    }

    @AfterEach
    void stopBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}