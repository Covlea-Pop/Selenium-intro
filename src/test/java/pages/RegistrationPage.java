package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {
    @FindBy(name = "Gender")
    List<WebElement> genderRadioButtons;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dobDropdown;

    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("Male")){
            genderRadioButtons.get(0).click();
        }else {
            genderRadioButtons.get(1).click();
        }
    }

    public void selectDayOfBirth(String day){
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(day);


    }
}
