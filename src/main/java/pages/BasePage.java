package pages;

import java.time.Duration;

import core.DriverUtils;
import core.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{

  protected WebDriver driver;
  protected WaitUtils waitUtils;
  protected DriverUtils driverUtils;

  private static final long DEFAULT_TIMEOUT_SEC = 10;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.driverUtils = new DriverUtils(driver, DEFAULT_TIMEOUT_SEC);
  }

  public void click(By locator) {
    waitUtils.waitForClickable(locator).click();
  }

  public WebElement findElement(By locator) {
    return waitUtils.waitForVisibility(locator);
  }

}
