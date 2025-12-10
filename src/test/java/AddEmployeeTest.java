import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployee() {
        testLogin();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-filter']")));

        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name='firstName']")));

        driver
                .findElement(By.xpath("//div/input[@name='firstName']"))
                .sendKeys("FirstTestName");
        driver
                .findElement(By.xpath("//div/input[@name='middleName']"))
                .sendKeys("MiddleTestName");
        driver
                .findElement(By.xpath("//div/input[@name='lastName']"))
                .sendKeys("LastTestName");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
    }
}