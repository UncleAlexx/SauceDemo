package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.regex.Pattern;

public class InventoryPage extends BasePage{
    private final static String ELEMENT_BY_ANY_TEXT_LOCATOR = "//*[text()='%s']";
    private final static String ALREADY_ADDED_TO_CART_GOODS_TEXT = "Remove";
    private final static String NOT_YET_ADDED_TO_CART_GOODS_TEXT = "Add to cart";

    private final static By PRICE_ELEM_IN_A_GOOD_XPATH_LOCATOR = By.xpath("preceding-sibling::*[1]");
    private final static By Name_ELEM_IN_A_GOOD_XPATH_LOCATOR = By.xpath("parent::*/parent::*/descendant::*"
        + "[@class='inventory_item_name ']");
    private final static By inventoryGoodsLocator =
            By.xpath("(//button[contains(@class,'btn')])");
    private final static By TO_CART_PAGE_BUTTON_Locator = By.xpath("//*[@data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getGoods(){
        return driver.findElements(inventoryGoodsLocator);
    }

    public void clickOnGoodWithIndex(int index){
        getGoods().get(index).click();
    }

    public String[] getAddedToCartGoodsNames(boolean searchAddedToCardOrNotAddedYet){
       return getAddedToCartGoods(searchAddedToCardOrNotAddedYet).stream()
       .map(goodElement -> goodElement.findElement(Name_ELEM_IN_A_GOOD_XPATH_LOCATOR).getText()).
       toArray(String[]::new);
    }

    public float totalAddedOrRemovedGoodsPrice(boolean searchAddedToCardOrNotAddedYet){
        return getAddedToCartGoods(searchAddedToCardOrNotAddedYet).stream().
             map(good -> good.findElement(PRICE_ELEM_IN_A_GOOD_XPATH_LOCATOR).getText()).
             map(rawPriceText -> PRICE_PATTERN.matcher(rawPriceText).group()).
             reduce(0f, (accumulator, priceAsText) ->
             accumulator + Float.parseFloat(priceAsText), Float::sum);
    }

    public int allGoodsCount(){
        return getGoods().size();
    }

    public int getAddedToCartGoodsCount(boolean searchAddedToCardOrNotAddedYet){
        return getAddedToCartGoods(searchAddedToCardOrNotAddedYet).size();
    }

    public void toCartPage(){
        driver.findElement(TO_CART_PAGE_BUTTON_Locator).click();
    }

    private List<WebElement> getAddedToCartGoods(boolean searchAddedToCardOrNotAddedYet){
        return driver.findElements(By.xpath(String.format(ELEMENT_BY_ANY_TEXT_LOCATOR, searchAddedToCardOrNotAddedYet?
                ALREADY_ADDED_TO_CART_GOODS_TEXT : NOT_YET_ADDED_TO_CART_GOODS_TEXT)));
    }
}
