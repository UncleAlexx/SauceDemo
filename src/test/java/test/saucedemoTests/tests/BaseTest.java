package test.saucedemoTests.tests;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import test.saucedemoTests.pages.*;

public abstract class BaseTest {

    private static final String HEADLESS_EDGE_ARGUMENT = "--headless";
    private static final String START_MAXIMIZED_EDGE_ARGUMENT = "--start-maximized";
    protected static final String VALID_LOGIN_PAGE_USERNAME = "standard_user";
    protected static final String VALID_LOGIN_PAGE_PASSWORD = "secret_sauce";
    protected static final String INVALID_LOGIN_PAGE_USERNAME = "standard_user1";
    protected static final String INVALID_LOGIN_PAGE_PASSWORD = "secret_sauce1";
    protected static final String VALID_CHECKOUT_STEP_ONE_PAGE_POSTAL_CODE = "333333";
    protected static final String VALID_CHECKOUT_STEP_ONE_PAGE_FIRST_NAME = "Alexander";
    protected static final String VALID_CHECKOUT_STEP_ONE_PAGE_LAST_NAME = "Gai";
    protected static final LoginPage loginPage;
    protected static final InventoryPage inventoryPage;
    protected static final CartPage  cartPage;
    protected static final CheckoutStepOnePage checkoutStepOnePage;
    protected static final CheckoutStepTwoPage checkoutStepTwoPage;

    static {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(HEADLESS_EDGE_ARGUMENT);
        options.addArguments(START_MAXIMIZED_EDGE_ARGUMENT);
        DriverProvider.setInstance(new EdgeDriver(options));

        cartPage = new CartPage(DriverProvider.getInstance());
        loginPage = new LoginPage(DriverProvider.getInstance());
        inventoryPage = new InventoryPage(DriverProvider.getInstance());
        checkoutStepOnePage = new CheckoutStepOnePage(DriverProvider.getInstance());
        checkoutStepTwoPage = new CheckoutStepTwoPage(DriverProvider.getInstance());
    }

    @BeforeMethod
    public void start(){
        DriverProvider.getInstance().get(BasePage.LOGIN_PAGE_URL);
    }

    @AfterSuite
    public void tearDown(){
        DriverProvider.getInstance().quit();
    }
}
