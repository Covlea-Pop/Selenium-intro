package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;

import java.sql.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    LoginPage loginPage;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage = new LoginPage(driver);
    }

    @Test

    public void canLoginWithValidCredentials() {

        loginPage.loginAs("vrajeala@mailnesia.com", "123123");

        AccountPage accountpage = new AccountPage(driver);

        assertEquals(accountpage.getLogOutLinkText(), "Log out");


    }

    @Test

    public void cannotLoginWithIncorrectPassword() {


        loginPage.loginAs("vrajeala@mailnesia.com", "wrongpass");
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
        assertThat(loginPage.getErrorMessage(), is("Login was unsuccessful. Please correct the errors and try again.\\n\" +\n" +
                "                \"The credentials provided are incorrect"));


    }

    @Test
    public void cannotLoginWithIncorrectEmail() {

        loginPage.loginAs("test_endava@mailnesia.com", "test123");
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");


    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
