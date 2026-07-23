package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {

  private By sidepanel = By.className("oxd-sidepanel-body");
  private By admin = By.xpath("//a[@href = '/web/index.php/admin/viewAdminModule']");
  private By pim = By.xpath("//a[contains(@href,'pim/viewPimModule')]");

  public SidePanel(WebDriver driver) {
    super(driver);
  }

  @Step("Open admin page")
  public Admin adminButton() {
    wait.waitForVisibility(sidepanel);
    click(admin);
    return new Admin(driver);
  }

  @Step("Open PIM page")
  public PIM pimButton() {
    click(pim);
    return new PIM(driver);
  }
}
