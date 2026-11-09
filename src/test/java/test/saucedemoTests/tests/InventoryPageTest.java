package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.*;

public class InventoryPageTest extends BaseTest {
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public InventoryPageTest(LoginPage loginPage, InventoryPage inventoryPage) {
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
    }

    private void common(){
        loginPage.loginSuccessfully();
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
    }

    @Test
    public void addThreeGoodsShouldResultInThreeCartGoods(){
        common();
        Assert.assertEquals(inventoryPage.removedOrAddedCount(true), 3);
    }

    @Test
    public void addThreeGoodsShouldResultInThreeGoodsNotInTheCard(){
        common();
        Assert.assertEquals(inventoryPage.allGoodsCount() - inventoryPage.removedOrAddedCount(true), inventoryPage.allGoodsCount() - 3);
    }
}