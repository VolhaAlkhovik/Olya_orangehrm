import base.BaseTest;
import config.Config;
import java.util.List;

import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SidePanel;

@Epic("Admin module")
public class FilterByCountryTest extends BaseTest {

  @Test(description = "Searching filtered country")
  public void filterByCountry() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
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
