package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillingPage {
    @FindBy(name = "save")
    private WebElement saveButton;
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;
    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;
    @FindBy(id = "BillingNewAddress_Email")
    private WebElement EmailInput;
    @FindBy(id = "BillingNewAddress_Company")
    private WebElement CompanyInput;
    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityInput;
    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement adressInput;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipInput;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneInput;
    @FindBy(name = "BillingNewAddress.CountryId")
    private WebElement countryDropdown;
    private WebDriver driver;

    public BillingPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void personal(String FirstName, String LastName, String Email, String Company, String City, String Adress,
                         String Zip, String Phone) {

        firstNameInput.sendKeys(FirstName);
        lastNameInput.sendKeys(LastName);
        EmailInput.sendKeys(Email);
        CompanyInput.sendKeys(Company);
        cityInput.sendKeys(City);
        adressInput.sendKeys(Adress);
        zipInput.sendKeys(Zip);
        phoneInput.sendKeys(Phone);


    }
    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
}
    public ShippingPage saveButton() {
        saveButton.click();
        return new ShippingPage(driver);    }
}
