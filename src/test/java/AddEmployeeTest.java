import base.BaseTest;
import config.Config;
import entities.Employee;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Epic("PIM module")
public class AddEmployeeTest extends BaseTest {

  @Test(description = "Adding new employee to PIM module")
  public void addEmployee() {

    Employee employee =
        Employee.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().nameWithMiddle())
            .lastName(faker.name().lastName())
            .build();

    LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard =
        loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
    PIM pim = dashboard.openPIM();

    AddingEmployee addingEmployee = pim.openAddEmployee();

    addingEmployee.addEmployee(employee);

    Assert.assertTrue(
        addingEmployee.isSuccessToasterDisplayed(), "Success toaster is not displayed");
  }
}
