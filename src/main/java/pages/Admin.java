package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin extends BasePage {

  private By jobDropDown = By.xpath("(//i[contains(@class, 'oxd-icon bi-chevron-down')])[2]");
  private By jobTitle =
      By.xpath(
          "//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and normalize-space(text())='Job Titles']");
  private By organisationDropDown =
      By.xpath(
          "//span[contains(@class, 'oxd-topbar-body-nav-tab-item') and normalize-space(.)='Organization']");
  private By locations =
      By.xpath("//a[contains(@class,'nav-tab-link') and normalize-space(.)='Locations']");

  public Admin(WebDriver driver) {
    super(driver);
  }

  @Step("Open \"Job\" dropdown")
  public Admin clickJobButton() {
    click(jobDropDown);
    return this;
  }

  @Step("Open \"Job Titles\"")
  public JobTitleView clickJobTitle() {
    click(jobTitle);
    return new JobTitleView(driver);
  }

  @Step("Open \"Organizaation\" dropdown and click \"Locations\" module ")
  public Locations clickLocations() {
    click(organisationDropDown);
    click(locations);
    return new Locations(driver);
  }
}
