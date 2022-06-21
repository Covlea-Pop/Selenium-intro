package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

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
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = homePage.addToCartButton();
        productDetailPage.addToCart();
        productDetailPage.closeNotificationBar();
        CartPage cartPage = productDetailPage.shoppingCart();
        cartPage.termsOfServiceButton();
        CheckOutAsGuestPage checkOutAsGuestPage = cartPage.checkOutButton();
        BillingPage billingPage = checkOutAsGuestPage.checkOutAsGuestButton();
        billingPage.personal("Cosmin", "Cornel", "cosmin@gmail.com", "Endava",
                "Arad", "Arad", "123456", "123456");
        billingPage.selectCountry("Romania");
        ShippingPage shippingPage = billingPage.saveButton();
        PaymentPage paymentPage = shippingPage.continueButton();
        PaymentInformationPage paymentInformationPage = paymentPage.continue1Button();
        ConfirmOrderPage confirmOrderPage = paymentInformationPage.continue2Button();
        CompleteOrderPage completeOrderPage = confirmOrderPage.confirmOrder();
        completeOrderPage.getMessage();
        assertEquals(completeOrderPage.getMessage(), "Your order has been successfully processed!");
        driver.quit();

//
    }


}





