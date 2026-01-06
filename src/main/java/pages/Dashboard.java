package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

  private By pim = By.xpath("//a[@href ='/web/index.php/pim/viewPimModule']");

  public Dashboard(WebDriver driver) {
    super(driver);
  }

  public PIM openPIM() {
    click(pim);
    return new PIM(driver);
  }
}
