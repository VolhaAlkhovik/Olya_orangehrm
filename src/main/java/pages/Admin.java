package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Admin extends BasePage {

  private By jobDropDown = By.xpath("(//i[contains(@class, 'oxd-icon bi-chevron-down')])[2]");
  private By jobTitle =
      By.xpath(
          "//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and normalize-space(text())='Job Titles']");

  public Admin(WebDriver driver) {
    super(driver);
  }

  public Admin clickJobButton() {
    wait.until(ExpectedConditions.elementToBeClickable(jobDropDown));
    driver.findElement(jobDropDown).click();
    return this;
  }

  public JobTitle clickJobTitle() {
    wait.until(ExpectedConditions.elementToBeClickable(jobDropDown));
    driver.findElement(jobTitle).click();
    return new JobTitle(driver);
  }
}
