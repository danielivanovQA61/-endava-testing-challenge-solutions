package core;

import enums.BrowserTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CheckoutYourInformationPage checkoutYourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutCompletePage checkoutCompletePage;
    public ShoppingCartPage shoppingCartPage;



    @BeforeEach
    public void beforeTests(){
        driver = startBrowser(BrowserTypes.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver, wait);
        checkoutOverviewPage = new CheckoutOverviewPage(driver, wait);
        checkoutCompletePage = new CheckoutCompletePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        driver.get(BasePage.BASE_PAGE_URL);
    }

    @AfterEach
    public void afterTest(){
        driver.close();
    }

    protected static WebDriver startBrowser(BrowserTypes browserType) {
        switch (browserType){
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
        }
        return null;
    }
}
