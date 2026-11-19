package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.saucedemoTests.GoodsFilter;
import test.saucedemoTests.tests.CartSelectionOptions;

import java.util.List;
import java.util.regex.Matcher;

public class InventoryPage extends BasePage{
    private final static By ALREADY_ADDED_TO_CART_GOODS_LOCATOR = By.xpath("//*[text()='Remove']");
    private final static By NOT_YET_ADDED_TO_CART_GOODS_LOCATOR = By.xpath("//*[text()='Add to cart']");
    private final static By ALL_GOODS_LOCATOR = By.xpath("//button[contains(@class,'btn')]");
    private final static By PRICE_ELEM_IN_A_GOOD_LOCATOR = By.xpath("preceding-sibling::*[1]");
    private final static By NAME_ELEM_IN_A_GOOD_LOCATOR = By.xpath("parent::*/parent::*/descendant::"
        + "*[@class='inventory_item_name ']");
    private final static By TO_CART_PAGE_BUTTON_LOCATOR = By.xpath("//*[@data-test='shopping-cart-link']");
    private static boolean isCacheStale = true;
    private static List<WebElement> allGoods;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnGoodWithIndex(int index){
        if(index >= 0){
            getGoods(GoodsFilter.ALL).get(index).click();
        }
    }

    public String[] getGoodsNames(GoodsFilter goodsFilter){
        return getGoods(goodsFilter).stream().
            map(goodElement -> goodElement.findElement(NAME_ELEM_IN_A_GOOD_LOCATOR).getText()).
            toArray(String[]::new);
    }

    public float getTotalGoodsPrice(GoodsFilter goodsFilter){
        return getGoods(goodsFilter).stream().
            map(good -> good.findElement(PRICE_ELEM_IN_A_GOOD_LOCATOR).getText()).
            map(rawPriceText -> {
                Matcher m= PRICE_PATTERN.matcher(rawPriceText);
                if (!m.find()) {
                    throw new IllegalStateException("No price match in text: '" + rawPriceText + "'");
                }
            return Float.parseFloat(m.group(1).replace(',', '.'));
            }).
            reduce(0f, (accumulator, priceAsText) ->
            accumulator + Float.parseFloat(String.valueOf(priceAsText)), Float::sum);
    }

    public int goodsCount(GoodsFilter goodsFilter){
        return getGoods(goodsFilter).size();
    }

    public void toCartPage(){
       driver.findElement(TO_CART_PAGE_BUTTON_LOCATOR).click();
    }

    public void addAllToCart(){
        for (WebElement good : getGoods(GoodsFilter.ADDED_TO_CART)) {
            good.click();
        }
    }

    public void invalidateCache() {
        isCacheStale = true;
    }

    private List<WebElement> getGoods(GoodsFilter filter){
        if(filter == GoodsFilter.ALL) {
            if(allGoods == null || isCacheStale) {
                allGoods = driver.findElements(ALL_GOODS_LOCATOR);
            }
            return allGoods;
        }
        return driver.findElements(filter == GoodsFilter.ADDED_TO_CART? ALREADY_ADDED_TO_CART_GOODS_LOCATOR :
            NOT_YET_ADDED_TO_CART_GOODS_LOCATOR);
    }
}
