package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void boughtGoodsCountShouldBeEqualToAddedToCartGoodsCount(){
        loginPage.login(validLogin, validPassword);
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        int addedGoodsCount = inventoryPage.getAddedToCartGoodsCount(true);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(validCheckoutStepOneLogin,
            validCheckoutStepOnePassword, validCheckoutStepOnePassword);

        Assert.assertEquals(ckeckoutStepTwoPage.boughtElementsCount(), addedGoodsCount) ;
    }
}