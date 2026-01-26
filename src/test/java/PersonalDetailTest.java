import com.fasterxml.jackson.annotation.JsonTypeInfo;
import config.Config;
import entities.Person;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.RandomDateFactory;

public class PersonalDetailTest extends BaseTest {

    Person person = Person.builder()
            .firstName(faker.name().firstName())
            .middleName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .otherId(faker.idNumber().valid())
            .driverLicenseNumber(faker.idNumber().ssnValid())
            .licenseExpirydate(RandomDateFactory.randomLicenseExpiry())
            .nationality("Belgian")
            .maritalStatus("Single")
            .dateOfBirth(RandomDateFactory.randomBirthDate())
            .gender("Male")
            .build();

    @Test
    public void searchSalesPersonAndFillForm() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(Config.get("app.username"), Config.get("app.password"));
        SidePanel sidePanel = new SidePanel(driver);

        PersonalDetails personalDetails = sidePanel
                .pimButton()
                .searchSalesJobTitle("Sales Representative");

        if (personalDetails == null) {
            personalDetails = sidePanel
                    .pimButton()
                    .openFirstEmployee()
                    .openjobDetails()
                    .changeJobTitle()
                    .clickPersonalDetails()
                    .fillForm(person);

            Assert.assertTrue(
                    personalDetails.isSuccessToasterDisplayed(), "Success toaster is not displayed");

        }
    }
}
