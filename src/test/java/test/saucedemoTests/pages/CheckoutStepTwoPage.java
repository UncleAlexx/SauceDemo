package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage{
    private static final String TOTAL_GOODS_PRICE_LOCATOR ="//*[@data-test='subtotal-label']";
    private static final String ALL_BOUGHT_GOODS_LOCATOR = "//*[@data-test='inventory-item-name']";

    private final List<WebElement> boughtElements;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        boughtElements = driver.findElements(By.xpath(ALL_BOUGHT_GOODS_LOCATOR));
    }

    public float totalPrice(){
        return Float.parseFloat(PRICE_PATTERN.matcher(driver.findElement(By.xpath(TOTAL_GOODS_PRICE_LOCATOR)).
        getText()).group());
    }

    public int boughtElementsCount(){
        return boughtElements.size();
    }

    public String[] boughtGoodsNames(){
        return boughtElements.stream().map(WebElement::getText).toArray(String[]::new);
    }
}
