package main.locators;

import org.openqa.selenium.By;

public class XPathSelectors extends DriverContaining {
        private static final By attributeSelector = By.xpath("//*[@id='login_credentials']");
        private static final By textSelector = By.xpath("//*[text()='Accepted usernames are:']");
        private static final By containsSelector = By.xpath("//*[contains(@data-test, 'container')]");
        private static final By containsTextSelector = By.xpath("//*[contains(text(), " +
                "'enable JavaScript')]");
        private static final By ancestorSelector = By.xpath("//h4/ancestor::*[@id='root']");
        private static final By descendantSelector = By.xpath(
            "//body/descendant::h4[text() = 'Accepted usernames are:']");
        private static final By followingSelector = By.xpath("//*[@id='login_credentials']/following::" +
                "*[text()='Password for all users:']");
        private static final By parentSelector  = By.xpath("//div[@class = 'login_credentials_wrap-" +
                "inner']/parent::*");
        private static final By precedingSelector = By.xpath("//body/descendant::h4[text() = 'Accepted " +
                "usernames are:']/../../preceding::form[@aria-label='Login']");
        private static final By andSelector = By.xpath("//div[@class='login_wrapper' and @data-test = " +
                "'login-container' and @role ='main']");

        public static boolean allXpathLocatorsExist(){
                return !(driver.findElements(descendantSelector).isEmpty() || driver.findElements(
                followingSelector).isEmpty() || driver.findElements(parentSelector).isEmpty() || driver.findElements
                (precedingSelector).isEmpty() || driver.findElements(andSelector).isEmpty() || driver.findElements(
                ancestorSelector).isEmpty() || driver.findElements(containsSelector).isEmpty() || driver.
                findElements(containsTextSelector).isEmpty() || driver.findElements(textSelector).isEmpty() ||
                driver.findElements(attributeSelector).isEmpty());
        }
    }
