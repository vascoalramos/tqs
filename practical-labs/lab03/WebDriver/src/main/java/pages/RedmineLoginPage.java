package pages;

import config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Vasco Ramos
 * @date 28/02/20
 * @time 10:11
 */

public class RedmineLoginPage {

    private SeleniumConfig config;

    @FindBy(css="h1")
    private WebElement title;

    public RedmineLoginPage(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    public void navigate() {
        this.config.navigateTo("http://demo.redmine.org/login");
    }

    public String getPageTitle() {
        return this.title.getText();
    }
}
