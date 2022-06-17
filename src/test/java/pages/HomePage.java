package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePage {
    @FindBy(id = "bar-notification")
    private WebElement notificationBar;
    @FindBy(className = "close")
    private WebElement closeNotificationButton;

    private WebDriver driver;

    public void closeNotificationBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(notificationBar));
        closeNotificationButton.click();
        wait.until(ExpectedConditions.invisibilityOf(notificationBar));
    }

}
