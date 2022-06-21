package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ProductDetailPage {
   private WebDriver driver;

   public ProductDetailPage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }
   @FindBy(id = "bar-notification")
   private WebElement notificationBar;
   @FindBy(className = "close")
   private WebElement closeNotificationButton;
   @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
   private WebElement shoppingCart;

   public void addToCart() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button-4\"]")));
      element.click();

}
   public void closeNotificationBar() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
      wait.until(ExpectedConditions.visibilityOf(notificationBar));
      closeNotificationButton.click();
      wait.until(ExpectedConditions.invisibilityOf(notificationBar));
   }

   public CartPage shoppingCart() {
      shoppingCart.click();
      return new CartPage(driver);
   }
}
