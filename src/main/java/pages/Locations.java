package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locations extends BasePage {

  private By addLocation = By.cssSelector("i.bi-plus");
  private By countryDropDown = By.cssSelector("div.oxd-select-text-input");
  private By countryOption = By.cssSelector("div.oxd-select-option");
  private By searchButton = By.xpath("//button[@type = 'submit']");
  private By dataRows = By.cssSelector("div.oxd-table-body div.oxd-table-row");
  private By tableCells = By.cssSelector("div.oxd-table-cell[role='cell']");

  public Locations(WebDriver driver) {
    super(driver);
  }

  public SaveLocation addingLocation() {
    click(addLocation);
    return new SaveLocation(driver);
  }

  public Locations filterByCountry(String country) {
    selectCustomDropDown(countryDropDown, countryOption, country);
    click(searchButton);
    return new Locations(driver);
  }

  public List<String> getFilteredCountries() {
    return wait.waitforAllVisible(dataRows).stream()
        .map(row -> row.findElements(tableCells))
        .filter(cells -> cells.size() > 3)
        .map(cells -> cells.get(3).getText().trim())
        .toList();
  }
}
