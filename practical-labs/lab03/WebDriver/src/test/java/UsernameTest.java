/**
 * @author Vasco Ramos
 * @date 27/02/20
 * @time 14:54
 */

// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsernameTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void username() {
        driver.get("http://demo.redmine.org/login");
        driver.manage().window().setSize(new Dimension(1920, 985));
        driver.findElement(By.id("username")).sendKeys("Rafaelyot");
        driver.findElement(By.id("password")).sendKeys("tqs2020");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("loggedas")).click();
        assertThat(driver.findElement(By.linkText("Rafaelyot")).getText(), is("Rafaelyot"));
        driver.findElement(By.linkText("Sign out")).click();
        assertThat(driver.findElement(By.linkText("Sign in")).getText(), is("Sign in"));
    }
}