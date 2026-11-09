package test.cssSelectorTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import static org.testng.Assert.assertFalse;

public class XPathSelectorsTest extends BaseTest {
        private static final By attributeSelector = By.xpath("//*[@id='login_credentials']");
        private static final By textSelector = By.xpath("//*[text()='Accepted usernames are:']");
        private static final By containsSelector = By.xpath("//*[contains(@data-test, 'container')]");
        private static final By containsTextSelector = By.xpath("//*[contains(text(), " +
                "'enable JavaScript')]");
        private static final By ancestorSelector = By.xpath("//h4/ancestor::*[@id='root']");
        private static final By descendantSelector = By.xpath(
            "//body/descendant::h3[text()=\"Epic sadface: You can only access " +
            "'/dynamic-catalog-spinner.html' when you are logged in.\"]");
        private static final By followingSelector = By.xpath("//*[@id='login_credentials']/following::" +
                "*[text()='Password for all users:']");
        private static final By parentSelector  = By.xpath("//div[@class = 'login_credentials_wrap-" +
                "inner']/parent::*");
        private static final By precedingSelector = By.xpath("//*[text()=\"Epic sadface: You can only " +
                "access '/dynamic-catalog-spinner.html' when you are logged in.\"]/preceding::*[text()= 'You need " +
                "to enable JavaScript to run this app.']");
        private static final By andSelector = By.xpath("//div[@class='login_wrapper' and @data-test = " +
                "'login-container' and @role ='main']");

        @Test
        public void testLocators(){
                driver.get("https://www.saucedemo.com/");
            Assert.assertFalse(driver.findElements(descendantSelector).isEmpty() || driver.findElements(
                followingSelector).isEmpty() || driver.findElements(parentSelector).isEmpty() || driver.findElements
                (precedingSelector).isEmpty() || driver.findElements(andSelector).isEmpty() || driver.findElements(
                ancestorSelector).isEmpty() || driver.findElements(containsSelector).isEmpty() || driver.
                findElements(containsTextSelector).isEmpty() || driver.findElements(textSelector).isEmpty() ||
                driver.findElements(attributeSelector).isEmpty());
        }
    }
