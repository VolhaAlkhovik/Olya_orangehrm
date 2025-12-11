import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void testLogin() {

        driver.get(LOGIN_URL);
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class = 'oxd-userdropdown-tab']")));
    }
}