package test.saucedemoTests.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithInvalidDataShouldShowErrorMessage(){
        loginPage.login(INVALID_LOGIN_PAGE_USERNAME, INVALID_LOGIN_PAGE_PASSWORD);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test
    public void loginWithValidDataShouldNotShowErrorMessage(){
        loginPage.login(VALID_LOGIN_PAGE_USERNAME, VALID_LOGIN_PAGE_PASSWORD);
        Assert.assertFalse(loginPage.isErrorMessagePresent());
    }
}
