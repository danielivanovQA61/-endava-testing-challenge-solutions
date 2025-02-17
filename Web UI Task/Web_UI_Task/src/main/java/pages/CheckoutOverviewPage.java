package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-two.html");
    }

    // Locator
    public By finishLocator = By.id("finish");

    // Method
    public void clickFinishButton(){
        driver.findElement(finishLocator).click();
    }
}
