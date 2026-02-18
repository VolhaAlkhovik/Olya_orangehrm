package http.client;

import config.Config;
import java.util.Map;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginAPI {

  protected static final String DASHBOARD_URL = Config.get("dashboard.url");

  private LoginAPI() {

  }

  public static void loginWithCookies(WebDriver driver) {

    Map<String, String> cookies = AuthAPI.getSessionCookies();

    for (Map.Entry<String, String> entry : cookies.entrySet()) {
      Cookie cookie = new Cookie.Builder(entry.getKey(), entry.getValue()).path("/").build();

      driver.manage().addCookie(cookie);
    }
    driver.get(DASHBOARD_URL);
  }
}
