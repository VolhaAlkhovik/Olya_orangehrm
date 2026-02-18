import config.Config;
import entities.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SaveLocation;
import pages.SidePanel;

public class AddLocationTest extends BaseTest {

  @Test
  public void addLocation() {

    Location location =
        Location.builder()
            .name(faker.company().name())
            .city(faker.address().city())
            .zip(faker.address().zipCode())
            .phone(faker.phoneNumber().cellPhone())
            .build();

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
    SidePanel sidePanel = new SidePanel(driver);
    sidePanel.adminButton().clickLocations().addingLocation();

    SaveLocation saveLocation = new SaveLocation(driver);
    saveLocation.fillLocationForm(location);

    Assert.assertTrue(saveLocation.isSuccessToasterDisplayed(), "Success toaster is not displayed");
  }
}
