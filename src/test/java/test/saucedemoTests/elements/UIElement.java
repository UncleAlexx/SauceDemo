package test.saucedemoTests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIElement {
    private final WebDriver browser;

    public UIElement(WebDriver browser) {
        this.browser = browser;
    }

    public void clickWithId(String id){
        browser.findElement(By.id(id)).click();
    }

    public void sendKeysWithId(String id, String value){
        browser.findElement(By.id(id)).sendKeys(value);
    }
}
