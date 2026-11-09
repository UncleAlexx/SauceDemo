package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    private final List<WebElement> inCartGoods;

    public CartPage(WebDriver browser) {
        super(browser);
        inCartGoods = browser.findElements(By.xpath("//div[@class='cart_item']"));
    }

    public void toCheckoutStepOnePage(){
        browser.findElement(By.id("checkout")).click();
    }
    public int goodsCount(){
        return inCartGoods.size();
    }
}
