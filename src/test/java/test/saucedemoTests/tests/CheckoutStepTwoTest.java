package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.GoodsFilter;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void boughtGoodsCountShouldBeEqualToAddedToCartGoodsCount(){
        loginPage.login(VALID_LOGIN_PAGE_USERNAME, VALID_LOGIN_PAGE_PASSWORD);
        inventoryPage.addAllToCart();
        inventoryPage.invalidateCache();

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        int addedGoodsCount = inventoryPage.goodsCount(GoodsFilter.ADDED_TO_CART);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_LOGIN,
            VALID_CHECKOUT_STEP_ONE_PAGE_PASSWORD, VALID_CHECKOUT_STEP_ONE_PAGE_POST_CODE);

        Assert.assertEquals(checkoutStepTwoPage.boughtElementsCount(), addedGoodsCount) ;
    }
}