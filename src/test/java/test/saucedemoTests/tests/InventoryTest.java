package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
    private void common(){
        loginPage.login(validLogin, validPassword);
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
    }

    @Test
    public void addThreeGoodsShouldResultInThreeCartGoods(){
        common();
        Assert.assertEquals(inventoryPage.getAddedToCartGoodsCount(true), 3);
    }

    @Test
    public void addThreeGoodsShouldResultInThreeGoodsNotInTheCard(){
        common();
        Assert.assertEquals(inventoryPage.allGoodsCount() - inventoryPage.getAddedToCartGoodsCount(true), inventoryPage.allGoodsCount() - 3);
    }
}