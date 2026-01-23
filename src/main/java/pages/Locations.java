package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locations extends BasePage {

    private By addLocation = By.cssSelector("i.bi-plus");
    private By countryDropDown = By.cssSelector("div.oxd-select-text-input");
    private By countryOption = By.cssSelector("div.oxd-select-option");
    private By searchButton = By.xpath("//button[@type = 'submit']");

    public Locations(WebDriver driver){
        super(driver);
    }

    public SaveLocation addingLocation(){
        click(addLocation);
        return new SaveLocation(driver);
    }

    public Locations filterByCountry(){
        selectCustomDropDown(countryDropDown, countryOption, "Finland");
        click(searchButton);
        return new Locations(driver);
    }
}
