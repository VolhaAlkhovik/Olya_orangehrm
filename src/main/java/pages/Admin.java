package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin extends BasePage {

  private By jobDropDown = By.xpath("(//i[contains(@class, 'oxd-icon bi-chevron-down')])[2]");
  private By jobTitle =
      By.xpath(
          "//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and normalize-space(text())='Job Titles']");

  public Admin(WebDriver driver) {
    super(driver);
  }

  public Admin clickJobButton() {
    click(jobDropDown);
    return this;
  }

  public JobTitle clickJobTitle() {
    click(jobTitle);
    return new JobTitle(driver);
  }
}
