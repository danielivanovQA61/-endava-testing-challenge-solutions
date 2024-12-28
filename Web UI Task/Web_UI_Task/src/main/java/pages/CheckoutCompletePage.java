package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-complete.html");
    }

    // Locator
    public By orderCompletedMessage = By.xpath("//h2[@class='complete-header']");

    // Method
    public WebElement getOrderCompletedMessage(){
        return driver.findElement(orderCompletedMessage);
    }
}
