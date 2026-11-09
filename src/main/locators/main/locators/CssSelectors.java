package main.locators;

import org.openqa.selenium.By;

public class CssSelectors extends DriverContaining {
        private static final By classSelector = By.cssSelector(".login_wrapper");
        private static final By elementWithTwoClassesSelector = By.cssSelector(".submit-button.btn_action");
        private static final By nestedClassInsideClassSelector = By.cssSelector(".form_group .input_error");
        private static final By idSelector = By.cssSelector("#user-name");
        private static final By tagSelector = By.cssSelector("meta");
        private static final By classInsideElementSelector = By.cssSelector("div.login_container");
        private static final By attributeSelector = By.cssSelector("[id='root']");
        private static final By attributeContainsWordSelector  = By.cssSelector("[class~='form_input']");
        private static final By attributeEqualsOrAttributeEqualsDashWithSomethingSelector = By.cssSelector(
                "[class|='login_wrapper']");
        private static final By attributeBeginsWithSelector = By.cssSelector("[id^='login_button']");
        private static final By attributeContainsSelector = By.cssSelector("[class *='-message-container']");
        private static final By attributeEndsSelector = By.cssSelector("[class $='input']");

        public static boolean allCssLocatorsExist(){
                driver.get("https://www.saucedemo.com");
            return !(driver.findElements(classSelector).isEmpty() || driver.findElements(
                elementWithTwoClassesSelector).isEmpty() || driver.findElements(nestedClassInsideClassSelector).
                isEmpty() || driver.findElements(idSelector).isEmpty() || driver.findElements(tagSelector).isEmpty() ||
                driver.findElements(classInsideElementSelector).isEmpty() || driver.findElements(attributeSelector).
                isEmpty() || driver.findElements(attributeBeginsWithSelector).isEmpty() || driver.findElements(
                attributeContainsSelector).isEmpty() || driver.findElements(attributeEndsSelector).isEmpty() || driver.
                findElements(attributeContainsWordSelector).isEmpty() || driver.findElements(
                attributeEqualsOrAttributeEqualsDashWithSomethingSelector).isEmpty());
        }
    }
