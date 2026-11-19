package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;

public class CheckoutStepTwoPage extends BasePage{
    private static final By TOTAL_GOODS_PRICE_LOCATOR = By.xpath("//*[@data-test='subtotal-label']");
    private static final By ALL_BOUGHT_GOODS_LOCATOR = By.xpath("//*[@data-test='inventory-item-name']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getBoughtElements(){
        System.out.println(driver.getCurrentUrl());
        return driver.findElements(ALL_BOUGHT_GOODS_LOCATOR);
    }

    public float totalPrice(){
        System.out.println(driver.findElement(TOTAL_GOODS_PRICE_LOCATOR ).getText() + "end");
        Matcher m= PRICE_PATTERN.matcher(driver.findElement(TOTAL_GOODS_PRICE_LOCATOR).getText());
        if (!m.find()) {
            throw new IllegalStateException("No price match");
        }
        return Float.parseFloat(m.group(1).replace(',', '.'));
    }

    public int boughtElementsCount(){
        return getBoughtElements().size();
    }

    public String[] boughtGoodsNames(){

         return  getBoughtElements().stream().map(WebElement::getText).toArray(String[]::new);
    }
}
