package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{

    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }

    // Locators
    public By continueLocator = By.id("continue");
    public By firstName = By.id("first-name");
    public By lastName = By.id("last-name");
    public By postalCode = By.id("postal-code");

    // Methods
    public void clickContinueButton(){
        driver.findElement(continueLocator).click();
    }

    public void fillShippingDetails() {
        driver.findElement(firstName).sendKeys(FIRST_NAME);
        driver.findElement(lastName).sendKeys(LAST_NAME);
        driver.findElement(postalCode).sendKeys(ZIP);
    }
}
