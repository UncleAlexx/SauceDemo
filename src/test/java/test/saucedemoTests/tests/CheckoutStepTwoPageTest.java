package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.*;

public class CheckoutStepTwoPageTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Test
    public void boughtGoodsCountShouldBeEqualToAddedToCartGoodsCount(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.loginSuccessfully();

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        var addedGoodsCount = inventoryPage.removedOrAddedCount(true);
        inventoryPage.toCartPage();
        new CartPage(driver).toCheckoutStepOnePage();
        new CheckoutStepOnePage(driver).toCheckoutStepTwoPage();

        Assert.assertEquals(new CheckoutStepTwoPage(driver).boughtElementsCount(), addedGoodsCount) ;
    }
}