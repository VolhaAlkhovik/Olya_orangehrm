import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployee() {
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-filter']")));

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

        driver
                .findElement(By.xpath("//input[contains(@class, 'active orangehrm-firstname')]"))
                .sendKeys("FirstTestName");
        driver
                .findElement(By.xpath("//input[contains(@class, 'active orangehrm-middlename')]"))
                .sendKeys("MiddleTestName");
        driver
                .findElement(By.xpath("//input[contains(@class, 'active orangehrm-lastname')]"))
                .sendKeys("LastTestName");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
    }
}