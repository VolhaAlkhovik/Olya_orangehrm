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

    public void addEmployee (Employee employee){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        driver.findElement(firstName).sendKeys(employee.getFirstName());
        driver.findElement(middleName).sendKeys(employee.getMiddleName());
        driver.findElement(lastName).sendKeys(employee.getLastName());
        driver.findElement(submit).click();
    }

    public void enterFirstName(){
        driver.findElement(firstName).sendKeys("FirstTestName");
    }

    public void enterMiddleName(){
        driver.findElement(middleName).sendKeys("MiddleTestName");
    }

    public void enterLastName(){
        driver.findElement(lastName).sendKeys("LastTestName");
    }

    public void submitButton(){
        driver.findElement(submit).click();
    }
}
