package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
// Class to use drivers
    public static WebDriver driver;
    private static WebDriverWait wait;

    public BaseClass(WebDriver driver, WebDriverWait wait) {

        BaseClass.driver = driver;
        BaseClass.wait = wait;

    }

    protected BaseClass() {
    }

    protected void WaitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}