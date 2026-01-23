package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.sql.SQLOutput;
import java.util.List;

public class PIM extends BasePage {

  private By addButton = By.xpath("//button[text()=' Add ']");
  By rowJobTitle = By.xpath(
          "//div[contains(@class,'row')]//button//i[contains(@class,'bi-pencil')]"
  );

  public PIM(WebDriver driver) {
    super(driver);
  }

  public AddingEmployee openAddEmployee() {
    click(addButton);
    return new AddingEmployee(driver);
  }

  public PersonalDetails openFirstEmployee(){
    click(rowJobTitle);
    wait.waitForVisibility(By.xpath("//h6[text()='Personal Details']"));
    return new PersonalDetails(driver);
  }

  public PersonalDetails searchSalesJobTitle(String jobTitle) {
    By rowJobTitle =
            By.xpath(
                    "//div[contains(normalize-space(.),'"
                            + jobTitle
                            + "')]"
                            + "/ancestor::div[contains(@class,'row')]//button//i[contains(@class,'bi-pencil')]");

    List<WebElement> elements = driver.findElements(rowJobTitle);

    if(elements.isEmpty()){;
      return null;
    }
    elements.get(0).click();
    return new PersonalDetails(driver);
  }


}
