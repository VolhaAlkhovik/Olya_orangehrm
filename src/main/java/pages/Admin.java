package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin extends BasePage {

  private By jobDropDown = By.xpath("(//i[contains(@class, 'oxd-icon bi-chevron-down')])[2]");
  private By jobTitle =
      By.xpath(
          "//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and normalize-space(text())='Job Titles']");
  private By organisationDropDown = By.xpath("//span[contains(@class, 'oxd-topbar-body-nav-tab-item') and normalize-space(.)='Organization']");
  private By locations = By.xpath("//a[contains(@class,'nav-tab-link') and normalize-space(.)='Locations']");

  public Admin(WebDriver driver) {
    super(driver);
  }

  public Admin clickJobButton() {
    click(jobDropDown);
    return this;
  }

  public JobTitleView clickJobTitle() {
    click(jobTitle);
    return new JobTitleView(driver);
  }

  public Locations clickLocations() {
    click(organisationDropDown);
    click(locations);
    return new Locations(driver);
  }
}
