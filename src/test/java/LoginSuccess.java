import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginSuccess extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void testSuccessLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(username, password);

        String URL_AfterLogin = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), URL_AfterLogin, "Авторизация не прошла");
    }
}