package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    // Locator
    public By checkoutButton = By.id("checkout");

    // Method
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
