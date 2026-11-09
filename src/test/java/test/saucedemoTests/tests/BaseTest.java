package test.saucedemoTests.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.latest.bluetoothemulation.model.ScanRecord;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.saucedemoTests.pages.*;

public abstract class BaseTest {

    private static final EdgeOptions options;
    private static final String HEADLESS_EDGE_ARGUMENT = "--headless";
    private static final String START_MAXIMIZED_EDGE_ARGUMENT = "--start-maximized";
    protected static final String validLogin = "standard_user";
    protected static final String validPassword = "secret_sauce";
    protected static final String invalidLogin = "standard_user1";
    protected static final String invalidPassword = "secret_sauce1";
    protected static final String validPostCode = "standard_user";
    protected static final String validCheckoutStepOneLogin = "secret_sauce";
    protected static final String validCheckoutStepOnePassword = "standard_user1";

    protected static CartPage  cartPage;
    protected static LoginPage loginPage;
    protected static InventoryPage inventoryPage;
    protected static CheckoutStepOnePage checkoutStepOnePage;
    protected static CheckoutStepTwoPage ckeckoutStepTwoPage;

    private static WebDriver driver;

    static {
        options = new EdgeOptions();
        options.addArguments(HEADLESS_EDGE_ARGUMENT);
        options.addArguments(START_MAXIMIZED_EDGE_ARGUMENT);
    }

    @BeforeMethod
    public void start(){
        driver = new EdgeDriver(options);
        if(loginPage == null){
            loginPage = new LoginPage(driver);
            cartPage = new CartPage(driver);
            inventoryPage = new InventoryPage(driver);
            checkoutStepOnePage = new CheckoutStepOnePage(driver);
            ckeckoutStepTwoPage = new CheckoutStepTwoPage(driver);
        }
        cartPage.setDriver(driver);
        loginPage.setDriver(driver);
        inventoryPage.setDriver(driver);
        ckeckoutStepTwoPage.setDriver(driver);
        checkoutStepOnePage.setDriver(driver);
        driver.get(BasePage.LOGIN_PAGE_URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
