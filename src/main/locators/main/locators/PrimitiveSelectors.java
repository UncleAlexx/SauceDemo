package main.locators;

import org.openqa.selenium.By;

public class PrimitiveSelectors extends DriverContaining {

    private static final By byId = By.id("login_credentials");
    private static final By byName = By.name("user-name");
    private static final By byClassName = By.className("form_input");
    private static final By byTagName = By.tagName("noscript");
    private static final By byLinkText = By.linkText("Facebook");
    private static final By byPartialLinkText = By.partialLinkText("book");

    public static boolean allPrimitiveLocatorsExist(){
        boolean onLoginPageLocatorsPresent = driver.findElements(byId).isEmpty() || driver.findElements(byName).
            isEmpty() || driver.findElements(byClassName).isEmpty() || driver.findElements(byTagName).isEmpty();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.get("https://www.saucedemo.com/inventory.html");
        boolean result = !(onLoginPageLocatorsPresent || driver.findElements(byLinkText).isEmpty() ||
            driver.findElements(byPartialLinkText).isEmpty());
        driver.get("https://www.saucedemo.com");
        return result;
    }
}
