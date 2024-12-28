package tests;

import core.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaucedemoTests extends BaseTest {

    @BeforeEach
    public void beforeTest(){
        driver.manage().window().maximize();
        loginPage.navigate();
        loginPage.fillLoginForm();
    }

    @Test
    @Description("scenario1")
    public void scenario1(){
        inventoryPage.clickAddRemoveButton(1);
        inventoryPage.clickAddRemoveButton(inventoryPage.getItemsCount());
        Assertions.assertTrue(inventoryPage.checkIfItemIsAdded(1), "Item is not added.");
        Assertions.assertTrue(inventoryPage.checkIfItemIsAdded(inventoryPage.getItemsCount()),
                "Item is not added.");

        inventoryPage.clickAddRemoveButton(1);
        inventoryPage.clickAddRemoveButton(inventoryPage.getItemsCount()-1);
        Assertions.assertTrue(inventoryPage.checkIfItemIsRemoved(1), "Item is not removed.");
        Assertions.assertTrue(inventoryPage.checkIfItemIsAdded(inventoryPage.getItemsCount()-1),
                "Item is not added.");

        inventoryPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckoutButton();
        checkoutYourInformationPage.fillShippingDetails();
        checkoutYourInformationPage.clickContinueButton();
        checkoutOverviewPage.clickFinishButton();
        Assertions.assertTrue(checkoutCompletePage.getOrderCompletedMessage().isDisplayed(),
                "Success message was not displayed.");
        Assertions.assertEquals("Thank you for your order!", checkoutCompletePage
                        .getOrderCompletedMessage().getText(),
                "Success message was not as expected.");
        Assertions.assertEquals(0, inventoryPage.getShoppingCartItemsCount(),
                "Shopping cart was not emptied after purchase.");
        inventoryPage.clickLogout();
    }

    @Test
    @Description("scenario2")
    public void scenario2(){
    inventoryPage.sortItemsHighToLow();
    Assertions.assertEquals("Price (high to low)",inventoryPage.getSortText(),
            "Price (high to low) is not selected");
    Assertions.assertTrue(inventoryPage.checkSortedPrice(), "Items are not sorted.");
    inventoryPage.clickLogout();
    }
}
