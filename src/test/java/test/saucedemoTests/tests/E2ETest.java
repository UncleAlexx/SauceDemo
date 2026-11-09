package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.*;

public class E2ETest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;

    @Test
    public void totalPriceOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        loginPage.loginSuccessfully();

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(4);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.clickOnGoodWithIndex(3);
        inventoryPage.clickOnGoodWithIndex(5);
        float totalPriceInCart = inventoryPage.totalAddedOrRemovedElementsPrice(true);
        inventoryPage.totalAddedOrRemovedElementsPrice(true);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage();
        String finalPrice = checkoutStepTwoPage.totalPrice();
        Assert.assertEquals(Float.parseFloat(finalPrice.substring(finalPrice.indexOf('$')+ 1)),
                totalPriceInCart);
    }
}
