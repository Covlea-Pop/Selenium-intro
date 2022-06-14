package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage {
    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-title > h1")
    private WebElement contactUs;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div/p")
    private WebElement msg;
    @FindBy(css = "#FullName")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"Enquiry\"]")
    private WebElement enquiryInput;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
    private WebElement submitButton;


    public void contact(String name, String email, String enquiry) {
        assertEquals("Contact Us", contactUs);
        assertEquals("Put your contact information here. You can edit this in the admin site.", msg);
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        emailInput.sendKeys(enquiry);
        submitButton.click();

    }


}
