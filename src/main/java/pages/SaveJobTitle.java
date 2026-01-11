package pages;

import entities.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveJobTitle extends BasePage {

  private By jobTitleinput =
      By.xpath(
          "//div[@class='oxd-input-group__label-wrapper']/following::input[contains(@class,'oxd-input')][1]");
  private By saveButton = By.xpath("//button[@type = 'submit']");
  private By jobDescription =
      By.xpath(
          "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'][1]");
  private By successToaster =
      By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");

  public SaveJobTitle(WebDriver driver) {
    super(driver);
  }

  public SaveJobTitle enterJobTitle(Job jobTitle) {
    type(jobTitleinput, jobTitle.getJobTitlefield());
    type(jobDescription, jobTitle.getJobDescription());
    click(saveButton);
    wait.waitForVisibility(successToaster);
    return this;
  }

  public boolean isSuccessToasterDisplayed(){
      return isDisplayed(successToaster);
  }
}
