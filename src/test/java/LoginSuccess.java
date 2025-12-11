import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginSuccess extends BaseTest {
    @Parameters({"username", "password"})
    @Test
    public void testSuccessLogin(String username, String password) {
        testLogin();
        String URL_AfterLogin = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), URL_AfterLogin, "Авторизация не прошла");
    }
}