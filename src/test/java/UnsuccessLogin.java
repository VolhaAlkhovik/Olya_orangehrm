import base.BaseTest;
import config.Config;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

@Epic("Authentication")
public class UnsuccessLogin extends BaseTest {

  @Feature("Login")
  @Story("User is unable to login to the app")
  @Test(dataProvider = "getCredentials", description = "Failed login with invalid credentials")
  void invalidCredentialsTest(String username, String password) {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.failedLogin(username, password);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(loginPage.getTextOfFailedLogin(), "Invalid credentials");
    softAssert.assertEquals(driver.getCurrentUrl(), Config.get("app.url"));
    softAssert.assertAll();
    driver.navigate().refresh();
  }

  @DataProvider(name = "getCredentials")
  public Object[][] getCredentials() {
    return new Object[][] {
      {"Admin", RandomString.make()},
      {RandomString.make(), "admin123"},
      {RandomString.make(), RandomString.make()}
    };
  }
}
