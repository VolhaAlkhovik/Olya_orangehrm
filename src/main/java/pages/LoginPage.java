package pages;

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
    wait.waitForVisibility(username);
    enterUsername(name).enterPassword(pass).submit();
    return new Dashboard(driver);
  }

  public LoginPage failedLogin(String name, String pass) {
    enterUsername(name).enterPassword(pass).submit();
    wait.waitForVisibility(errorMarker);
    return this;
  }

  public String getTextOfFailedLogin() {
    return getText(errorMarker);
  }

  public LoginPage enterUsername(String name) {
    type(username, name);
    return this;
  }

  public LoginPage enterPassword(String pass) {
    type(password, pass);
    return this;
  }

  public void submit() {
    click(submitButton);
  }
}
