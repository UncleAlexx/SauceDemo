package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.*;

public class CartPageTest extends BaseTest {
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public CartPageTest(LoginPage loginPage, InventoryPage inventoryPage) {
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
    }


    @Test
    public void AddedInInventoryPageGoodsCountShouldBeEqualToCartGoodsCount(){
        loginPage.loginSuccessfully();

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.toCartPage();
        Assert.assertEquals(new CartPage(driver).goodsCount(), inventoryPage.removedOrAddedCount(true));
    }
}