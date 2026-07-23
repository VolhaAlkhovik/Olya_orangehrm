package base;

import com.github.javafaker.Faker;
import config.Config;
import io.qameta.allure.testng.AllureTestNg;
import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DriverManager;
import java.lang.reflect.Method;

@Listeners({
        AllureTestNg.class,
        ScreenshotListener.class
})
public class BaseTest {

  protected WebDriver driver;
  protected static final String login_url = Config.getProperty("app.url");
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
