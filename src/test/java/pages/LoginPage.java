package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()=\"Log in\"]")
    private WebElement loginButton;

    public void loginAs(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
