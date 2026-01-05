package pages;

import entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddingEmployee extends BasePage {

  private By firstName = By.name("firstName");
  private By middleName = By.name("middleName");
  private By lastName = By.name("lastName");
  private By submit = By.xpath("//button[@type = 'submit']");

  public AddingEmployee(WebDriver driver) {
    super(driver);
  }

  public void addEmployee(Employee employee) {
    waitUtils.waitForVisibility(firstName);
    findElement(firstName).sendKeys(employee.getFirstName());
    findElement(middleName).sendKeys(employee.getMiddleName());
    findElement(lastName).sendKeys(employee.getLastName());
    findElement(submit).click();
  }

  public void enterFirstName() {
    findElement(firstName).sendKeys("FirstTestName");
  }

  public void enterMiddleName() {
    findElement(middleName).sendKeys("MiddleTestName");
  }

  public void enterLastName() {
    findElement(lastName).sendKeys("LastTestName");
  }

  public void submitButton() {
    findElement(submit).click();
  }
}
