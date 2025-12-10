import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginSuccess extends BaseTest {
    @Parameters({"username", "password"})
    @Test
    public void testSuccessLogin(String username, String password) {
        Assert.assertEquals(username, "Admin", "Username is incorrect");
        Assert.assertEquals(password, "admin123","Password is incorrect");
    }
}