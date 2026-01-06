package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIM extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");

  public PIM(WebDriver driver) {
    super(driver);
  }

  public AddingEmployee openAddEmployee() {
    click(addButton);
    return new AddingEmployee(driver);
  }
}
