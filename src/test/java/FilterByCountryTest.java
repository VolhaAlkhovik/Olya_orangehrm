import base.BaseTest;
import config.Config;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidePanel;

public class FilterByCountryTest extends BaseTest {

  @Test
  public void filterByCountry() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.getProperty("app.username"), Config.getProperty("app.password"));
    List<String> countries =
        new SidePanel(driver)
            .adminButton()
            .clickLocations()
            .filterByCountry("Finland")
            .getFilteredCountries();

    for (String country : countries) {
      Assert.assertEquals(country, "Finland", "Country is not found");
    }
  }
}
