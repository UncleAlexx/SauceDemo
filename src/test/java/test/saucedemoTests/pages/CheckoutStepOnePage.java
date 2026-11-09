package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{
    private final static String VALID_FIRSTNAME = "valid";
    private final static String VALID_LASTNAME = "valid";
    private final static String VALID_POSTCODE = "344444";

    public CheckoutStepOnePage(WebDriver browser) {
        super(browser);
    }

    public void toCheckoutStepTwoPage(){
        browser.findElement(By.id("first-name")).sendKeys(VALID_FIRSTNAME);
        browser.findElement(By.id("last-name")).sendKeys(VALID_LASTNAME);
        browser.findElement(By.id("postal-code")).sendKeys(VALID_POSTCODE);
        browser.findElement(By.id("continue")).click();
    }
}
