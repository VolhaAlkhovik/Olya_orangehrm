import config.Config;
import entities.Employee;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddEmployeeTest extends BaseTest {

  @Test
  public void addEmployee() {

    Employee employee =
        Employee.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().nameWithMiddle())
            .lastName(faker.name().lastName())
            .build();

    LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard = loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
    PIM pim = dashboard.openPIM();

    AddingEmployee addingEmployee = pim.openAddEmployee();

    addingEmployee.addEmployee(employee);

    Assert.assertTrue(addingEmployee.isSuccessToasterDisplayed(),"Success toaster is not displayed");

  }
}
