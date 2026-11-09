package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{
    public final static By FIRST_NAME_TEXTBOX_LOCATOR = By.id("first-name");
    private final static By LAST_NAME_TEXTBOX_LOCATOR = By.id("last-name");
    private final static By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postal-code");
    private final static By TO_CHECKOUT_STEP_TWO_PAGE_BUTTON_LOCATOR = By.id("postal-code");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void toCheckoutStepTwoPage(String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME_TEXTBOX_LOCATOR).sendKeys(firstName);
        driver.findElement(LAST_NAME_TEXTBOX_LOCATOR).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_TEXTBOX_LOCATOR).sendKeys(postalCode);
        driver.findElement(TO_CHECKOUT_STEP_TWO_PAGE_BUTTON_LOCATOR).click();
    }
}
