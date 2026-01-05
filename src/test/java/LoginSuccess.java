import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginSuccess extends BaseTest {

  @Test
  public void testSuccessLogin() {

    String username = Config.get("app.username");
    String password = Config.get("app.password");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(username, password);

    Assert.assertEquals(
        driver.getCurrentUrl(), Config.get("dashboard.url"), "Авторизация не прошла");
  }
}
