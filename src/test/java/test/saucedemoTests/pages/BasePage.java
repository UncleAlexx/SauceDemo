package test.saucedemoTests.pages;

import org.openqa.selenium.WebDriver;
import test.saucedemoTests.elements.UIElement;

public abstract class BasePage {
    public static String path = "https://www.saucedemo.com/";

    protected WebDriver browser;

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }
}
