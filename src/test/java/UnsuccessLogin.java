import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class UnsuccessLogin extends BaseTest{

    @Test(dataProvider = "getCredentials", description = "Failed login with invalid credentials")

    void invalidCredentialsTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.failedLogin(username, password);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getTextOfFailedLogin(), "Invalid credentials");
        softAssert.assertEquals(driver.getCurrentUrl(), LOGIN_URL);
        softAssert.assertAll();
        driver.navigate().refresh();
    }

    @DataProvider(name = "getCredentials")
    public Object[][] getCredentials(){
        return new Object[][]{
                {"Admin", RandomString.make()},
                { RandomString.make(), "admin123"},
                { RandomString.make(), RandomString.make()}
        };
    }
}
