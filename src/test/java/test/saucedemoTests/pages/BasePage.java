package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public abstract class BasePage {
    public final static String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected final static Pattern PRICE_PATTERN = Pattern.compile("/d+[.,]/d+");

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public void setDriver(WebDriver driver){
        if(driver != null){
            this.driver = driver;
        }
    }
}
