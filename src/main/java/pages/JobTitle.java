package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobTitle extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");

  public JobTitle(WebDriver driver) {
    super(driver);
  }

  public SaveJobTitle clickAddButton() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
    driver.findElement(addButton).click();
    return new SaveJobTitle(driver);
  }
}
