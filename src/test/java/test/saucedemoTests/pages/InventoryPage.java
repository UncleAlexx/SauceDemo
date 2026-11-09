package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage extends BasePage{

    private final static String addToCardAndRemoveButtonsSelector = "//button[contains(@class,'btn')]";

    private List<WebElement> goods;

    public InventoryPage(WebDriver browser) {
        super(browser);
        goods = browser.findElements(By.xpath(addToCardAndRemoveButtonsSelector));
    }

    public void clickOnGoodWithIndex(int index){
        goods = browser.findElements(By.xpath(addToCardAndRemoveButtonsSelector));
        goods.get(index).click();
    }

    public String[] namesAddedOrNot(boolean added){
       return browser.findElements(By.xpath(String.format("//*[text()='%s']", !added? "Add to cart" : "Remove"))).
       stream().map(x -> x.findElement(By.xpath("parent::*/parent::*/descendant::*" +
       "[@class='inventory_item_name ']")).getText()).toArray(String[]::new);
    }

    public float totalAddedOrRemovedElementsPrice(boolean added){
        return browser.findElements(By.xpath(String.format("//*[text()='%s']", !added ?"Add to cart":"Remove"))).stream().
             map(x -> x.findElement(By.xpath("preceding-sibling::*[1]")).getText()).
             map(x -> x.substring(1)).
             reduce(0.0f, (acc, s) -> acc + Float.parseFloat(s),Float::sum);
    }

    public int allGoodsCount(){
        return goods.size();
    }

    public int removedOrAddedCount(boolean added){
        return browser.findElements(By.xpath(String.format("//*[text()='%s']", !added ? "Add to cart" : "Remove"))).size();
    }

    public void toCartPage(){
        browser.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();
    }
}
