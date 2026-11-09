package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test.saucedemoTests.pages.LoginPage;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    public LoginPageTest(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Test
    public void loginWithInvalidDataShouldShowErrorMessage(){
        loginPage.loginWithInvalidData();
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test
    public void loginWithValidDataShouldNotShowErrorMessage(){
        loginPage.loginSuccessfully();
        Assert.assertFalse(loginPage.isErrorMessagePresent());
    }
}
