package test.saucedemoTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private static final By USER_NAME_TEXTBOX_LOCATOR = By.id("user-name");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
    private static final By H3_WITH_NO_SUCH_USERNAME_AND_PASSWORD_LOCATOR = By.xpath("//h3[text()=" +
        "'Epic sadface: Username and password do not match any user in this service']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessagePresent(){
        return !driver.findElements(H3_WITH_NO_SUCH_USERNAME_AND_PASSWORD_LOCATOR).isEmpty();
    }

    public void login(String login, String password){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(USER_NAME_TEXTBOX_LOCATOR).sendKeys(login);
        driver.findElement(PASSWORD_TEXTBOX_LOCATOR).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }
}
