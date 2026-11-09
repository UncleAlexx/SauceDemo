package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    private static final By TO_CHECKOUT_STEP_ONE_PAGE_BUTTON_LOCATOR = By.id("checkout");
    private static final By GOODS_IN_CART_LOCATOR = By.xpath("//div[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int goodsCount(){
        return driver.findElements(GOODS_IN_CART_LOCATOR).size();
    }

    public void toCheckoutStepOnePage(){
        driver.findElement(TO_CHECKOUT_STEP_ONE_PAGE_BUTTON_LOCATOR).click();
    }
}
