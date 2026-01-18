import com.github.javafaker.Faker;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DriverManager;

public class BaseTest {

  protected WebDriver driver;
  protected static final String login_url = Config.get("app.url");
  protected Faker faker = new Faker();

  @BeforeMethod
  public void setUp() {
    driver = DriverManager.getDriver();
    driver.manage().window().maximize();
    driver.get(login_url);
  }

  @AfterMethod
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
