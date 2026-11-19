package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.GoodsFilter;

import java.util.Arrays;

public class E2ETest extends BaseTest {

    @Test
    public void totalPriceOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        float totalPriceInCart = inventoryPage.getTotalGoodsPrice(GoodsFilter.ADDED_TO_CART);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_LOGIN,
                VALID_CHECKOUT_STEP_ONE_PAGE_PASSWORD, VALID_CHECKOUT_STEP_ONE_PAGE_POST_CODE);
        float finalPrice = checkoutStepTwoPage.totalPrice();
        ;
        Assert.assertEquals(finalPrice, totalPriceInCart);
    }

    @Test
    public void totalNamesOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        String[] addedToCartGoodsNames = inventoryPage.getGoodsNames(GoodsFilter.ADDED_TO_CART);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_LOGIN,
        VALID_CHECKOUT_STEP_ONE_PAGE_PASSWORD, VALID_CHECKOUT_STEP_ONE_PAGE_POST_CODE);
        String[] boughtGoodsElementsNames = checkoutStepTwoPage.boughtGoodsNames();
        Arrays.sort(boughtGoodsElementsNames);
        Arrays.sort(addedToCartGoodsNames);
        Assert.assertEquals(boughtGoodsElementsNames, addedToCartGoodsNames);
    }

    private void common(){
        loginPage.login(VALID_LOGIN_PAGE_USERNAME, VALID_LOGIN_PAGE_PASSWORD);
        inventoryPage.addAllToCart();
        inventoryPage.invalidateCache();
        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(4);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.clickOnGoodWithIndex(3);
        inventoryPage.clickOnGoodWithIndex(5);
    }
}
