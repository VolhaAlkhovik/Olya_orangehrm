package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitleView extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");
  private By yesDeleteButton = By.cssSelector("button.oxd-button--label-danger");
  private By successButton = By.cssSelector("div.oxd-toast--success");
  private By successMessageDeleted = By.cssSelector("p.oxd-text--toast-message");

  public JobTitleView(WebDriver driver) {
    super(driver);
  }

  @Step("Click \"Add\" button for adding job title ")
  public SaveJobTitle clickAddButton() {
    click(addButton);
    return new SaveJobTitle(driver);
  }

  @Step("Remove job title")
  public JobTitleView removeJobTitle(String jobTitle) {
    By rowJobTitle =
        By.xpath(
            "//div[contains(normalize-space(.),'"
                + jobTitle
                + "')]"
                + "/ancestor::div[contains(@class,'row')]//button//i[contains(@class,'bi-trash')]");
    click(rowJobTitle);
    return this;
  }

  @Step("Submit removing")
  public JobTitleView clickYesButton() {
    click(yesDeleteButton);
    return this;
  }

  public boolean isJobTitleDeleted() {
    return isDisplayed(successMessageDeleted);
  }
}
