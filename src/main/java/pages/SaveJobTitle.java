package pages;

import entities.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SaveJobTitle extends BasePage {

  private By jobTitleinput =
      By.xpath(
          "//div[@class='oxd-input-group__label-wrapper']/following::input[contains(@class,'oxd-input')][1]");
  private By saveButton = By.xpath("//button[@type = 'submit']");

  public SaveJobTitle(WebDriver driver) {
    super(driver);
  }

  public void enterJobTitle(Job jobTitle) {
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    driver.findElement(jobTitleinput).sendKeys(jobTitle.getJobTitlefield());
    driver.findElement(saveButton).click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")));
  }
}
