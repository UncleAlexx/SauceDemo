package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage{
    private static final String totalBoughtElementsPriceSelector ="//*[@data-test='subtotal-label']";
    private static final String boughtElementsSelector = "//*[@data-test='inventory-item-name']";

    private final List<WebElement> boughtElements;

    public CheckoutStepTwoPage(WebDriver browser) {
        super(browser);
        boughtElements = browser.findElements(By.xpath(boughtElementsSelector));
    }

    public String totalPrice(){
        return browser.findElement(By.xpath(totalBoughtElementsPriceSelector)).getText();
    }

    public int boughtElementsCount(){
        return boughtElements.size();
    }

    public List<String> boughtElementsTexts(){
        return boughtElements.stream().map(WebElement::getText).toList();
    }
}
