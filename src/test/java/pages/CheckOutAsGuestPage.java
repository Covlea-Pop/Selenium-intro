package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutAsGuestPage {
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
    private WebElement checkOutAsGuestButton;
    private WebDriver driver;

    public CheckOutAsGuestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public BillingPage checkOutAsGuestButton() {
        checkOutAsGuestButton.click();
        return new BillingPage(driver);
    }
}
