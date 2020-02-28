import config.SeleniumConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedmineLoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Vasco Ramos
 * @date 28/02/20
 * @time 09:42
 */

public class RedmineLoginPageTest {

    private SeleniumConfig config;
    private RedmineLoginPage loginPage;

    @BeforeEach
    public void setUp() {
        this.config = new SeleniumConfig();
        this.loginPage = new RedmineLoginPage(config);
    }

    @AfterEach
    public void tearDown() {
        this.config.close();
    }

    @Test
    public void givenLoginPage_whenNavigate_thenTitleMatch() {
        this.loginPage.navigate();
        assertThat(loginPage.getPageTitle(), is("Redmine demo"));
    }

    @Test
    public void testLoginOperation() {
        this.loginPage.navigate();
        WebDriver driver = this.config.getDriver();
        driver.findElement(By.id("username")).sendKeys("Rafaelyot");
        driver.findElement(By.id("password")).sendKeys("tqs2020");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        this.config.clickElement(driver.findElement(By.id("loggedas")));
        assertThat(driver.findElement(By.linkText("Rafaelyot")).getText(), is("Rafaelyot"));
        this.config.clickElement(driver.findElement(By.linkText("Sign out")));
        assertThat(driver.findElement(By.linkText("Sign in")).getText(), is("Sign in"));
    }

}
