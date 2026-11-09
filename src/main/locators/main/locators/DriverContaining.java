
package main.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class DriverContaining {
    private static final EdgeOptions options;
    private static final String initialPath = "https://www.saucedemo.com";
    protected static WebDriver driver;

    static{
        options = new EdgeOptions();
        options.addArguments("--headless");
        options.addArguments("maximize");
        driver = new EdgeDriver(options);
        driver.get(initialPath);
    }
}
