package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VirtualGiftCardPage {
    @FindBy(xpath = "//*[@id=\"giftcard_43_RecipientName\"]")
    private WebElement recipientNameInput;
    @FindBy(id = "giftcard_43_RecipientEmail")
    private WebElement recipientEmailInput;
    @FindBy(id = "giftcard_43_SenderName")
    private WebElement senderNameInput;
    @FindBy(id = "giftcard_43_SenderEmail")
    private WebElement senderEmailInput;
    @FindBy(id = "giftcard_43_Message")
    private WebElement giftCardMessage;


    private WebDriver driver;

    public VirtualGiftCardPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
}
public void recipientNameInput() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"giftcard_43_RecipientName\"]")));
    element.sendKeys("cosmin");
}
    public void recipientEmailInput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("giftcard_43_RecipientEmail")));
        element2.sendKeys("cosmin@gmail.com");

}
    public void senderNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("giftcard_43_SenderName")));
        element3.sendKeys("cornel");
    }
    public void senderEmailInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("giftcard_43_SenderEmail")));
        element4.sendKeys("cornel@gmail.com");
    }
    public void messageInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.id("giftcard_43_Message")));
        element5.sendKeys("bafta");
    }

public void addToCart2(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button-43")));
    element.click();

    }

}
