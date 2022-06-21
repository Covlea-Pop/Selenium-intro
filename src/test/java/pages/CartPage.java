package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    private WebDriver driver;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void termsOfServiceButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"termsofservice\"]")));
        element.click();
    }
    public CheckOutAsGuestPage checkOutButton() {
        checkOutButton.click();
        return new CheckOutAsGuestPage(driver);
    }
}
