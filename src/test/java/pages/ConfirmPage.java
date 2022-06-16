package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
    public WebElement result;

    public WebDriver driver;

    public ConfirmPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public String getRegistrationText(){
        return result.getText();
    }

}
