package pages;

import entities.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails extends BasePage {

    private By firstName = By.name("firstName");
    private By middleName = By.name("middleName");
    private By lastName = By.name("lastName");
    private By otherId = By.xpath("//label[normalize-space()='Other Id']/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]");
    private By driverLicenseNumber = By.xpath("//label[contains(normalize-space(.),'License Number')]/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]");
    private By licenseExpirydate = By.xpath("//label[contains(normalize-space(.),'License Expiry')]/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]");
    private By nationality = By.xpath("//label[contains(normalize-space(.),'Nationality')]/parent::div/following-sibling::div//div[contains(@class,'oxd-select-wrapper')]");
    private By nationalityBelgian = By.xpath("//div[@class='oxd-select-option']//span[text()='Belgian']");
    private By maritalStatus = By.xpath("//label[contains(normalize-space(.),'Marital')]/parent::div/following-sibling::div//div[contains(@class,'oxd-select-wrapper')]");
    private By maritalStatusSingle = By.xpath("//div[@class='oxd-select-option']//span[text()='Single']");
    private By dateOfBirth = By.xpath("//label[contains(normalize-space(.),'Date of')]/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]");
    private By genderMaleRadio = By.xpath("//label[normalize-space(.)='Male']//span[contains(@class,'oxd-radio-input')]");
    private By genderFemaleRadio = By.xpath("//input[@type='radio' and @value='2']");
    private By saveButton = By.xpath("//button[@type = 'submit'][1]");
    private By jobDetails = By.xpath("//a[contains(@href,'viewJobDetails')]");
    private By successToaster =   By.cssSelector("div.oxd-toast--success");
    private By loader = By.cssSelector("div.oxd-form-loader");

    public PersonalDetails (WebDriver driver){
        super(driver);
    }

    public PersonalDetails fillForm(Person person){
        //wait.waitForLoaderToDisappear(loader);
        type(firstName, person.getFirstName());
        type(middleName, person.getMiddleName());
        type(lastName, person.getLastName());
        type(otherId, person.getOtherId());
        type(driverLicenseNumber, person.getDriverLicenseNumber());
        type(licenseExpirydate, person.getLicenseExpirydate());
        selectCustomDropDown(nationality, nationalityBelgian, "Belgian");
        selectCustomDropDown(maritalStatus, maritalStatusSingle, "Single");
        type(dateOfBirth, person.getDateOfBirth());
        selectRadio(genderMaleRadio);
        click(saveButton);
        return this;
    }

    public JobDetails openjobDetails(){
        wait.waitForVisibility(jobDetails);
        click(jobDetails);
        return new JobDetails(driver);
    }

    public boolean isSuccessToasterDisplayed() {
        return isDisplayed(successToaster);
    }
    }

