package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.GoodsFilter;

public class InventoryTest extends BaseTest {
    @Test
    public void addThreeGoodsShouldResultInThreeCartGoods(){
        common();
        Assert.assertEquals(inventoryPage.goodsCount(GoodsFilter.ADDED_TO_CART), 3);
    }

    @Test
    public void addThreeGoodsShouldResultInThreeGoodsNotInTheCard(){
        common();
        Assert.assertEquals(inventoryPage.goodsCount(GoodsFilter.NOT_ADDED_TO_CART),
        inventoryPage.goodsCount(GoodsFilter.ALL) - 3);
    }

    private void common(){
        loginPage.login(VALID_LOGIN_PAGE_USERNAME, VALID_LOGIN_PAGE_PASSWORD);
        inventoryPage.invalidateCache();
        inventoryPage.addAllToCart();
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
    }
}