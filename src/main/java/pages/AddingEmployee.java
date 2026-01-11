package pages;

import entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddingEmployee extends BasePage {

  private By firstName = By.name("firstName");
  private By middleName = By.name("middleName");
  private By lastName = By.name("lastName");
  private By submit = By.xpath("//button[@type = 'submit']");
  private By successToaster = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");

  public AddingEmployee(WebDriver driver) {
    super(driver);
  }

  public void addEmployee(Employee employee) {
    type(firstName, employee.getFirstName());
    type(middleName, employee.getMiddleName());
    type(lastName, employee.getLastName());
    click(submit);
  }

    public boolean isSuccessToasterDisplayed(){
        return isDisplayed(successToaster);
    }

}
