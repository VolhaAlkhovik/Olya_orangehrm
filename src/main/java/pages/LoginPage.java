package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private By username = By.name("username");
    private By password = By.name("password");
    private By submitButton = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
    private By dashboardMarker = By.xpath("//span[@class = 'oxd-userdropdown-tab']");
    private By errorMarker = By.cssSelector("p.oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login (String name, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        return this;
    }

    public Dashboard successLogin (String name, String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardMarker));
        return new Dashboard(driver);
    }

    public LoginPage failedLogin (String name, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        enterUsername(name)
                .enterPassword(pass)
                    .submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMarker));
        return this;
    }

    public LoginPage enterUsername(String name){
        driver.findElement(username).sendKeys(name);
        return this;
    }

    public LoginPage enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public void submit(){
        driver.findElement(submitButton).click();
    }

}
