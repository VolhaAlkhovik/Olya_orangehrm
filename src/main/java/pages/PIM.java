package pages;

import java.util.List;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIM extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");
  private By rowJobTitleGeneral =
      By.xpath("//div[contains(@class,'row')]//button//i[contains(@class,'bi-pencil')]");

  public PIM(WebDriver driver) {
    super(driver);
  }

  @Step("Open \"Add Employee\" page")
  public AddingEmployee openAddEmployee() {
    click(addButton);
    return new AddingEmployee(driver);
  }

  @Step("Open personal details for first employee from the list")
  public PersonalDetails openFirstEmployee() {
    click(rowJobTitleGeneral);
    wait.waitForVisibility(By.xpath("//h6[text()='Personal Details']"));
    return new PersonalDetails(driver);
  }

  @Step("Searching employee by job title")
  public PersonalDetails searchSalesJobTitle(String jobTitle) {
    By rowJobTitle =
        By.xpath(
            "//div[contains(normalize-space(.),'"
                + jobTitle
                + "')]"
                + "/ancestor::div[contains(@class,'row')]//button//i[contains(@class,'bi-pencil')]");

    List<WebElement> elements = driver.findElements(rowJobTitle);

    if (elements.isEmpty()) {
      return null;
    }
    elements.get(0).click();
    return new PersonalDetails(driver);
  }
}
