package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard  extends BasePage {

    private By pim = By.xpath("//a[@href ='/web/index.php/pim/viewPimModule']");

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public PIM openPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pim));
        driver.findElement(pim).click();
        return new PIM(driver);
    }
}
