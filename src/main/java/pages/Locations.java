package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locations extends BasePage {

  private By addLocation = By.cssSelector("i.bi-plus");
  private By countryDropDown = By.cssSelector("div.oxd-select-text-input");
  private By countryOption = By.cssSelector("div.oxd-select-option");
  private By searchButton = By.xpath("//button[@type = 'submit']");
  private By tableHeaders =
      By.cssSelector("div.oxd-table-header-cell.oxd-padding-cell.oxd-table-th");
  private By dataRows = By.cssSelector("div.oxd-table-body div.oxd-table-row");
  private By tableCells = By.cssSelector("div.oxd-table-header div.oxd-table-cell");

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

  public int getColumnIndex(String columnName) {
    List<WebElement> headers = wait.waitforAllVisible(tableHeaders);

    for (int i = 0; i < headers.size(); i++) {
      if (headers.get(i).getText().trim().equalsIgnoreCase(columnName)) {
        return i;
      }
    }
    throw new RuntimeException("Column not found" + columnName);
  }

  public List<String> getFilteredCountries() {

    wait.waitForLoaderToDisappear();
    int countryIndex = getColumnIndex("Country");

    return wait.waitforAllVisible(dataRows).stream()
        .map(row -> row.findElements(tableCells))
        .filter(cells -> cells.size() > countryIndex)
        .map(cells -> cells.get(countryIndex).getText().trim())
        .toList();
  }
}
