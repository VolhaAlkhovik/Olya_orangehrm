import base.BaseTest;
import config.Config;
import entities.Location;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SaveLocation;
import pages.SidePanel;

@Epic("Admin module")
public class AddLocationTest extends BaseTest {

  @Story("Organization")
  @Test(description = "Adding location")
  @Flaky
  public void addLocation() {

    Location location =
        Location.builder()
            .name(faker.company().name())
            .city(faker.address().city())
            .zip(faker.address().zipCode())
            .phone(faker.phoneNumber().cellPhone())
            .build();

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.getProperty("app.username"), Config.getProperty("app.password"));
    SidePanel sidePanel = new SidePanel(driver);
    sidePanel.adminButton().clickLocations().addingLocation();

    SaveLocation saveLocation = new SaveLocation(driver);
    saveLocation.fillLocationForm(location);

    Assert.assertTrue(saveLocation.isSuccessToasterDisplayed(), "Success toaster is not displayed");
  }
}
