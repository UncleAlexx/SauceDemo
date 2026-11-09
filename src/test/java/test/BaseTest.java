package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {

    private static final EdgeOptions options;
    protected WebDriver driver;


    static{
        options = new EdgeOptions();
        options.addArguments("--headless");
        options.addArguments("maximize");
    }

    @BeforeMethod
    public void start(){
        driver = new EdgeDriver(options);
        driver.get("www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
