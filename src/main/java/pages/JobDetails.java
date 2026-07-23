package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobDetails extends BasePage {

  private By jobTitle =
      By.xpath(
          "//label[normalize-space(text())='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
  private By jobSalesPersonOption =
      By.xpath("//div[@class='oxd-select-option']//span[text()='Sales Representative']");
  private By saveButton = By.xpath("//button[@type = 'submit']");
  private By personalDetailsButton = By.xpath("//a[contains(@href,'viewPersonalDetails')]");

  public JobDetails(WebDriver driver) {
    super(driver);
  }

  @Step("Change job title for person and save it")
  public JobDetails changeJobTitle() {
    wait.waitForLoaderToDisappear();
    wait.waitForClickable(jobTitle);
    selectCustomDropDown(jobTitle, jobSalesPersonOption, "Sales Representative");
    click(saveButton);
    return new JobDetails(driver);
  }

  @Step("Click \"Personal details\" button")
  public PersonalDetails clickPersonalDetails() {
    click(personalDetailsButton);
    return new PersonalDetails(driver);
  }
}
