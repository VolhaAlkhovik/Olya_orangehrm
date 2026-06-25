import base.BaseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.LoginPage;

public class DashboardElementsTest extends BaseTest {

  @Test
  public void checkDashboardElements() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.successLogin(Config.getProperty("app.username"), Config.getProperty("app.password"));

    Dashboard dashboard = new Dashboard(driver);

    Assert.assertEquals(
        driver.getCurrentUrl(), Config.getProperty("dashboard.url"), "Страница дашборда не открыта");

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(
        dashboard.isTimeAtWorkIsVisible(), "Блок TimeAtWorkIsVisible не отображается ");
    softAssert.assertTrue(dashboard.isQuickLaunchIsVisible(), "Блок QuickLaunch не отображается ");
    softAssert.assertTrue(dashboard.isMyActionsIsVisible(), "Блок MyActions не отображается ");
    softAssert.assertTrue(
        dashboard.isBuzzLatestPhotoIsVisible(), "Блок BuzzLatestPhoto не отображается");
    softAssert.assertTrue(
        dashboard.isEmployeesOnLeaveTodayIsVisible(), "Блок EmployeesOnLeaveToday не отображается");
    softAssert.assertTrue(
        dashboard.isEmployeesDistributionBySubUnitIsVisible(),
        "Блок EmployeesDistributionBySubUnit не отображается");
    softAssert.assertTrue(
        dashboard.isEmployeesDistributionByLocationIsVisible(),
        "Блок EmployeesDistributionByLocation не отображается");
    softAssert.assertAll();
  }
}
