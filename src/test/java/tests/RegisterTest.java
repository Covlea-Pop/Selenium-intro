package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfirmPage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

    RegistrationPage registrationPage;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcontactus");
        registrationPage = new RegistrationPage(driver);

    }

    @Test

    public void register() throws InterruptedException {


        Thread.sleep(2000);
        registrationPage.selectGender("Male");
        Thread.sleep(2000);
        registrationPage.personalDetails("cosmin", "cornel", "cosamin@gmail.com",
                "Endava", "123456", "123456");
        Thread.sleep(2000);
        registrationPage.selectDayOfBirth("5");
        Thread.sleep(2000);
        registrationPage.selectMonthOfBirth("March");
        Thread.sleep(2000);
        registrationPage.selectYearOfBirth("1980");
        Thread.sleep(2000);
        registrationPage.newsLetter();
        Thread.sleep(2000);
        registrationPage.register();
        Thread.sleep(2000);
        ConfirmPage confirmPage = new ConfirmPage(driver);
        assertEquals(confirmPage.getRegistrationText(), "Your registration completed");


    }
    @Test

    public void cannotLoginWithSameEmail() throws InterruptedException {
        Thread.sleep(2000);
        registrationPage.selectGender("Male");
        Thread.sleep(2000);
        registrationPage.personalDetails("cosmin", "cornel", "cosamin@gmail.com",
                "Endava", "123456", "123456");
        Thread.sleep(2000);
        registrationPage.selectDayOfBirth("5");
        Thread.sleep(2000);
        registrationPage.selectMonthOfBirth("March");
        Thread.sleep(2000);
        registrationPage.selectYearOfBirth("1980");
        Thread.sleep(2000);
        registrationPage.newsLetter();
        Thread.sleep(2000);
        registrationPage.register();
        Thread.sleep(2000);
        assertEquals(registrationPage.getErrorMessage(),"The specified email already exists");

    }

    @Test
    public void passwordLenghtCheck() throws InterruptedException {
        Thread.sleep(2000);
        registrationPage.selectGender("Male");
        Thread.sleep(2000);
        registrationPage.personalDetails("cosmin", "cornel", "coslajgdmijn@gmail.com",
                "Endava", "12345", "12345");
        Thread.sleep(2000);
        registrationPage.selectDayOfBirth("5");
        Thread.sleep(2000);
        registrationPage.selectMonthOfBirth("March");
        Thread.sleep(2000);
        registrationPage.selectYearOfBirth("1980");
        Thread.sleep(2000);
        registrationPage.newsLetter();
        Thread.sleep(2000);
        registrationPage.register();
        Thread.sleep(2000);
        assertEquals(registrationPage.getErrorMessage2(), "Password must meet the following rules:\n" +
                "must have at least 6 characters");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}