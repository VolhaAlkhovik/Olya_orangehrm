package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPanel extends BasePage {

  private By user = By.className("oxd-userdropdown");
  private By logOutButton = By.xpath("//a[@href='/web/index.php/auth/logout']");

  public HeaderPanel(WebDriver driver) {
    super(driver);
  }

  public HeaderPanel clickUserName() {
    wait.waitForVisibility(user);
    click(user);
    return this;
  }

  public LoginPage clickLogOut() {
    click(logOutButton);
    return new LoginPage(driver);
  }
}
