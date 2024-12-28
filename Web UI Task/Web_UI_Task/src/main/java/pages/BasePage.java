package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final String BASE_PAGE_URL = "https://www.saucedemo.com/";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Daniel";
    public static final String LAST_NAME = "Ivanov";
    public static final String ZIP = "1517";

    protected WebDriver driver;
    protected WebDriverWait wait;
    private String pageUrl;

    public BasePage(WebDriver webDriver, WebDriverWait driverWait, String pageSpecificUrl) {
        driver = webDriver;
        wait = driverWait;
        pageUrl = pageSpecificUrl;
    }

    // Methods
    public String getPageUrl(){
        return BASE_PAGE_URL + pageUrl;
    }

    public void navigate(){
        driver.get(getPageUrl());
    }
}
