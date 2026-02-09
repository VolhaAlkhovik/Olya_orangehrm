package AuthentificationAPI;

import base.BaseTest;
import config.Config;
import org.testng.annotations.Test;

public class LoginApiTest extends BaseTest {

  protected static final String dashboard_url = Config.get("dashboard.url");

  @Test
  public void loginApiTest() {
    LoginAPI.loginWithCookies(driver);
    driver.get(dashboard_url);
  }
}
