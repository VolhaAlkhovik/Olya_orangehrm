package pages;

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

  public PIM openPIM() {
    click(pim);
    return new PIM(driver);
  }

  public boolean isTimeAtWorkIsVisible() {
    return isDisplayed(timeAtWork);
  }

  public boolean isMyActionsIsVisible() {
    return isDisplayed(myActions);
  }

  public boolean isQuickLaunchIsVisible() {
    return isDisplayed(quickLaunch);
  }

  public boolean isBuzzLatestPhotoIsVisible() {
    return isDisplayed(buzzLatestPhoto);
  }

  public boolean isEmployeesOnLeaveTodayIsVisible() {
    return isDisplayed(employeesOnLeaveToday);
  }

  public boolean isEmployeesDistributionByLocationIsVisible() {
    return isDisplayed(employeesDistributionByLocation);
  }

  public boolean isEmployeesDistributionBySubUnitIsVisible() {
    return isDisplayed(employeesDistributionBySubUnit);
  }
}
