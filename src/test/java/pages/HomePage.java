package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePage {
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]")
    private WebElement addToCartButton;

    @FindBy(id = "bar-notification")
    private WebElement notificationBar;
    @FindBy(className = "close")
    private WebElement closeNotificationButton;

    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeNotificationBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(notificationBar));
        closeNotificationButton.click();
        wait.until(ExpectedConditions.invisibilityOf(notificationBar));
    }
    public ProductDetailPage addToCartButton(){
        addToCartButton.click();
        return new ProductDetailPage(driver);
    }

}
