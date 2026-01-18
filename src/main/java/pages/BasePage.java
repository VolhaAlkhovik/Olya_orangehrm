package pages;

import core.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

  protected WebDriver driver;
  protected WaitUtils wait;
  private static final long DEFAULT_TIMEOUT_SEC = 10;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WaitUtils(driver, DEFAULT_TIMEOUT_SEC);
  }

  protected void click(By locator) {
    wait.waitForClickable(locator).click();
  }

  protected WebElement findElement(By locator) {
    return wait.waitForVisibility(locator);
  }

  protected void type(By locator, String text) {
    WebElement element = findElement(locator);
    wait.waitForClickable(locator);
    element.clear();
    element.sendKeys(text);
  }

  protected String getText(By locator) {
    return findElement(locator).getText();
  }

  protected boolean isDisplayed(By locator) {
    try {
      return findElement(locator).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
