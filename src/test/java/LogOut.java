import base.BaseTest;
import config.Config;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPanel;
import pages.LoginPage;

@Epic("Log out")
public class LogOut extends BaseTest {

  @Test(description = "Log out")
  public void logOut() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));

    Assert.assertEquals(
        driver.getCurrentUrl(), Config.get("dashboard.url"), "Авторизация не прошла");

    HeaderPanel headerPanel = new HeaderPanel(driver);
    headerPanel.clickUserName().clickLogOut();

    Assert.assertEquals(driver.getCurrentUrl(), Config.get("app.url"), "Log out не осуществился");
  }
}
