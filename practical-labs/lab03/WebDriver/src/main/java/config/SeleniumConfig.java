package config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Vasco Ramos
 * @date 28/02/20
 * @time 10:07
 */

public class SeleniumConfig {
    private WebDriver driver;

    public SeleniumConfig() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 985));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
