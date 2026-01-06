package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {

  private By sidepanel = By.className("oxd-sidepanel-body");
  private By admin = By.xpath("//a[@href = '/web/index.php/admin/viewAdminModule']");

  public SidePanel(WebDriver driver) {
    super(driver);
  }

  public Admin adminButton() {
    wait.waitForVisibility(sidepanel);
    click(admin);
    return new Admin(driver);
  }
}
