package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitInputHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitInputHelper(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public void waitAndInput(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click(); // Fokus dulu
        element.clear();
        element.sendKeys(text);
        // Optional: Tab keluar untuk trigger JS change event
        element.sendKeys(Keys.TAB);

    }
}
