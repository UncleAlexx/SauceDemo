package test.saucedemoTests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.*;

public class CheckoutStepOnePageTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Test
    public void firstNameTextBoxShouldBeDisplayed(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.loginSuccessfully();

        inventoryPage.clickOnGoodWithIndex(0);
        inventoryPage.clickOnGoodWithIndex(1);
        inventoryPage.clickOnGoodWithIndex(2);
        inventoryPage.toCartPage();
        new CartPage(driver).toCheckoutStepOnePage();
        new CheckoutStepOnePage(driver).toCheckoutStepTwoPage();
        Assert.assertTrue(driver.findElement(By.id("first-name")).isDisplayed());
    }
}