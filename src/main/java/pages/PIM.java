package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIM extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");

  public PIM(WebDriver driver) {
    super(driver);
  }

  public AddingEmployee openAddEmployee() {
    waitUtils.waitForVisibility(addButton);
    findElement(addButton).click();
    return new AddingEmployee(driver);
  }
}
