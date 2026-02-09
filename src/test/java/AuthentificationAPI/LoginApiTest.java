package AuthentificationAPI;

import base.BaseTest;
import config.Config;
import org.testng.annotations.Test;

public class LoginApiTest extends BaseTest {

  protected static final String dashboard_url = Config.get("dashboard.url");

  @Test
  public void loginApiTest() throws InterruptedException {
    LoginAPI.loginWithCookies(driver);
    Thread.sleep(5000);
    driver.get(dashboard_url);
    Thread.sleep(5000);
  }
}
