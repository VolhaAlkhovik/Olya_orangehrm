package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    private By username = By.name("username");
    private By password = By.name("password");
    private By submitButton = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
    private By dashboardMarker = By.xpath("//span[@class = 'oxd-userdropdown-tab']");
    private By errorMarker = By.cssSelector("p.oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login(String name, String pass) {
        waitUtils.waitForVisibility(submitButton);
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        return this;
    }

    public Dashboard successLogin(String name, String pass) {
        waitUtils.waitForVisibility(submitButton);
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        waitUtils.waitForVisibility(dashboardMarker);
        return new Dashboard(driver);
    }

    public LoginPage failedLogin(String name, String pass) {
        waitUtils.waitForVisibility(submitButton);
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        waitUtils.waitForVisibility(errorMarker);
        return this;
    }

    public String getTextOfFailedLogin() {
        return findElement(By.cssSelector(".oxd-alert-content-text")).getText();
    }

    public LoginPage enterUsername(String name) {
        findElement(username).sendKeys(name);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        findElement(password).sendKeys(pass);
        return this;
    }

    public void submit() {
        findElement(submitButton).click();
    }

}
