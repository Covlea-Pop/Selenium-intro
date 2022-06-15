package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test

    public void canLoginWithValidCredentials() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        // Open Browser
        WebDriver driver = new ChromeDriver();
        // navigate to login page
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("test_endava1@mailnesia.com", "test123");


        AccountPage accountpage = new AccountPage(driver);

        assertEquals(accountpage.getLogOutLinkText(), "Log out");

        driver.quit();


    }

    @Test

    public void cannotLoginWithIncorrectPassword(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test_endava1@mailnesia.com", "wrongpass");
        assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");

        driver.quit();

    }
    @Test
    public void cannotLoginWithIncorrectEmail(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test_endava@mailnesia.com", "test123");
        assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

        driver.quit();
}
}
