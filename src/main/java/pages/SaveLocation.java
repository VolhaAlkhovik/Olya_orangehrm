package pages;

import entities.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveLocation extends BasePage {

  private By nameLocation =
      By.xpath("//label[normalize-space(.)='Name']/parent::div/following-sibling::div/input");
  private By city =
      By.xpath("//label[normalize-space(.)='City']/parent::div/following-sibling::div/input");
  private By zip =
      By.xpath(
          "//label[normalize-space(.)='Zip/Postal Code']/parent::div/following-sibling::div/input");
  private By phone =
      By.xpath("//label[normalize-space(.)='Phone']/parent::div/following-sibling::div/input");
  private By countryDropdown = By.cssSelector("div.oxd-select-text-input");
  private By optionLocation = By.cssSelector("div.oxd-select-option");
  private By saveButton = By.xpath("//button[@type = 'submit']");
  private By successToaster =
      By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");

  public SaveLocation(WebDriver driver) {
    super(driver);
  }

  public Locations fillLocationForm(Location location) {
    type(nameLocation, location.getName());
    type(city, location.getCity());
    type(zip, location.getZip());
    type(phone, location.getPhone());
    selectCustomDropDown(countryDropdown, optionLocation, "Finland");
    click(saveButton);
    return new Locations(driver);
  }

  public boolean isSuccessToasterDisplayed() {
    return isDisplayed(successToaster);
  }
}
