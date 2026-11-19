package test.saucedemoTests.tests;

import org.openqa.selenium.WebDriver;

public final class DriverProvider {
    private static WebDriver instance;

    public static WebDriver getInstance() { return instance; }

    public static void setInstance(WebDriver driver) {
        if(instance == null) {
            instance = driver;
        }
    }
}