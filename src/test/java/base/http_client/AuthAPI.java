package base.http_client;

import static io.restassured.RestAssured.*;

import config.Config;
import io.restassured.response.Response;
import java.util.Map;

public class AuthAPI {

  public static Map<String, String> getSessionCookies() {

    Response loginResponse = given().baseUri(Config.get("url.api")).get("/login");

    String html = loginResponse.getBody().asString();
    String csrfToken = html.split(":token=\"&quot;")[1].split("&quot;\"")[0];

    Response validateResponse =
        given()
            .baseUri(Config.get("url.api"))
            .cookies(loginResponse.cookies())
            .formParam("username", Config.get("app.username"))
            .formParam("password", Config.get("app.password"))
            .formParam("_token", csrfToken)
            .post("/validate");

    return validateResponse.cookies();
  }
}
