package core;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

  private WebDriverWait wait;

  public WaitUtils(WebDriver driver, long timeout) {
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
  }

  public WebElement waitForVisibility(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public WebElement waitForClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void waitForLoaderToDisappear() {
    wait.until(
        ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
  }

  public List<WebElement> waitforAllVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }
}
