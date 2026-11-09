package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.saucedemoTests.elements.UIElement;

public class LoginPage extends BasePage{
    private final UIElement uiElement;

    public LoginPage(WebDriver browser) {
        super(browser);
        uiElement = new UIElement(browser);
    }

    public void loginWithInvalidData(){
        loginWith("invalid_login227","invalid_password1336");
    }

    public void loginSuccessfully(){
        loginWith("standard_user", "secret_sauce");
    }

    public boolean isErrorMessagePresent(){
        return !browser.findElements(By.xpath("//h3[text()='Epic sadface: Username and password do not " +
            "match any user in this service']")).isEmpty();
    }

    private void loginWith(String login, String password){
        browser.get(path);
        uiElement.sendKeysWithId("user-name", login);
        uiElement.sendKeysWithId("password", password);
        uiElement.clickWithId("login-button");
    }
}
