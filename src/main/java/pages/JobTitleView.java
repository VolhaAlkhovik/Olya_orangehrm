package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitleView extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");
  private By yesDeleteButton =
      By.xpath(
          "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
  private By successButton =
      By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");
  private By successMessageDeleted =
      By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");

  public JobTitleView(WebDriver driver) {
    super(driver);
  }

  public SaveJobTitle clickAddButton() {
    click(addButton);
    return new SaveJobTitle(driver);
  }

  public JobTitleView removeJobTitle(String jobTitle) {
    By rowJobTitle =
        By.xpath(
            "//div[normalize-space()='"
                + jobTitle
                + "']"
                + "/ancestor::div[contains(@class,'row')]//button//i[contains(@class,'bi-trash')]");
    click(rowJobTitle);
    return this;
  }

  public JobTitleView clickYesButton() {
    click(yesDeleteButton);
    return this;
  }

  public JobTitleView checkSuccessToaster() {
    isDisplayed(successButton);
    isDisplayed(successMessageDeleted);
    return this;
  }
}
