package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private By username = By.name("username");
  private By password = By.name("password");
  private By submitButton = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
  private By dashboardMarker =
      By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
  private By errorMarker = By.cssSelector("p.oxd-alert-content-text");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage login(String name, String pass) {
    enterUsername(name).enterPassword(pass).submit();
    return this;
  }

  public Dashboard successLogin(String name, String pass) {
    enterUsername(name).enterPassword(pass).submit();
    return new Dashboard(driver);
  }

  @Step("")
  public LoginPage failedLogin(String name, String pass) {
    enterUsername(name).enterPassword(pass).submit();
    wait.waitForVisibility(errorMarker);
    return this;
  }

  public String getTextOfFailedLogin() {
    return getText(errorMarker);
  }

 @Step("Enter username")
  public LoginPage enterUsername(String name) {
    type(username, name);
    return this;
  }

  @Step("Enter password")
  public LoginPage enterPassword(String pass) {
    type(password, pass);
    return this;
  }
  @Step("Click submit button")
  public void submit() {
    click(submitButton);
  }
}
