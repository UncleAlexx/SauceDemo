package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.tests.enums.GoodsFilter;

import java.util.Arrays;

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
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_FIRST_NAME,
                VALID_CHECKOUT_STEP_ONE_PAGE_LAST_NAME, VALID_CHECKOUT_STEP_ONE_PAGE_POSTAL_CODE);

        Assert.assertEquals(checkoutStepTwoPage.boughtElementsCount(), addedGoodsCount) ;
    }

    @Test
    public void totalPriceOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        float totalPriceInCart = inventoryPage.getTotalGoodsPrice(GoodsFilter.ADDED_TO_CART);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_FIRST_NAME,
                VALID_CHECKOUT_STEP_ONE_PAGE_LAST_NAME, VALID_CHECKOUT_STEP_ONE_PAGE_POSTAL_CODE);
        float finalPrice = checkoutStepTwoPage.totalPrice();
        Assert.assertEquals(finalPrice, totalPriceInCart);
    }

    @Test
    public void totalNamesOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        String[] addedToCartGoodsNames = inventoryPage.getGoodsNames(GoodsFilter.ADDED_TO_CART);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(VALID_CHECKOUT_STEP_ONE_PAGE_FIRST_NAME,
                VALID_CHECKOUT_STEP_ONE_PAGE_LAST_NAME, VALID_CHECKOUT_STEP_ONE_PAGE_POSTAL_CODE);
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