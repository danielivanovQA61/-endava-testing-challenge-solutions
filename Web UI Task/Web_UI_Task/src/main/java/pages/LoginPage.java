package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "");
    }

    // Locators
    public By usernameLocator = By.id("user-name");
    public By passwordLocator = By.id("password");
    public By loginButtonLocator = By.id("login-button");

    // Methods
    public void fillLoginForm() {
        driver.findElement(usernameLocator).sendKeys(USERNAME);
        driver.findElement(passwordLocator).sendKeys(PASSWORD);
        driver.findElement(loginButtonLocator).click();
    }
}
