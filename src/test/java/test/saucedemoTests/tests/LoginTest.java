package test.saucedemoTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithInvalidDataShouldShowErrorMessage(){
        loginPage.login(invalidLogin, invalidPassword);
        Assert.assertFalse(loginPage.isErrorMessagePresent());
    }

    @Test
    public void loginWithValidDataShouldNotShowErrorMessage(){
        loginPage.login(validLogin, validPassword);
        Assert.assertFalse(loginPage.isErrorMessagePresent());
    }
}
