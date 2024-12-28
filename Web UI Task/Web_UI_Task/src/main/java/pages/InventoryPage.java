package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "inventory.html");
    }

    // Locators
    public By shoppingCartLink = By.className("shopping_cart_link");
    public By menuButton = By.id("react-burger-menu-btn");
    public By logoutButton = By.id("logout_sidebar_link");
    public By sortMenu = By.className("active_option");

    // Methods
    public int getItemsCount() {
        return driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
    }

    public void clickAddRemoveButton(int index){
        String xpath = String.format("(//div[@class='inventory_item'])[%d]", index);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        button.findElement(By.className("btn_inventory")).click();
    }

    public boolean checkIfItemIsAdded(int index){
        String xpath = String.format("(//div[@class='inventory_item'])[%d]", index);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return button.getText().contains("Remove");
    }

    public boolean checkIfItemIsRemoved(int index){
        String xpath = String.format("(//div[@class='inventory_item'])[%d]", index);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return button.getText().contains("Add to cart");
    }

    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
    }

    public void clickLogout() {
        driver.findElement(menuButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    public Integer getShoppingCartItemsCount() {
        String cartValue = driver.findElement(shoppingCartLink).getText();
        if(cartValue.equals("")){
            return 0;
        }
        else {
            return Integer.parseInt(cartValue);
        }
    }

    public void sortItemsHighToLow(){
        WebElement select = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Price (high to low)");
    }

    public String getSortText(){
        return driver.findElement(sortMenu).getText();
    }

    public boolean checkSortedPrice() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        double[] pricesArray = new double[priceElements.size()];
        for (int i = 0; i < priceElements.size(); i++) {
            WebElement priceElement = priceElements.get(i);
            double price = Double.parseDouble(priceElement.getText().replace("$", ""));
            System.out.println("Price: " + price);
            pricesArray[i]=price;
        }
        for (int j = 0; j< pricesArray.length-1; j++){
            if (pricesArray[j]<pricesArray[j+1]){
                return false;
            }
        }
        return true;
    }
}
