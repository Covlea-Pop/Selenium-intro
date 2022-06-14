package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {
    @FindBy(css = "#FullName")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement emailInput;

    @FindBy (xpath = "//*[@id=\"Enquiry\"]")
    private WebElement enquiryInput;

    @FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
    private WebElement submitButton;

    public void contact(String name, String email, String enquiry){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        emailInput.sendKeys(enquiry);
        submitButton.click();
    }


}
