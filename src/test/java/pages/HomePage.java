package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePage {
    @FindBy(id = "bar-notification")
    private WebElement notificationBar;
    @FindBy(className = "close")
    private WebElement closeNotificationButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"add-to-cart-button-4\"]")
    private WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
    private WebElement shoppingCart;
    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceButton;
    @FindBy(id = "checkout")
    private WebElement checkOutButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
    private WebElement checkOutAsGuestButton;
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

    @FindBy(name = "save")
    private WebElement saveButton;
    @FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    private WebElement message;




    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeNotificationBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(notificationBar));
        closeNotificationButton.click();
        wait.until(ExpectedConditions.invisibilityOf(notificationBar));
    }

    public void addToCartButton() {

        addToCartButton.click();
    }

    public void addToCart() {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-4\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCart);
        actions.perform();
        addToCart.click();
    }

    public void shoppingCart() {
        shoppingCart.click();
    }

    public void termsOfServiceButton() {

        WebElement termsOfServiceButton = driver.findElement(By.id("termsofservice"));
        Actions actions = new Actions(driver);
        actions.moveToElement(termsOfServiceButton);
        actions.perform();
        termsOfServiceButton.click();

    }

    public void checkOutButton() {
        checkOutButton.click();
    }

    public void checkOutAsGuestButton() {
        checkOutAsGuestButton.click();
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


    public void saveButton() {
        saveButton.click();
    }

    public void continueButton(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")));
        element.click();
    }

    public void continue1Button(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")));
        element.click();
    }

    public void continue2Button(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")));
        element.click();

    }
    public void confirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")));
        element.click();
    }
    public String getMessage(){
        return message.getText();
    }


}




