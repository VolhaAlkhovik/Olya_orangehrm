import entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.AddingEmployee;
import pages.Dashboard;
import pages.LoginPage;
import pages.PIM;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployee() {

        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = loginPage.successLogin("Admin", "admin123");

        PIM pim = dashboard.openPIM();

        AddingEmployee addingEmployee = pim.openAddEmployee();

        Employee employee = new Employee("FirstTestName", "MiddleTestName","LastTestName");
        addingEmployee.addEmployee(employee);
    }
}