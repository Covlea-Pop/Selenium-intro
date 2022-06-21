package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {
    HomePage homePage;


    WebDriver driver;

    @Test
    public void homePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        homePage.addToCartButton();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        homePage.addToCart();
        homePage.closeNotificationBar();
        homePage.shoppingCart();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a")).getText();
        homePage.termsOfServiceButton();
        homePage.checkOutButton();
        driver.get("https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart");
        homePage.checkOutAsGuestButton();
        driver.get("https://demo.nopcommerce.com/onepagecheckout#opc-billing");
        homePage.personal("Cosmin", "Cornel", "cosmin@gmail.com", "Endava",
                "Arad", "Arad", "123456", "123456");
        homePage.selectCountry("Romania");
        homePage.saveButton();
        driver.get("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method");
       homePage.continueButton();
       driver.get("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method");
       homePage.continue1Button();
       driver.get("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info");
       homePage.continue2Button();
       driver.get("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order");
       homePage.confirmOrder();
       driver.get("https://demo.nopcommerce.com/checkout/completed");
       assertEquals(homePage.getMessage(),"Your order has been successfully processed!");
       driver.quit();


    }


}





