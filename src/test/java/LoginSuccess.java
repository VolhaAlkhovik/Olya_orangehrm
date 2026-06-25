import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginSuccess extends BaseTest {

  @Test
  public void testSuccessLogin() {

    String username = Config.getProperty("app.username");
    String password = Config.getProperty("app.password");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(username, password);

    Assert.assertEquals(
        driver.getCurrentUrl(), Config.getProperty("dashboard.url"), "Авторизация не прошла");
  }
}
