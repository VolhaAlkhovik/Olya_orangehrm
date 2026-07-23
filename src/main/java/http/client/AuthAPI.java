package http.client;

import static io.restassured.RestAssured.given;

import config.Config;
import io.restassured.response.Response;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthAPI {

  private AuthAPI() {

  }

  public static Map<String, String> getSessionCookies() {

    Response loginResponse = given().baseUri(Config.getProperty("url.api")).get("/login");

    String html = loginResponse.getBody().asString();
    String csrfToken = html.split(":token=\"&quot;")[1].split("&quot;\"")[0];

    Response validateResponse =
        given()
            .baseUri(Config.getProperty("url.api"))
            .cookies(loginResponse.cookies())
            .formParam("username", Config.getProperty("app.username"))
            .formParam("password", Config.getProperty("app.password"))
            .formParam("_token", csrfToken)
            .post("/validate");

    log.info("Response cookies: {}", validateResponse.cookies());
    log.info("CsrfToken", csrfToken);
    return validateResponse.cookies();
  }
}
