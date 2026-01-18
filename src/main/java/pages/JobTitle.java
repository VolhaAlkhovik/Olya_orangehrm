package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitle extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");

  public JobTitle(WebDriver driver) {
    super(driver);
  }

  public SaveJobTitle clickAddButton() {
    click(addButton);
    return new SaveJobTitle(driver);
  }
}
