package pages;

import core.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

  protected WebDriver driver;
  protected WaitUtils wait;
  private static final long DEFAULT_TIMEOUT_SEC = 20;

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
    wait.waitForLoaderToDisappear();
    WebElement element = findElement(locator);

    element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    element.sendKeys(Keys.DELETE);

    if (text != null && !text.isEmpty()) {
      element.sendKeys(text);
    }
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

  protected void selectCustomDropDown(By dropdownLocator, By optionalLocator, String expectedValue){
    wait.waitForLoaderToDisappear();

    WebElement dropdown = wait.waitForClickable(dropdownLocator);
    String currentValue = dropdown.getText().trim();

    if (currentValue.equalsIgnoreCase(expectedValue)) {
      System.out.println("Dropdown already has value: " + expectedValue);
      return;
    }

    dropdown.click();
    wait.waitForClickable(optionalLocator);
    findElement(optionalLocator).click();
  }

  protected void selectRadio(By locator){
    wait.waitForLoaderToDisappear();
    WebElement radio = findElement(locator);
    if(!radio.isSelected()){
      radio.click();
    }
  }

}
