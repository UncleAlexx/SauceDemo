package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.GoodsFilter;

public class CartTest extends BaseTest {

    @Test
    public void AddedInInventoryPageGoodsCountShouldBeEqualToCartGoodsCount(){
        loginPage.login(VALID_LOGIN_PAGE_USERNAME, VALID_LOGIN_PAGE_PASSWORD);
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.toCartPage();
        Assert.assertEquals(cartPage.inCartGoodsCount(), inventoryPage.goodsCount(GoodsFilter.ADDED_TO_CART));
    }
}