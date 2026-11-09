package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void AddedInInventoryPageGoodsCountShouldBeEqualToCartGoodsCount(){
        loginPage.login(validLogin, validPassword);
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.toCartPage();
        Assert.assertEquals(cartPage.goodsCount(), inventoryPage.getAddedToCartGoodsCount(true));
    }
}