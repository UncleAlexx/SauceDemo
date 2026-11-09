package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {

    @Test
    public void totalPriceOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        float totalPriceInCart = inventoryPage.totalAddedOrRemovedGoodsPrice(true);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(validCheckoutStepOneLogin, validCheckoutStepOnePassword,
            validPostCode);
        float finalPrice = ckeckoutStepTwoPage.totalPrice();
        Assert.assertEquals(finalPrice, totalPriceInCart);
    }
    private void common(){
        loginPage.login(validLogin, validPassword);

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(4);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.clickOnGoodWithIndex(3);
        inventoryPage.clickOnGoodWithIndex(5);
    }
    @Test
    public void totalNamesOfGoodsInTheCartShouldBeEqualToFinalPrice(){
        common();
        String[] addedToCartGoodsNames = inventoryPage.getAddedToCartGoodsNames(true);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        checkoutStepOnePage.toCheckoutStepTwoPage(validCheckoutStepOneLogin, validCheckoutStepOnePassword,
                validPostCode);
        String[] boughtGoodsElementsNames = ckeckoutStepTwoPage.boughtGoodsNames();
        Assert.assertEquals(boughtGoodsElementsNames, addedToCartGoodsNames);
    }
}
