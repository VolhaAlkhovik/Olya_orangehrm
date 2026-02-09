package AuthentificationAPI;

import static io.restassured.RestAssured.*;

import config.Config;
import java.util.Map;

public class AuthAPI {

  public static Map<String, String> getSessionCookies() {
    return given()
        .baseUri(Config.get("url.api"))
        .formParam("username", Config.get("app.username"))
        .formParam("password", Config.get("app.password"))
        .post("/validate")
        .then()
        .extract()
        .cookies();
  }
}
