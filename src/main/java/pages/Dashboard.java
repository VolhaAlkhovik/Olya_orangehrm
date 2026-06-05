package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

  private By pim = By.xpath("//a[@href ='/web/index.php/pim/viewPimModule']");
  private By timeAtWork =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][1]");
  private By myActions =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][2]");
  private By quickLaunch =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][3]");
  private By buzzLatestPhoto =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][4]");
  private By employeesOnLeaveToday =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][5]");
  private By employeesDistributionBySubUnit =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][6]");
  private By employeesDistributionByLocation =
      By.xpath(
          "//div[@class = 'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][7]");

  public Dashboard(WebDriver driver) {
    super(driver);
  }

  @Step("Open PIM module")
  public PIM openPIM() {
    click(pim);
    return new PIM(driver);
  }

  @Step("\"Time at Work\" block is visible on the Dashboard")
  public boolean isTimeAtWorkIsVisible() {
    return isDisplayed(timeAtWork);
  }

  @Step("\"My actions\" block is visible on the Dashboard")
  public boolean isMyActionsIsVisible() {
    return isDisplayed(myActions);
  }

  @Step("\"Quich Launch\" block is visible on the Dashboard")
  public boolean isQuickLaunchIsVisible() {
    return isDisplayed(quickLaunch);
  }

  @Step("\"Buss Latest Posts\" block is visible on the Dashboard")
  public boolean isBuzzLatestPhotoIsVisible() {
    return isDisplayed(buzzLatestPhoto);
  }

  @Step("\"Employees On Leave Today\" block is visible on the Dashboard")
  public boolean isEmployeesOnLeaveTodayIsVisible() {
    return isDisplayed(employeesOnLeaveToday);
  }

  @Step("\"Employees Distribution By Location\" block is visible on the Dashboard")
  public boolean isEmployeesDistributionByLocationIsVisible() {
    return isDisplayed(employeesDistributionByLocation);
  }

  @Step("\"Employees Distribution By SubUnit\" block is visible on the Dashboard")
  public boolean isEmployeesDistributionBySubUnitIsVisible() {
    return isDisplayed(employeesDistributionBySubUnit);
  }
}
