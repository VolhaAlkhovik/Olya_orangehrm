import base.BaseTest;
import config.Config;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners({AllureTestNg.class})
@Epic("Authentication")
public class LoginSuccess extends BaseTest {

  @Feature("Login")
  @Story("User is able to login to the app")
  @Test(description = "Sucess login with valid credentials")
  public void testSuccessLogin() {

    String username = Config.get("app.username");
    String password = Config.get("app.password");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(username, password);

    Assert.assertEquals(
        driver.getCurrentUrl(), Config.get("dashboard.url"), "Авторизация не прошла");
  }
}
