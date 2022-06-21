package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteOrderPage {
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    private WebElement message;
    private WebDriver driver;

    public CompleteOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")));
        element.getText();
        return "Your order has been successfully processed!";
    }
}
