package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.saucedemoTests.pages.*;

public class CheckoutStepOneTest extends BaseTest {
    @Test
    public void firstNameTextBoxShouldBeDisplayedOnCheckoutStepOnePage(){
        loginPage.login(validLogin, validPassword);

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.toCartPage();
        cartPage.toCheckoutStepOnePage();
        Assert.assertTrue(checkoutStepOnePage.isElementDisplayed(CheckoutStepOnePage.FIRST_NAME_TEXTBOX_LOCATOR));
    }
}