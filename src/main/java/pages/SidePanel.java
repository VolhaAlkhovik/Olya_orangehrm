package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SidePanel extends BasePage {

  private By sidepanel = By.className("oxd-sidepanel-body");
  private By admin = By.xpath("//a[@href = '/web/index.php/admin/viewAdminModule']");

  public SidePanel(WebDriver driver) {
    super(driver);
  }

  public Admin adminButton() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(sidepanel));
    driver.findElement(admin).click();
    return new Admin(driver);
  }
}
