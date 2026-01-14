import config.Config;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.Dashboard;
import pages.HeaderPanel;
import pages.LoginPage;

public class LogOut extends BaseTest{

    @Test
    public void logOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));

        Assert.assertEquals(
                driver.getCurrentUrl(), Config.get("dashboard.url"), "Авторизация не прошла");

        HeaderPanel headerPanel = new HeaderPanel(driver);
        headerPanel.clickUserName().clickLogOut();

        Assert.assertEquals(driver.getCurrentUrl(), Config.get("app.url"), "Log out не осуществился");
    }
}
