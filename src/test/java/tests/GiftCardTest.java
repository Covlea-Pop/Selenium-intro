package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GiftCardPage;
import pages.HomePage;
import pages.VirtualGiftCardPage;

public class GiftCardTest {

    HomePage homePage;
    WebDriver driver;

    @Test
    public void homePage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        GiftCardPage giftCardPage = homePage.giftCardButton();
        VirtualGiftCardPage virtualGiftCardPage = giftCardPage.addToCart();
        virtualGiftCardPage.recipientNameInput();
        virtualGiftCardPage.recipientEmailInput();
        virtualGiftCardPage.senderNameInput();
        virtualGiftCardPage.senderEmailInput();
        virtualGiftCardPage.messageInput();
        virtualGiftCardPage.addToCart2();
        driver.quit();


    }

}
