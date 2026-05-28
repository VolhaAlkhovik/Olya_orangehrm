package base;

import com.github.javafaker.Faker;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DriverManager;

import java.lang.reflect.Method;

public class BaseTest {

  protected WebDriver driver;
  protected static final String login_url = Config.get("app.url");
  protected Faker faker = new Faker();

  @BeforeMethod
  public void setUp(Method method) {
    DriverManager.setTestName(method.getName());
    driver = DriverManager.getDriver();
    driver.manage().window().maximize();
    driver.get(login_url);
  }

  @AfterMethod
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
