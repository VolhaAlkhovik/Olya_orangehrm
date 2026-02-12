package base.http_client;

import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest extends BaseTest {

  protected static final String pim_module = Config.get("pim.url");

  @Test
  public void getPimModuleTest() {
    LoginAPI.loginWithCookies(driver);
    driver.get(pim_module);

    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(
        currentUrl.startsWith("https://opensource-demo.orangehrmlive.com/web/index.php/pim/"),
        "PIM модуль не открылся");

  }
}
