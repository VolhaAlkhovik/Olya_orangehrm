import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidePanel;

public class FilterByCountryTest extends BaseTest{

    @Test
    public void filterByCountry(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
        SidePanel sidePanel = new SidePanel(driver);
        sidePanel.adminButton()
                .clickLocations()
                .filterByCountry();

    }
}
